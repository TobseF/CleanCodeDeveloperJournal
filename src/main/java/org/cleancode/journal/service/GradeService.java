package org.cleancode.journal.service;

import com.google.gson.Gson;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.server.VaadinService;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.defaultString;

@Service
public class GradeService implements IGradeService {

    private transient HashMap<String, GradeTopic> topics = new LinkedHashMap<>();
    private transient HashMap<GradeColor, Grade> grades = new LinkedHashMap<>();
    private transient List<GradeColor> allGrades = List.of(GradeColor.values());

    @PostConstruct
    private void loadGradesFromFile() {
        allGrades.forEach(this::loadGrade);
    }

    private void loadGrade(GradeColor gradeColor) {
        Gson gson = new Gson();
        String gradeFilePath = "/grades/en/grade_" + gradeColor.getNumber() + ".json";
        Grade grade = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(gradeFilePath)), Grade.class);
        grade.listAllGradeTopics().forEach(gradeTopic -> {
            gradeTopic.setGrade(grade);
            gradeTopic.setDescription(addLineBreaks(gradeTopic.getDescription()));
            topics.put(gradeTopic.getId(), gradeTopic);
        });
        grades.put(grade.getGradeColor(), grade);
    }

    @Override
    public GradeTopic loadGradeTopic(String gradeId, Locale locale) {
        return topics.get(gradeId);
    }


    @Override
    public Grade loadGrade(GradeColor gradeColor, Locale locale) {
        return grades.get(gradeColor);
    }

    @Override
    public List<Grade> loadAllGrades(Locale locale) {
        return allGrades.stream().map(color -> loadGrade(color, locale)).collect(toList());
    }

    @Override
    public Collection<GradeTopic> loadAllTopics(Locale locale) {
        return new ArrayList<>(topics.values());
    }

    @Override
    public Collection<GradeTopic> loadTopics(Locale locale, String filter) {
        return loadAllTopics(locale).stream().filter(topic -> filter(locale, topic, filter)).collect(toList());
    }

    private boolean filter(Locale locale, GradeTopic gradeTopic, String filter) {
        String search = defaultString(filter).toLowerCase();
        I18NProvider i18NProvider = VaadinService.getCurrent().getInstantiator().getI18NProvider();
        String gradeColor = i18NProvider.getTranslation(gradeTopic.getGrade().getGradeColor().getMessageKey(), locale);
        return contains(gradeTopic::getName, search) || contains(gradeTopic::getDescription, search)
                || contains(gradeTopic::getSectionWhy, search) || contains(() -> gradeColor, search);
    }

    private String addLineBreaks(String html) {
        return html.replace("\\n", System.lineSeparator());
    }

    private boolean contains(Supplier<String> getter, String search) {
        return getter.get().toLowerCase().contains(search);
    }

}

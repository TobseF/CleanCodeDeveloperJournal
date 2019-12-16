package org.cleancode.journal.service;

import com.google.gson.Gson;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

@Service
public class GradeService implements IGradeService {

    private HashMap<String, GradeTopic> topics = new HashMap<>();
    private HashMap<GradeColor, Grade> grades = new HashMap<>();
    private List<GradeColor> allGrades = List.of(GradeColor.Red, GradeColor.Orange);

    @PostConstruct
    private void loadGradesFromFile() {
        allGrades.forEach(this::loadGrade);
    }

    private void loadGrade(GradeColor gradeColor) {
        Gson gson = new Gson();
        String gradeFilePath = "/grades/de/grade_" + gradeColor.getNumber() + ".json";
        Grade grade = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(gradeFilePath)), Grade.class);
        grade.listAllGradeTopics().forEach(gradeTopic -> {
            gradeTopic.setGrade(grade);
            topics.put(gradeTopic.getId(), gradeTopic);
        });
        grades.put(grade.getGradeColor(), grade);
    }

    @Override
    public GradeTopic getGradeTopic(String gradeId, Locale locale) {
        return topics.get(gradeId);
    }


    @Override
    public Grade getGrade(GradeColor gradeColor, Locale locale) {
        return grades.get(gradeColor);
    }

    @Override
    public List<Grade> getAllGrades(Locale locale) {
        return allGrades.stream().map(color -> getGrade(color, locale)).collect(toList());
    }
}

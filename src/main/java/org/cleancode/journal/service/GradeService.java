package org.cleancode.journal.service;

import com.google.gson.Gson;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

@Service
public class GradeService implements IGradeService {

    private HashMap<String, GradeTopic> topics = new HashMap<>();
    private HashMap<GradeColor, Grade> grades = new HashMap<>();

    @PostConstruct
    private void loadGradesFromFile() {
        Gson gson = new Gson();
        Grade grade = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream("/grades/de/grade_1.json")), Grade.class);
        grade.listAllGradeTopics().stream().forEach(gradeTopic -> {
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
}

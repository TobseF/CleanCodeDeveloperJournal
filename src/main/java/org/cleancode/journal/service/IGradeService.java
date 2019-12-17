package org.cleancode.journal.service;

import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Service
public interface IGradeService extends Serializable {

    GradeTopic loadGradeTopic(String gradeId, Locale locale);

    Grade loadGrade(GradeColor gradeColor, Locale locale);

    List<Grade> loadAllGrades(Locale locale);

    Collection<GradeTopic> loadAllTopics(Locale locale);


    Collection<GradeTopic> loadTopics(Locale locale, String filter);


}

package org.cleancode.journal.service;

import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public interface IGradeService {


    GradeTopic getGradeTopic(String gradeId, Locale locale);

    Grade getGrade(GradeColor gradeColor, Locale locale);
}

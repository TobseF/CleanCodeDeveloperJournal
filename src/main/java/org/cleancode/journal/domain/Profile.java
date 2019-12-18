package org.cleancode.journal.domain;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.cleancode.journal.domain.grade.GradeColor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@VaadinSessionScope
public class Profile implements Serializable {
    private GradeColor currentGrade = GradeColor.Red;

    public GradeColor getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(GradeColor currentGrade) {
        this.currentGrade = currentGrade;
    }
}

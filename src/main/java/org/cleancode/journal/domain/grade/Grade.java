package org.cleancode.journal.domain.grade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Grade implements Serializable {

    private Locale locale;
    private GradeColor gradeColor;
    private int number;

    public List<GradeTopic> listAllGradeTopics() {
        return Stream.concat(principles.stream(), practices.stream()).collect(toList());
    }

    private List<Principle> principles = new ArrayList<>();
    private List<Practice> practices = new ArrayList<>();

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public GradeColor getGradeColor() {
        return gradeColor;
    }

    public void setGradeColor(GradeColor gradeColor) {
        this.gradeColor = gradeColor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Principle> getPrinciples() {
        return principles;
    }

    public void setPrinciples(List<Principle> principles) {
        this.principles = principles;
    }

    public void addPrinciples(Principle principle) {
        this.principles.add(principle);
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public void addPractice(Practice practice) {
        this.practices.add(practice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return number == grade.number && locale.equals(grade.locale) && gradeColor == grade.gradeColor && principles.equals(grade.principles) && practices.equals(grade.practices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, gradeColor, number, principles, practices);
    }

    @Override
    public String toString() {
        return gradeColor.toString();
    }
}

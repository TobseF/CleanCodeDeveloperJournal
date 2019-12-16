package org.cleancode.journal.domain.grade;

import java.io.Serializable;

public enum GradeColor implements Serializable {
    Black, Red, Orange, Yellow, Green, Blue, White;

    public int getNumber() {
        return ordinal();
    }

    @Override
    public String toString() {
        return "Grade " + ordinal() + " " + name();
    }
}

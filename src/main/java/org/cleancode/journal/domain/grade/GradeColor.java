package org.cleancode.journal.domain.grade;

public enum GradeColor {
    Black, Red, Orange, Yellow, Green, Blue, White;

    public int getNumber() {
        return ordinal();
    }
}

package org.cleancode.journal.domain.grade;

import java.io.Serializable;

public enum GradeColor implements Serializable {
    Black("domain.grade.color.back"), Red("domain.grade.color.red"), Orange("domain.grade.color.orange"), Yellow("domain.grade.color.yellow"), Green("domain.grade.color.green"), Blue("domain.grade.color.blue"), White("domain.grade.color.white");

    final String messageKey;

    public int getNumber() {
        return ordinal();
    }

    GradeColor(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "Grade " + ordinal() + " " + name();
    }

    public String getMessageKey() {
        return messageKey;
    }
}

package org.cleancode.journal.domain;

import java.io.Serializable;
import java.util.Objects;

public class LogEntry implements Serializable {
    private Type type;
    private String comment;

    public LogEntry(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isIrrelevant() {
        return type == Type.Irrelevant;
    }

    public boolean isFulfilled() {
        return type == Type.Fulfilled;
    }

    public boolean isIgnored() {
        return type == Type.Violated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LogEntry{" + "type=" + type + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return type == logEntry.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public enum Type {Irrelevant, Fulfilled, Violated}
}

package org.cleancode.journal.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry implements Serializable {

    private Type type;
    private String comment;
    private String topicId;
    private LocalDateTime dateTime;
    private Score score = new Score();

    public LogEntry(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LogEntry{" + "type=" + type + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry)) return false;
        LogEntry logEntry = (LogEntry) o;
        return type == logEntry.type && Objects.equals(comment, logEntry.comment) && topicId.equals(logEntry.topicId) && dateTime.equals(logEntry.dateTime) && score.equals(logEntry.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, comment, topicId, dateTime, score);
    }

    public enum Type {Irrelevant, Fulfilled, Violated, Achievement}
}

package org.cleancode.journal.domain;

import org.cleancode.journal.util.ToStringUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day implements Comparable<Day> {

    private final LocalDate date;
    private List<LogEntry> logEntries = new ArrayList<>();

    public Day(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void addLogEntry(LogEntry logEntry) {
        logEntries.add(logEntry);
    }

    public Type getType() {
        if (logEntries.isEmpty()) {
            return Type.Empty;
        } else if (logEntries.stream().allMatch(LogEntry::isFulfilled)) {
            return Type.Fulfilled;
        }
        return Type.PartialFulfilled;
    }

    @Override
    public int compareTo(Day o) {
        return date.compareTo(o.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return date.equals(day.date) && logEntries.equals(day.logEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, logEntries);
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(date) + ":" + logEntries.size();
    }

    public enum Type {Empty, Fulfilled, PartialFulfilled}


}

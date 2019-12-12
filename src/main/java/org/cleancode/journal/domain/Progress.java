package org.cleancode.journal.domain;

import org.cleancode.journal.util.ToStringUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Progress {

    private final int size;
    private LocalDate start;
    private List<Day> days = new ArrayList<>();

    public Progress(int size, LocalDate start) {
        this.size = size;
        this.start = start;
    }

    public List<Day> getAllDays() {
        return IntStream.range(0, size).mapToObj(this::getDay).collect(toList());
    }

    public Day getDay(int dayOfProgress) {
        if (dayOfProgress < 0) {
            throw new IllegalArgumentException("dayOfProgress cant be < 0");
        }
        LocalDate dayToSearch = start.plusDays(dayOfProgress);
        return days.stream().filter(day -> day.getDate().equals(dayToSearch)).findFirst().orElse(new Day(dayToSearch));
    }

    public int getSize() {
        return size;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public void addDay(Day day) {
        days.add(day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Progress progress = (Progress) o;
        return days.equals(progress.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days);
    }

    @Override
    public String toString() {
        return "Started: " + ToStringUtil.toString(start) + " Days: " + days;
    }
}

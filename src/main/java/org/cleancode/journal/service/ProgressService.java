package org.cleancode.journal.service;

import org.cleancode.journal.domain.Day;
import org.cleancode.journal.domain.LogEntry;
import org.cleancode.journal.domain.Progress;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

@Service
public class ProgressService implements IProgressService {

    @Override
    public Progress getCurrentProgress() {
        return getSampleProgress();
    }

    private Progress getSampleProgress() {
        Progress progress = new Progress(21, LocalDate.now().minusDays(12));

        range(1, 16).mapToObj(progress::getDay).peek(this::setDayFulfilled).forEach(progress::addDay);
        IntStream.of(4, 8, 10, 13).mapToObj(progress::getDay).peek(this::setDayPartialFulfilled).forEach(progress::addDay);

        return progress;
    }

    private void setDayFulfilled(Day day) {
        day.addLogEntry(new LogEntry(LogEntry.Type.Fulfilled));
    }

    private void setDayPartialFulfilled(Day day) {
        day.addLogEntry(new LogEntry(LogEntry.Type.Fulfilled));
        day.addLogEntry(new LogEntry(LogEntry.Type.Ignored));
    }

}

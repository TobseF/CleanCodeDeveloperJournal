package org.cleancode.journal.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class GradeProgressBar extends FlexLayout {

    private final int dayWidth = 10;
    private final int minimalDayGap = 4;
    private final int maximalDayGap = 16;

    private List<ProgressDay> days = new ArrayList<>();

    public GradeProgressBar() {
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.EVENLY);
        setAlignItems(Alignment.END);
        addClassName("grade-progress");
        setWidthFull();
    }

    public void setDays(List<ProgressDay> days) {
        this.days = days;

        setMinWidth((days.size() * (dayWidth + minimalDayGap)) + "px");
        setMaxWidth((days.size() * (dayWidth + maximalDayGap)) + "px");

        days.forEach(this::add);
    }

    public static class ProgressDay extends Div {

        private Progress progress;

        public ProgressDay(String tooltip) {
            this(Progress.Future);
            addToolTip(tooltip);
        }

        public ProgressDay(Progress progress) {
            setProgress(progress);
        }

        private void addToolTip(String tooltip) {
            addClassName("tooltip");
            Span span = new Span(tooltip);
            span.addClassName("tooltiptext");
            span.addClassName("tooltip-bottom");
            add(span);
        }

        public void setProgress(Progress progress) {
            this.progress = progress;
            removeAllStyles();
            addClassName("grade-progress-day");
            addClassName(progress.getClassName());
        }

        public void removeAllStyles() {
            stream(Progress.values()).map(Progress::getClassName).forEach(this::removeClassName);
        }

        public enum Progress {
            Unknown, Submitted, SubmittedOK, Future;

            public String getClassName() {
                return "day-" + name().toLowerCase();
            }

        }
    }

}

package org.cleancode.journal.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import java.util.List;

public class GradeProgressBar extends FlexLayout {

    public GradeProgressBar() {
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.EVENLY);
        setAlignItems(Alignment.END);
        addClassName("grade-progress");
    }

    public void setDays(List<ProgressDay> days) {
        days.forEach(this::add);
    }

    public void addDay(ProgressDay day) {
        add(day);
    }

    public static class ProgressDay extends Div {

        public ProgressDay(String tooltip) {
            addClassName("grade-progress-day");
            addToolTip(tooltip);
        }

        private void addToolTip(String tooltip) {
            addClassName("tooltip");
            Span span = new Span(tooltip);
            span.addClassName("tooltiptext");
            span.addClassName("tooltip-bottom");
            add(span);
        }

        public void setDaySubmitted() {
            addClassName("day-submitted");
        }

        public void setDayInFuture() {
            addClassName("day-future");
        }

    }

}

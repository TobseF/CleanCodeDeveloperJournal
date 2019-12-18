package org.cleancode.journal.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.component.GradeProgressBar;
import org.cleancode.journal.component.GradeProgressBar.ProgressDay;
import org.cleancode.journal.domain.Day;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.Progress;
import org.cleancode.journal.service.GradeService;
import org.cleancode.journal.service.IProgressService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Route(layout = MainView.class)
public class JournalView extends VerticalLayout {
    private final IProgressService progressService;

    public JournalView(IProgressService progressService, GradeService gradeService, Profile profile) {
        this.progressService = progressService;

        HorizontalLayout gradeStatusBar = new HorizontalLayout();
        gradeStatusBar.setAlignItems(Alignment.CENTER);
        gradeStatusBar.setWidthFull();
        add(gradeStatusBar);

        H1 grade = new H1(getTranslation(profile.getCurrentGrade().getMessageKey()));
        gradeStatusBar.add(grade);

        GradeProgressBar progressBar = new GradeProgressBar();
        gradeStatusBar.add(progressBar);
        progressBar.setDays(mapEntityToUiModel(progressService.getCurrentProgress()));

        add(new AddSpeedDial());
    }

    private List<ProgressDay> mapEntityToUiModel(Progress progress) {
        return progress.getAllDays().stream().map(this::mapEntityToUiModel).collect(toList());
    }

    private ProgressDay mapEntityToUiModel(Day day) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy").withLocale(getLocale());

        ProgressDay progressDay = new ProgressDay(formatter.format(day.getDate()));
        switch (day.getType()) {
            case Empty:
                progressDay.setProgress(ProgressDay.Progress.Unknown);
                break;
            case Fulfilled:
                progressDay.setProgress(ProgressDay.Progress.SubmittedOK);
                break;
            case PartialFulfilled:
                progressDay.setProgress(ProgressDay.Progress.Submitted);
        }
        if (day.getDate().isAfter(LocalDate.now())) {
            progressDay.setProgress(ProgressDay.Progress.Future);
        }
        return progressDay;
    }

    @PostConstruct
    private void bind() {
        progressService.getCurrentProgress();

    }

}

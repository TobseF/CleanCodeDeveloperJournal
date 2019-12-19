package org.cleancode.journal.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.component.GradeProgressBar;
import org.cleancode.journal.component.GradeProgressBar.ProgressDay;
import org.cleancode.journal.component.StarRating;
import org.cleancode.journal.domain.Day;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.Progress;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
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

        GradeColor currentGrade = profile.getCurrentGrade();

        add(createStatusBar(currentGrade));

        addGradeOverview(gradeService, currentGrade);

        add(new AddSpeedDial());
    }

    private void addGradeOverview(GradeService gradeService, GradeColor currentGrade) {
        Grade grade = gradeService.loadGrade(currentGrade, getLocale());

        add(new H4(getTranslation("domain.grade.principles")));

        addGradeTopics(grade.getPrinciples());

        add(new H4(getTranslation("domain.grade.practices")));
        addGradeTopics(grade.getPractices());
    }

    public void addGradeTopics(List<? extends GradeTopic> topics) {
        topics.stream().map(this::createGradeTopicLine).forEach(this::add);
    }

    public HorizontalLayout createGradeTopicLine(GradeTopic topic) {
        HorizontalLayout line = new HorizontalLayout();

        line.setSizeFull();
        line.setMaxWidth("400px");
        line.setMinWidth("400px");

        StarRating favorite = new StarRating(0, 1);
        favorite.setSize("20px");
        line.add(favorite);

        Label name = new Label(topic.getName());
        line.add(name);

        Button open = new Button(new Icon(VaadinIcon.ANGLE_RIGHT));
        open.setMaxHeight("22px");
        open.setMaxWidth("10px");
        open.setWidth("10px");
        open.addClickListener(event -> openTopic(topic));
        line.add(open);
        line.setFlexGrow(1, name);
        return line;
    }

    private void openTopic(GradeTopic topic) {
        UI.getCurrent().navigate(GradeView.class, topic.getId());
    }


    private HorizontalLayout createStatusBar(GradeColor currentGrade) {
        HorizontalLayout gradeStatusBar = new HorizontalLayout();
        gradeStatusBar.setAlignItems(Alignment.CENTER);
        gradeStatusBar.setWidthFull();

        H2 grade = new H2(getTranslation(currentGrade.getMessageKey()));
        gradeStatusBar.add(grade);

        GradeProgressBar progressBar = new GradeProgressBar();
        gradeStatusBar.add(progressBar);
        progressBar.setDays(mapEntityToUiModel(progressService.getCurrentProgress()));
        return gradeStatusBar;
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

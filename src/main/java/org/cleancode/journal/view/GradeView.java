package org.cleancode.journal.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.component.BackNavigation;
import org.cleancode.journal.component.StarRating;
import org.cleancode.journal.domain.grade.GradeRating;
import org.cleancode.journal.domain.grade.GradeRating.Rating;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.service.IGradeService;

import java.util.Locale;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Route(layout = MainView.class)
public class GradeView extends VerticalLayout implements HasUrlParameter<String> {

    private final H2 name;
    private final Label description;
    private final IGradeService gradeService;
    private final VerticalLayout ratings;

    public GradeView(IGradeService gradeService) {
        this.gradeService = gradeService;

        name = new H2(EMPTY);
        BackNavigation backNavigation = new BackNavigation();
        HorizontalLayout title = new HorizontalLayout(backNavigation, name);
        title.setAlignItems(Alignment.BASELINE);
        add(title);


        ratings = new VerticalLayout();
        ratings.setMaxWidth("320px");
        add(ratings);

        description = new Label();
        add(description);

        add(new AddSpeedDial());
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        GradeTopic gradeTopic = gradeService.loadGradeTopic(parameter, Locale.ENGLISH);
        if (gradeTopic != null) {
            bind(gradeTopic);
        }
    }

    public void bind(GradeTopic gradeTopic) {
        name.setText(gradeTopic.getName());
        description.getElement().setProperty("innerHTML", gradeTopic.getDescription());
        bind(gradeTopic.getGradeRating());
    }

    private void bind(GradeRating gradeRating) {
        ratings.add(createRatingLine(getTranslation("domain.grade.rating.evolvability"), gradeRating.getEvolvability()));
        ratings.add(createRatingLine(getTranslation("domain.grade.rating.correctness"), gradeRating.getCorrectness()));
        ratings.add(createRatingLine(getTranslation("domain.grade.rating.productionEfficiency"), gradeRating.getProductionEfficiency()));
        ratings.add(createRatingLine(getTranslation("domain.grade.rating.continuousImprovement"), gradeRating.getContinuousImprovement()));
        ratings.add(createRatingLine(getTranslation("domain.grade.rating.responsibility"), getTranslation(gradeRating.getResponsibility())));
    }

    private String getTranslation(GradeRating.Responsibility responsibility) {
        if (responsibility == GradeRating.Responsibility.SingleDev) {
            return getTranslation("domain.grade.rating.responsibility.singe-dev");
        } else {
            return getTranslation("domain.grade.rating.responsibility.team");
        }
    }

    private Component createRatingLine(String text, Rating rating) {
        HorizontalLayout ratingLine = createRatingLine(text);
        StarRating starRating = new StarRating(rating);
        starRating.setSize("20px");
        ratingLine.add(starRating);
        return ratingLine;
    }

    private Component createRatingLine(String text, String type) {
        HorizontalLayout ratingLine = createRatingLine(text);
        ratingLine.add(new Label(type));
        return ratingLine;
    }

    private HorizontalLayout createRatingLine(String text) {
        HorizontalLayout ratingLine = new HorizontalLayout();
        ratingLine.setSpacing(false);
        ratingLine.setJustifyContentMode(BETWEEN);
        ratingLine.setSizeFull();
        Label label = new Label(text);
        ratingLine.add(label);
        return ratingLine;
    }
}

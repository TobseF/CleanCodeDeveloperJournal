package org.cleancode.journal;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

@Route(layout = MainView.class)
public class CompendiumView extends VerticalLayout {

    private final Accordion accordion;

    @Autowired
    public CompendiumView(IGradeService gradeService) {
        add(new H2(getTranslation("app.menu.compendium ")));

        accordion = new Accordion();
        add(accordion);

        List<Grade> grades = List.of(gradeService.getGrade(GradeColor.Red, Locale.ENGLISH));

        grades.forEach(this::addGrade);
    }

    public void addGrade(Grade grade) {

        Accordion gradeOverview = new Accordion();

        VerticalLayout principlesLinks = new VerticalLayout();
        grade.getPrinciples().stream().map(this::createAnchor).forEach(principlesLinks::add);

        VerticalLayout practicesLinks = new VerticalLayout();
        grade.getPractices().stream().map(this::createAnchor).forEach(practicesLinks::add);

        gradeOverview.add("Principles", principlesLinks);
        gradeOverview.add("Practices", practicesLinks);
        accordion.add(grade.getGradeColor().name(), gradeOverview);
    }

    private Anchor createAnchor(GradeTopic topic) {
        String route = UI.getCurrent().getRouter().getUrl(GradeView.class, topic.getId());
        return new Anchor(route, topic.getName());
    }

}

package org.cleancode.journal;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.cleancode.journal.domain.grade.Grade;
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
        add(new H2(getTranslation("app.menu.compendium")));

        accordion = new Accordion();
        add(accordion);

        List<Grade> grades = gradeService.getAllGrades(Locale.ENGLISH);

        grades.forEach(this::addGrade);
    }

    public void addGrade(Grade grade) {

        Accordion gradeOverview = new Accordion();

        VerticalLayout principlesLinks = new VerticalLayout();
        grade.getPrinciples().stream().map(this::createAnchor).forEach(principlesLinks::add);

        VerticalLayout practicesLinks = new VerticalLayout();
        grade.getPractices().stream().map(this::createAnchor).forEach(practicesLinks::add);

        gradeOverview.add(getTranslation("domain.grade.principles"), principlesLinks);
        gradeOverview.add(getTranslation("domain.grade.practices"), practicesLinks);
        String gradeName = getTranslation("compendium.grade", grade.getGradeColor().getNumber(), grade.getGradeColor().name());
        accordion.add(gradeName, gradeOverview);
    }

    private RouterLink createAnchor(GradeTopic topic) {
        return new RouterLink(topic.getName(), GradeView.class, topic.getId());
    }

}

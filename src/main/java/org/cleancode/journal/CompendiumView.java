package org.cleancode.journal;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

import static com.vaadin.flow.data.provider.SortDirection.ASCENDING;

@Route(layout = MainView.class)
public class CompendiumView extends VerticalLayout {

    private final Accordion tree;
    private final Grid<GradeTopic> table;
    private final ViewMode defaultViewMode = ViewMode.Table;

    @Autowired
    public CompendiumView(IGradeService gradeService) {
        add(new H2(getTranslation("app.menu.compendium")));
        setHeightFull();

        addModeSelect();
        table = creteTable(gradeService);
        add(table);
        tree = createTree(gradeService);
        add(tree);

        setViewMode(defaultViewMode);
    }

    private void addModeSelect() {
        Select<ViewMode> modeSelect = new Select<>();
        modeSelect.setItems(ViewMode.values());
        modeSelect.setValue(defaultViewMode);
        modeSelect.setLabel(getTranslation("compendium.mode"));
        modeSelect.addValueChangeListener(event -> setViewMode(event.getValue()));
        add(modeSelect);
    }

    private Accordion createTree(IGradeService gradeService) {
        Accordion tree = new Accordion();
        List<Grade> grades = gradeService.getAllGrades(Locale.ENGLISH);
        grades.forEach(grade -> addGrade(tree, grade));
        tree.close();
        return tree;
    }

    private Grid<GradeTopic> creteTable(IGradeService gradeService) {
        Grid<GradeTopic> table = new Grid<>();
        table.setItems(gradeService.getAllTopics(Locale.ENGLISH));

        Grid.Column<GradeTopic> columnName = table.addColumn(GradeTopic::getName).
                setHeader(getTranslation("domain.grade.name")).
                setSortable(true);

        table.addColumn(this::formatTopic).
                setHeader(getTranslation("domain.grade.grade")).
                setSortable(true);

        table.addColumn(topic -> topic.getGradeRating().getResponsibility()).
                setHeader(getTranslation("domain.grade.rating.responsibility")).
                setSortable(true);

        table.sort(List.of(new GridSortOrder<>(columnName, ASCENDING)));

        table.addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(this::openGradeTopic));
        return table;
    }

    private String formatTopic(GradeTopic topic) {
        Grade grade = topic.getGrade();
        String gradeColor = getTranslation(grade.getGradeColor().getMessageKey());
        return grade.getNumber() + " " + gradeColor;
    }

    public void setViewMode(ViewMode viewMode) {
        table.setVisible(false);
        tree.setVisible(false);
        switch (viewMode) {
            case Table:
                table.setVisible(true);
                break;
            case Tree:
                tree.setVisible(true);
                break;
        }
    }

    public void addGrade(Accordion tree, Grade grade) {

        Accordion gradeOverview = new Accordion();
        gradeOverview.close();

        VerticalLayout principlesLinks = new VerticalLayout();
        grade.getPrinciples().stream().map(this::createAnchor).forEach(principlesLinks::add);

        VerticalLayout practicesLinks = new VerticalLayout();
        grade.getPractices().stream().map(this::createAnchor).forEach(practicesLinks::add);

        gradeOverview.add(getTranslation("domain.grade.principles"), principlesLinks);
        gradeOverview.add(getTranslation("domain.grade.practices"), practicesLinks);
        String gradeName = getTranslation("compendium.grade", grade.getGradeColor().getNumber(), grade.getGradeColor().name());
        tree.add(gradeName, gradeOverview);
    }

    public void openGradeTopic(GradeTopic topic) {
        UI.getCurrent().navigate(GradeView.class, topic.getId());
    }

    enum ViewMode {Tree, Table}

    private RouterLink createAnchor(GradeTopic topic) {
        return new RouterLink(topic.getName(), GradeView.class, topic.getId());
    }


}

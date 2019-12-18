package org.cleancode.journal.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.grade.Grade;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.domain.grade.Practice;
import org.cleancode.journal.domain.grade.Principle;
import org.cleancode.journal.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.vaadin.flow.data.provider.SortDirection.ASCENDING;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Route(layout = MainView.class)
public class CompendiumView extends VerticalLayout {

    private final ViewMode defaultViewMode = ViewMode.Table;
    private final Grid<GradeTopic> table;
    private Accordion tree;

    @Autowired
    public CompendiumView(IGradeService gradeService) {
        setHeightFull();

        HorizontalLayout controls = new HorizontalLayout();
        add(controls);
        controls.add(createModeSelect());

        controls.add(createFilter(gradeService));

        Collection<GradeTopic> gradeTopics = gradeService.loadAllTopics(getLocale());
        table = creteTable(gradeTopics);
        add(table);
        tree = createTree(gradeTopics);
        add(tree);

        setViewMode(defaultViewMode);

        add(new AddSpeedDial());
    }

    private TextField createFilter(IGradeService gradeService) {
        TextField filter = new TextField();
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.setLabel(getTranslation("compendium.filter"));
        filter.setPlaceholder("compendium.search-placeholder");
        filter.addValueChangeListener(event -> filter(event.getValue(), gradeService));
        return filter;
    }

    public void filter(String filterText, IGradeService gradeService) {
        Collection<GradeTopic> filteredTopics = gradeService.loadTopics(getLocale(), filterText);
        table.setItems(filteredTopics);

        Accordion newTree = createTree(filteredTopics);
        newTree.setVisible(tree.isVisible());
        replace(this.tree, newTree);
        tree = newTree;
    }

    private Select<ViewMode> createModeSelect() {
        Select<ViewMode> modeSelect = new Select<>();
        modeSelect.setItems(ViewMode.values());
        modeSelect.setValue(defaultViewMode);
        modeSelect.setLabel(getTranslation("compendium.mode"));
        modeSelect.addValueChangeListener(event -> setViewMode(event.getValue()));
        return modeSelect;
    }

    private Accordion createTree(Collection<GradeTopic> gradeTopics) {
        Accordion tree = new Accordion();
        Map<Grade, List<GradeTopic>> groupedTopics = gradeTopics.stream().collect(groupingBy(GradeTopic::getGrade));
        groupedTopics.keySet().stream().sorted(reverseOrder()).forEach(grade -> addGrade(tree, grade, groupedTopics.get(grade)));

        tree.close();
        return tree;
    }

    private Grid<GradeTopic> creteTable(Collection<GradeTopic> gradeTopics) {
        Grid<GradeTopic> table = new Grid<>();
        table.setItems(gradeTopics);

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

    public void addGrade(Accordion tree, Grade grade, Collection<GradeTopic> gradeTopics) {

        Accordion gradeOverview = new Accordion();
        gradeOverview.close();

        VerticalLayout principlesGroup = new VerticalLayout();
        List<GradeTopic> principles = gradeTopics.stream().filter(topic -> topic instanceof Principle).collect(toList());
        principles.stream().map(this::createAnchor).forEach(principlesGroup::add);

        VerticalLayout practicesGroup = new VerticalLayout();
        List<GradeTopic> practices = gradeTopics.stream().filter(topic -> topic instanceof Practice).collect(toList());
        practices.stream().map(this::createAnchor).forEach(practicesGroup::add);

        if (!principles.isEmpty()) {
            gradeOverview.add(getTranslation("domain.grade.principles"), principlesGroup);
        }
        if (!practices.isEmpty()) {
            gradeOverview.add(getTranslation("domain.grade.practices"), practicesGroup);
        }
        String gradeName = getTranslation("compendium.grade", grade.getGradeColor().getNumber(), grade.getGradeColor().name());
        tree.add(gradeName, gradeOverview);
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

    private enum ViewMode {Tree, Table}

    public void openGradeTopic(GradeTopic topic) {
        UI.getCurrent().navigate(GradeView.class, topic.getId());
    }

    private RouterLink createAnchor(GradeTopic topic) {
        return new RouterLink(topic.getName(), GradeView.class, topic.getId());
    }


}

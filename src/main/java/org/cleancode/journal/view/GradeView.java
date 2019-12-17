package org.cleancode.journal.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.service.IGradeService;

import java.util.Locale;

@Route(layout = MainView.class)
public class GradeView extends VerticalLayout implements HasUrlParameter<String> {

    private final H1 name;
    private final Label description;
    private final IGradeService gradeService;

    public GradeView(IGradeService gradeService) {
        this.gradeService = gradeService;

        name = new H1("");
        add(name);

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
    }
}

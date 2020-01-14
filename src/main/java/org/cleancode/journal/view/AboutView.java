package org.cleancode.journal.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.speeddial.AddSpeedDial;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;

@Route(layout = MainView.class)
@PageTitle("Clean Code - About")
public class AboutView extends Composite<VerticalLayout> {

    public AboutView(Profile profile, IGradeService gradeService, IAchievementService achievementService) {

        var content = getContent();

        HorizontalLayout line = new HorizontalLayout();
        line.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        line.add(new Button("A"));
        line.add(new Button("B"));
        line.setSizeFull();
        content.add(line);

        content.add(new Html(getTranslation("about.info")));
        content.add(new Html(getTranslation("about.info.technical")));
        content.add(new Html(getTranslation("about.info.tanks")));
        content.add(new Html(getTranslation("about.info.free")));
        content.add(new Html(getTranslation("about.info.sourcecode")));
        content.add(new AddSpeedDial(profile, gradeService, achievementService));
    }
}

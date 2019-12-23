package org.cleancode.journal.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;

@Route(layout = MainView.class)
public class AboutView extends VerticalLayout {

    public AboutView(Profile profile, IGradeService gradeService, IAchievementService achievementService) {
        add(new Label("Lorem ipsum"));
        add(new AddSpeedDial(profile, gradeService, achievementService));
    }
}

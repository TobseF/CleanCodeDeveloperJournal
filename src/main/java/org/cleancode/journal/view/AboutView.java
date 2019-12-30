package org.cleancode.journal.view;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;

@Route(layout = MainView.class)
public class AboutView extends VerticalLayout {

    public AboutView(Profile profile, IGradeService gradeService, IAchievementService achievementService) {
        add(new Html(getTranslation("about.info")));
        add(new Html(getTranslation("about.info.technical")));
        add(new Html(getTranslation("about.info.tanks")));
        add(new Html(getTranslation("about.info.free")));
        add(new Html(getTranslation("about.info.sourcecode")));
        add(new AddSpeedDial(profile, gradeService, achievementService));
    }
}

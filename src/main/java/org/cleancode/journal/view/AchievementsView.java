package org.cleancode.journal.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.GradeService;
import org.cleancode.journal.service.IGradeService;

@Route(layout = MainView.class)
public class AchievementsView extends VerticalLayout {

    public AchievementsView(Profile profile, IGradeService gradeService) {
        for (int i = 0; i < 25; i++) {
            add(new AchievementLineView());
        }

        add(new AddSpeedDial(profile, gradeService));
    }
}

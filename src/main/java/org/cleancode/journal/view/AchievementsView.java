package org.cleancode.journal.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;

@Route(layout = MainView.class)
public class AchievementsView extends VerticalLayout {

    public AchievementsView() {
        for (int i = 0; i < 25; i++) {
            add(new AchievementLineView());
        }

        add(new AddSpeedDial());
    }
}

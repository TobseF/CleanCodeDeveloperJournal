package org.cleancode.journal;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
public class AchievementsView extends VerticalLayout {

    public AchievementsView() {
        for (int i = 0; i < 25; i++) {
            add(new AchievementLineView());
        }

    }
}

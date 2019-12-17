package org.cleancode.journal.view;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class AchievementLineView extends HorizontalLayout {
    public AchievementLineView() {
        add(new Icon(VaadinIcon.STAR));
        add(new Label("Lorem Ipsum"));
        Checkbox solved = new Checkbox();
        solved.setEnabled(false);
        add(solved);
    }
}

package org.cleancode.journal.component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class BackNavigation extends Icon {
    public BackNavigation() {
        super(VaadinIcon.ARROW_CIRCLE_LEFT);
        addClickListener(event -> UI.getCurrent().getPage().getHistory().back());
    }
}

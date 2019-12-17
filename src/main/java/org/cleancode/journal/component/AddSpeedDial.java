package org.cleancode.journal.component;

import com.vaadin.flow.component.icon.VaadinIcon;

public class AddSpeedDial extends SpeedDial {
    public AddSpeedDial() {
        setBackdrop(false);
        addMenuItem("Test 1", VaadinIcon.STAR.create(), event -> System.out.println("Lorem action"));
        addMenuItem("Test 2", VaadinIcon.NOTEBOOK.create(), event -> System.out.println("Ipsum action"));
    }
}

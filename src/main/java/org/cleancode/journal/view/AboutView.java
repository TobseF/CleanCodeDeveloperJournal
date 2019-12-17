package org.cleancode.journal.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;

@Route(layout = MainView.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        add(new Label("Lorem ipsum"));
        add(new AddSpeedDial());
    }
}

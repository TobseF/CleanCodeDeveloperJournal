package org.cleancode.journal.component;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;

/**
 * Shows name of the current page as Hading. Example: ({@code - Profile} ).<br>
 * Used ad minimal one level breadcrumb.
 */
public class SingleBreadcrumb extends H4 implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        String location = event.getLocation().getFirstSegment();
        if ("journal".equals(location) || location.isEmpty()) {
            setVisible(false);
        } else {
            setVisible(true);
            setText("- " + getTranslation("app.menu." + location));
        }
    }
}

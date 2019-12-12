package org.cleancode.journal;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

//@PreserveOnRefresh
@Route
@PWA(name = "Clean Code Developer Journal", shortName = "Clean Code Journal")
public class MainView extends AppLayout {

    public MainView() {
        final DrawerToggle drawerToggle = new DrawerToggle();

        final RouterLink profile = new RouterLink(getTranslation("app.menu.profile"), ProfileView.class);
        final RouterLink achievements = new RouterLink(getTranslation("app.menu.achievements"), AchievementsView.class);
        final RouterLink about = new RouterLink(getTranslation("app.menu.about"), AboutView.class);
        final VerticalLayout menuLayout = new VerticalLayout(profile, achievements, about);
        addToDrawer(menuLayout);
        addToNavbar(drawerToggle);
        addToNavbar(new H4(getTranslation("app.name")));
    }


}

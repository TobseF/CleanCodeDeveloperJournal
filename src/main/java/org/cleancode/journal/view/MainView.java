package org.cleancode.journal.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;

//@PreserveOnRefresh
@Route
@CssImport("./styles/shared-styles.css")
@Theme(value = Material.class, variant = Lumo.DARK)
@PWA(name = "Clean Code Developer Journal", shortName = "Clean Code Journal")
public class MainView extends AppLayout {

    public MainView() {
        final DrawerToggle drawerToggle = new DrawerToggle();

        final RouterLink journal = new RouterLink(getTranslation("app.menu.journal"), JournalView.class);
        final RouterLink profile = new RouterLink(getTranslation("app.menu.profile"), ProfileView.class);
        final RouterLink achievements = new RouterLink(getTranslation("app.menu.achievements"), AchievementsView.class);
        final RouterLink compendium = new RouterLink(getTranslation("app.menu.compendium"), CompendiumView.class);
        final RouterLink about = new RouterLink(getTranslation("app.menu.about"), AboutView.class);
        final VerticalLayout menuLayout = new VerticalLayout(journal, profile, achievements, compendium, about);
        addToDrawer(menuLayout);
        addToNavbar(drawerToggle);
        addToNavbar(new H4(getTranslation("app.name")));

    }


}

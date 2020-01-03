package org.cleancode.journal.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;

@CssImport("./styles/shared-styles.css")
@Theme(value = Material.class, variant = Lumo.DARK)
@PWA(name = "Clean Code Developer Journal", shortName = "Clean Code Journal")
public class MainView extends AppLayout {

    public MainView() {
        addToNavbar(new DrawerToggle());
        addToNavbar(new H4("Clean Code Journal"));
        addToDrawer(createMenuBar());
    }

    private VerticalLayout createMenuBar() {
        var journal = new RouterLink("Journal", JournalView.class);
        var profile = new RouterLink("Profil", ProfileView.class);
        var achievements = new RouterLink("Erfolge", AchievementsView.class);
        var compendium = new RouterLink("Kompendium", CompendiumView.class);
        var about = new RouterLink("Über", AboutView.class);
        return new VerticalLayout(journal, profile, achievements, compendium, about);
    }

}

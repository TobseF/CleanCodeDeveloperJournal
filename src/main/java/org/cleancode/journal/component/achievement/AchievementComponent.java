package org.cleancode.journal.component.achievement;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.shared.Registration;

@Tag("achievement-line")
@JsModule("./src/achievement.js")
@NpmPackage(value = "@polymer/iron-icons", version = "3.0.0")
public class AchievementComponent extends PolymerTemplate<AchievementModel> {

    private final String achievementId;

    public AchievementComponent(String achievementId) {
        this.achievementId = achievementId;
        setId("achievement");
    }

    public String getAchievementId() {
        return achievementId;
    }

    @Override
    public AchievementModel getModel() {
        return super.getModel();
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }

    @DomEvent("click")
    public static class ClickEvent extends ComponentEvent<AchievementComponent> {

        public ClickEvent(AchievementComponent source, boolean fromClient) {
            super(source, fromClient);
        }
    }
}

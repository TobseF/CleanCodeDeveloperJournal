package org.cleancode.journal.component.achievement;

import com.vaadin.flow.component.*;
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

        private int x, y;

        public ClickEvent(AchievementComponent source, boolean fromClient, @EventData("event.offsetX") int x, @EventData("event.offsetY") int y) {
            super(source, fromClient);
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}

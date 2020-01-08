package org.cleancode.journal.component.achievement;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.shared.Registration;

@Tag("achievement-line")
@JsModule("./src/achievement.js")
@NpmPackage(value = "@polymer/iron-icons", version = "3.0.0")
public class AchievementComponent extends PolymerTemplate<AchievementModel> {

    public AchievementComponent() {
        setId("achievement");
    }

    @Override
    public AchievementModel getModel() {
        return super.getModel();
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }

}

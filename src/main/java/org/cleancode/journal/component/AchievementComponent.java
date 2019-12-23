package org.cleancode.journal.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("achievement-line")
@JsModule("./src/achievement.js")
public class AchievementComponent extends PolymerTemplate<AchievementModel> {

    public AchievementComponent() {
        setId("achievement");
    }

    @Override
    public AchievementModel getModel() {
        return super.getModel();
    }
}

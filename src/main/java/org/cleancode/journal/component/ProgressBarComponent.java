package org.cleancode.journal.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("progress-bar")
@JsModule("./src/progress-bar.js")
public class ProgressBarComponent extends PolymerTemplate<ProgressBarModel> {

    public ProgressBarComponent() {
        setId("progressbar");
        setWidth("100%");
    }

    public void setWidth(String size) {
        getElement().getStyle().set("width", size);
    }

    @Override
    public ProgressBarModel getModel() {
        return super.getModel();
    }
}

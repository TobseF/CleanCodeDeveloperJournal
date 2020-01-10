package org.cleancode.journal.component.logentry;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("log-entry")
@JsModule("./src/log-entry.js")
public class LogEntryComponent extends PolymerTemplate<LogEntryModel> {

    public LogEntryComponent() {
        setId("logentry");
    }

    @Override
    public LogEntryModel getModel() {
        return super.getModel();
    }

}

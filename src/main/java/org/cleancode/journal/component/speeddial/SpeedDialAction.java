package org.cleancode.journal.component.speeddial;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

@Tag("paper-fab-speed-dial-action")
@NpmPackage(value = "@cwmr/paper-fab-speed-dial", version = "3.0.0")
@JsModule("@cwmr/paper-fab-speed-dial/paper-fab-speed-dial-action.js")
public class SpeedDialAction extends Label implements HasEnabled {

    public SpeedDialAction(String text, Icon icon) {
        super(text);
        setIcon(icon);
    }

    private Element setIcon(Icon icon) {
        String iconAttribute = icon.getElement().getAttribute("icon");
        return getElement().setAttribute("icon", iconAttribute);
    }

    public Registration addClickListener(ComponentEventListener<SpeedDialActionClickEvent> listener) {
        return addListener(SpeedDialActionClickEvent.class, listener);
    }

}

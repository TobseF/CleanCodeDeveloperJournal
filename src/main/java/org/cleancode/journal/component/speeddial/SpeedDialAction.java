package org.cleancode.journal.component.speeddial;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

import static org.cleancode.journal.util.IconUtil.getIcon;

@Tag("paper-fab-speed-dial-action")
@NpmPackage(value = "@cwmr/paper-fab-speed-dial", version = "3.0.0")
@JsModule("@cwmr/paper-fab-speed-dial/paper-fab-speed-dial-action.js")
public class SpeedDialAction extends Label implements HasEnabled {

    public SpeedDialAction(String text, Icon icon) {
        super(text);
        setIcon(icon);
    }

    private Element setIcon(Icon icon) {
        return getElement().setAttribute("icon", getIcon(icon));
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }

    @DomEvent("click")
    public static class ClickEvent extends ComponentEvent<SpeedDialAction> {

        public ClickEvent(SpeedDialAction source, boolean fromClient) {
            super(source, fromClient);
        }

    }
}

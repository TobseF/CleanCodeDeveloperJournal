package org.cleancode.journal.component.speeddial;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.shared.Registration;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Tag("paper-fab-speed-dial")
@NpmPackage(value = "@cwmr/paper-fab-speed-dial", version = "3.0.0")
@JsModule("@cwmr/paper-fab-speed-dial/paper-fab-speed-dial.js")
public class SpeedDial extends Component implements HasEnabled {

    public SpeedDialAction addMenuItem(String item, Icon icon) {
        SpeedDialAction speedDialAction = new SpeedDialAction(item, icon);
        getElement().appendChild(speedDialAction.getElement());
        return speedDialAction;
    }

    public SpeedDialAction addMenuItem(String item, Icon icon, ComponentEventListener<SpeedDialAction.ClickEvent> listener) {
        SpeedDialAction speedDialAction = addMenuItem(item, icon);
        speedDialAction.addClickListener(listener);
        return speedDialAction;
    }

    @Synchronize("opened-changed")
    public boolean isOpened() {
        return getElement().getProperty("opened", false);
    }

    public void setBackdrop(boolean backdrop) {
        if (backdrop) {
            getElement().setAttribute("with-backdrop", EMPTY);
        } else {
            getElement().removeAttribute("with-backdrop");
        }
    }

    public void close() {
        getElement().setProperty("opened", false);
    }

    public void open() {
        getElement().setProperty("opened", true);
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (enabled) {
            getElement().setAttribute("disabled", "disabled");
        } else {
            getElement().removeAttribute("disabled");
        }
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }


    @DomEvent("click")
    public static class ClickEvent extends ComponentEvent<SpeedDial> {

        private int x, y;

        public ClickEvent(SpeedDial source, boolean fromClient, @EventData("event.offsetX") int x, @EventData("event.offsetY") int y) {
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

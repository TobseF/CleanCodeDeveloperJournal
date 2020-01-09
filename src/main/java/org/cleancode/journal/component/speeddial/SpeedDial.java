package org.cleancode.journal.component.speeddial;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.Icon;

@Tag("paper-fab-speed-dial")
@NpmPackage(value = "@cwmr/paper-fab-speed-dial", version = "3.0.0")
@JsModule("@cwmr/paper-fab-speed-dial/paper-fab-speed-dial.js")
public class SpeedDial extends Component {

    public SpeedDialAction addMenuItem(String item, Icon icon) {
        SpeedDialAction speedDialAction = new SpeedDialAction(item, icon);
        getElement().appendChild(speedDialAction.getElement());
        return speedDialAction;
    }

    public void setBackdrop(boolean backdrop) {
        if (backdrop) {
            getElement().setAttribute("with-backdrop", "");
        } else {
            getElement().removeAttribute("with-backdrop");
        }
    }

    public void close() {
        getElement().executeJs("this.opened=false");
    }

}

package org.cleancode.journal.component.speeddial;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("click")
public class SpeedDialActionClickEvent extends ComponentEvent<SpeedDialAction> {

    private int x, y;

    public SpeedDialActionClickEvent(SpeedDialAction source, boolean fromClient, @EventData("event.offsetX") int x, @EventData("event.offsetY") int y) {
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

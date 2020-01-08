package org.cleancode.journal.component.achievement;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("click")
public class ClickEvent extends ComponentEvent<AchievementComponent> {

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

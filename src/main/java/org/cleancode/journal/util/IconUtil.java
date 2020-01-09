package org.cleancode.journal.util;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class IconUtil {

    public static String getIcon(VaadinIcon icon) {
        return new Icon(icon).getElement().getAttribute("icon");
    }
}

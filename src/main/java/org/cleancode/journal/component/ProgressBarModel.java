package org.cleancode.journal.component;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface ProgressBarModel extends TemplateModel {

    String getDescription();

    void setDescription(String description);

    String getValue();

    void setValue(String value);

    String getLabel();

    void setLabel(String label);

    int getPercent();

    void setPercent(int percent);

}

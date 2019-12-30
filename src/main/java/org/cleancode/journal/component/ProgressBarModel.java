package org.cleancode.journal.component;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Objects;

public class ProgressBarModel implements TemplateModel {

    private String description;
    private String value;
    private String label;
    private int percent;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgressBarModel)) return false;
        ProgressBarModel that = (ProgressBarModel) o;
        return percent == that.percent && Objects.equals(description, that.description) && Objects.equals(value, that.value) && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, value, label, percent);
    }

    @Override
    public String toString() {
        return "ProgressBarModel{" + "description='" + description + '\'' + ", value='" + value + '\'' + ", label='" + label + '\'' + ", percent=" + percent + '}';
    }
}

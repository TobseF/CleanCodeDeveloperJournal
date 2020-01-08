package org.cleancode.journal.component;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.templatemodel.TemplateModel;

import static org.cleancode.journal.util.IconUtil.getIcon;

@NpmPackage(value = "@polymer/iron-icons", version = "3.0.0")
public interface LogEntryModel extends TemplateModel {

    String getTypeicon();

    void setTypeicon(String typeicon);

    String getSkills();

    void setSkills(String skills);

    String getTopic();

    void setTopic(String topic);

    String getGrade();

    void setGrade(String grade);

    String getExperience();

    void setExperience(String experience);

    String getComment();

    void setComment(String comment);

    String getUsername();

    void setUsername(String username);

    String getDate();

    void setDate(String date);

    enum Icon {
        Check(getIcon(VaadinIcon.CHECK_CIRCLE_O)), Achievement(getIcon(VaadinIcon.TROPHY));
        final String iconPath;

        Icon(String iconPath) {
            this.iconPath = iconPath;
        }

        public String getIconPath() {
            return iconPath;
        }
    }
}

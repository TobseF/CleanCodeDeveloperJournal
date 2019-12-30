package org.cleancode.journal.component;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.templatemodel.TemplateModel;

import static org.cleancode.journal.util.IconUtil.getIcon;

@NpmPackage(value = "@polymer/iron-icons", version = "3.0.0")
public class LogEntryModel implements TemplateModel {

    public String grade;
    private String comment;
    private String username;
    private String date;
    private String experience;
    private String skills;
    private String topic;
    private String typeicon;

    public String getTypeicon() {
        return typeicon;
    }

    public void setTypeicon(String typeicon) {
        this.typeicon = typeicon;
    }

    public String getSkills() {
        return skills;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public enum Icon {
        Check(getIcon(VaadinIcon.CHECK_CIRCLE_O)), Achievement(getIcon(VaadinIcon.TROPHY));
        final String iconPath;

        Icon(String iconPath) {
            this.iconPath = iconPath;
        }

        public String getIconPath() {
            return iconPath;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

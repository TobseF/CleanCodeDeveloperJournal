package org.cleancode.journal.component;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.templatemodel.TemplateModel;

@NpmPackage(value = "@polymer/iron-icon/iron-icon", version = "3.0.0")
public class LogEntryModel implements TemplateModel {

    public String grade;
    private String comment;
    private String username;
    private String date;
    private String experience;
    private String topic;


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

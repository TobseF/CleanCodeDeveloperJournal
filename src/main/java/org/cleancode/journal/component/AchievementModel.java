package org.cleancode.journal.component;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Objects;

public class AchievementModel implements TemplateModel {

    private String experience;
    private String skills;
    private String title;

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementModel that = (AchievementModel) o;
        return Objects.equals(experience, that.experience) &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, skills, title);
    }
}

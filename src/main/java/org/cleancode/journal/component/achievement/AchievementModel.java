package org.cleancode.journal.component.achievement;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface AchievementModel extends TemplateModel {

    String getExperience();

    void setExperience(String experience);

    String getSkills();

    void setSkills(String skills);

    String getTitle();

    void setTitle(String title);

}

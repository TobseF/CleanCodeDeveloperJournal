package org.cleancode.journal.view;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AchievementComponent;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.domain.Achievement;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;

import java.util.List;
import java.util.Map;

@Route(layout = MainView.class)
public class AchievementsView extends VerticalLayout {

    public AchievementsView(Profile profile, IGradeService gradeService, IAchievementService achievementService) {

        Map<Achievement.Group, List<Achievement>> achievements = achievementService.loadAllAchievementsInGroups();

        achievements.keySet().stream().sorted().map(achievements::get).forEach(this::addAchievements);

        add(new AddSpeedDial(profile, gradeService, achievementService));
    }

    public void addAchievements(List<Achievement> achievements) {
        String groupName = getTranslation(achievements.iterator().next().getGroup());
        add(new H3(groupName));

        achievements.forEach(this::addAchievement);
    }

    public void addAchievement(Achievement achievement) {

        AchievementComponent achievementLine = new AchievementComponent();
        achievementLine.getModel().setTitle(getTranslation(achievement.getId()));
        achievementLine.getModel().setExperience("+" + achievement.getExperience() + " XP");
        String skills = "";
        if (achievement.getCharisma() != 0) {
            skills += "CHA " + achievement.getCharisma() + " ";
        }
        if (achievement.getIntellect() != 0) {
            skills += "INT " + achievement.getIntellect() + " ";
        }
        if (achievement.getTalent() != 0) {
            skills += "TAL " + achievement.getTalent() + " ";
        }
        if (achievement.getStrength() != 0) {
            skills += "STR" + achievement.getStrength() + " ";
        }
        achievementLine.getModel().setSkills(skills);
        add(achievementLine);
    }

    private String getTranslation(Achievement.Group group) {
        return getTranslation("achievement.group." + group.name().toLowerCase());
    }


}

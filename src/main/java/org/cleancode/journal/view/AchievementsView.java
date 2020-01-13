package org.cleancode.journal.view;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.achievement.AchievementComponent;
import org.cleancode.journal.component.achievement.AchievementComponent.ClickEvent;
import org.cleancode.journal.component.speeddial.AddSpeedDial;
import org.cleancode.journal.domain.Achievement;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.Score;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;

import java.util.List;
import java.util.Map;

@Route(layout = MainView.class)
@PageTitle("Clean Code - Achievements")
public class AchievementsView extends Composite<VerticalLayout> {

    private final Profile profile;
    private final IAchievementService achievementService;

    public AchievementsView(Profile profile, IGradeService gradeService, IAchievementService achievementService) {
        this.profile = profile;
        this.achievementService = achievementService;

        Map<Achievement.Group, List<Achievement>> achievements = achievementService.loadAllAchievementsInGroups();

        achievements.keySet().stream().sorted().map(achievements::get).forEach(this::addAchievements);

        getContent().add(new AddSpeedDial(profile, gradeService, achievementService));
    }

    public void addAchievements(List<Achievement> achievements) {
        String groupName = getTranslation(achievements.iterator().next().getGroup());
        getContent().add(new H3(groupName));

        achievements.forEach(this::addAchievement);
    }

    public void addAchievement(Achievement achievement) {
        AchievementComponent achievementLine = new AchievementComponent(achievement.getId());
        achievementLine.getModel().setTitle(getTranslation(achievement.getId()));
        Score score = achievement.getScore();
        achievementLine.getModel().setExperience("+" + score.getExperience() + " XP");
        achievementLine.getModel().setSkills(score.getSkills());
        achievementLine.addClickListener((ComponentEventListener<ClickEvent>) event -> openAchievementDialog(achievement));
        getContent().add(achievementLine);
    }

    private void openAchievementDialog(Achievement achievement) {
        AchievementDialog achievementDialog = new AchievementDialog(achievementService, profile);
        achievementDialog.setSelectedAchievement(achievement);
        achievementDialog.open();
    }

    private String getTranslation(Achievement.Group group) {
        return getTranslation("achievement.group." + group.name().toLowerCase());
    }

}

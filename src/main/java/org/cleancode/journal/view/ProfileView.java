package org.cleancode.journal.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.component.PercentProgressBarComponent;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.Score;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;
import org.cleancode.journal.service.INameService;

@Route(layout = MainView.class)
public class ProfileView extends VerticalLayout {
    private final INameService nameService;

    public ProfileView(INameService nameService, Profile profile, IGradeService gradeService, IAchievementService achievementService) {
        this.nameService = nameService;

        add(createExperienceBar(profile));

        add(createScoreBars(profile));

        add(createNameField(profile));

        add(createPasswordField());

        add(createGradeSelect(profile));

        add(new AddSpeedDial(profile, gradeService, achievementService));
    }

    private HorizontalLayout createScoreBars(Profile profile) {
        Score score = profile.getScore();
        int max = score.getMax();

        PercentProgressBarComponent talent = createScoreBar("TAL", max, score.getTalent());
        PercentProgressBarComponent strength = createScoreBar("STR", max, score.getStrength());
        PercentProgressBarComponent intellect = createScoreBar("INT", max, score.getIntellect());
        PercentProgressBarComponent charisma = createScoreBar("CHA", max, score.getCharisma());

        HorizontalLayout horizontalLayout = new HorizontalLayout(talent, strength, intellect, charisma);
        horizontalLayout.setWidthFull();
        return horizontalLayout;
    }

    private PercentProgressBarComponent createScoreBar(String label, int value, int max) {
        PercentProgressBarComponent scoreBar = new PercentProgressBarComponent();
        scoreBar.setLabel(label);
        scoreBar.setMaxValue(max);
        scoreBar.setValue(value);
        return scoreBar;
    }

    private PercentProgressBarComponent createExperienceBar(Profile profile) {
        PercentProgressBarComponent experience = new PercentProgressBarComponent();
        experience.setLabel("XP");
        experience.setShowDescription(true);
        experience.setMaxValue(getNextLevelExperience(profile.getLevel()));
        experience.setValue(profile.getScore().getExperience());
        return experience;
    }

    private int getNextLevelExperience(int level) {
        return (int) ((level * 200) * 1.2);
    }

    private HorizontalLayout createNameField(Profile profile) {
        HorizontalLayout nameSelection = new HorizontalLayout();
        nameSelection.setSpacing(false);
        nameSelection.setAlignItems(Alignment.BASELINE);


        TextField userName = new TextField(profile.getName());
        userName.setValue(profile.getName());
        userName.addValueChangeListener(e -> profile.setName(e.getValue()));
        userName.setLabel(getTranslation("user.name"));
        nameSelection.add(userName);


        Button newName = new Button();
        newName.addClickListener((e) -> generateNewUserName(userName));
        newName.setIcon(new Icon(VaadinIcon.REFRESH));
        nameSelection.add(newName);
        return nameSelection;
    }

    private PasswordField createPasswordField() {
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel(getTranslation("user.password"));
        return passwordField;
    }

    private Select<GradeColor> createGradeSelect(Profile profile) {
        Select<GradeColor> modeSelect = new Select<>();
        modeSelect.setItems(GradeColor.values());
        modeSelect.setLabel(getTranslation("profile.current-grade"));
        modeSelect.setValue(profile.getCurrentGrade());
        modeSelect.setItemLabelGenerator(color -> getTranslation(color.getMessageKey()));
        modeSelect.addValueChangeListener(event -> profile.setCurrentGrade(event.getValue()));
        return modeSelect;
    }

    public void generateNewUserName(TextField name) {
        String randomName = nameService.getRandomName();
        name.setValue(randomName);
        Notification.show(getTranslation("profile.action.changed-username", randomName));
    }
}

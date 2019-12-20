package org.cleancode.journal.component;

import com.vaadin.flow.component.icon.VaadinIcon;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.GradeService;
import org.cleancode.journal.service.IGradeService;
import org.cleancode.journal.view.LogDialog;

import static com.vaadin.flow.component.icon.VaadinIcon.*;

public class AddSpeedDial extends SpeedDial {

    private final Profile profile;
    private final IGradeService gradeService;

    public AddSpeedDial(Profile profile, IGradeService gradeService) {
        this.profile = profile;
        this.gradeService = gradeService;
        setBackdrop(false);
        addMenuItem(getTranslation("app.action.add.log-achievement"), TROPHY.create(), e -> activateAchievement());
        addMenuItem(getTranslation("app.action.add.log-block"), NOTEBOOK.create(), e -> createNote());
    }

    public void createNote() {
        LogDialog logDialog = new LogDialog(gradeService, profile);
        logDialog.open();
    }

    public void activateAchievement() {
        LogDialog logDialog = new LogDialog(gradeService, profile);
        logDialog.open();
    }
}

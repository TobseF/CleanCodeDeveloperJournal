package org.cleancode.journal.component;

import org.cleancode.journal.domain.LogEntry;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;
import org.cleancode.journal.service.IGradeService;
import org.cleancode.journal.view.AchievementDialog;
import org.cleancode.journal.view.LogDialog;

import java.io.Serializable;

import static com.vaadin.flow.component.icon.VaadinIcon.NOTEBOOK;
import static com.vaadin.flow.component.icon.VaadinIcon.TROPHY;

public class AddSpeedDial extends SpeedDial {

    private final Profile profile;
    private final IGradeService gradeService;
    private final IAchievementService achievementService;
    private NewLogEntryListener entryListener;

    public AddSpeedDial(Profile profile, IGradeService gradeService, IAchievementService achievementService) {
        this.profile = profile;
        this.gradeService = gradeService;
        this.achievementService = achievementService;
        setBackdrop(false);
        addMenuItem(getTranslation("app.action.add.log-achievement"), TROPHY.create(), e -> activateAchievement());
        addMenuItem(getTranslation("app.action.add.log-block"), NOTEBOOK.create(), e -> createNote());
    }

    public void createNote() {
        LogDialog logDialog = new LogDialog(gradeService, profile, entryListener);
        close();
        logDialog.open();
    }

    public void activateAchievement() {
        AchievementDialog achievementDialog = new AchievementDialog(achievementService, profile, entryListener);
        close();
        achievementDialog.open();
    }

    public void add(NewLogEntryListener entryListener) {
        this.entryListener = entryListener;
    }

    public interface NewLogEntryListener extends Serializable {
        void newLogEntry(LogEntry newLogEntry);
    }
}

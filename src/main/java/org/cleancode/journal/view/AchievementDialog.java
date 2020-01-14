package org.cleancode.journal.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import org.cleancode.journal.component.speeddial.AddSpeedDial;
import org.cleancode.journal.domain.Achievement;
import org.cleancode.journal.domain.LogEntry;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;

import java.time.LocalDateTime;


public class AchievementDialog extends Dialog {

    private final IAchievementService achievementService;
    private final Profile profile;
    private final AddSpeedDial.NewLogEntryListener entryListener;
    private TextArea comment;
    private Select<Achievement.Group> groupSelect;
    private Select<Achievement> achievementSelect;

    public AchievementDialog(IAchievementService achievementService, Profile profile, AddSpeedDial.NewLogEntryListener entryListener) {
        this.achievementService = achievementService;
        this.profile = profile;
        this.entryListener = entryListener;

        setCloseOnOutsideClick(false);
        setWidth("360px");
        setHeight("600px");

        VerticalLayout content = new VerticalLayout();
        content.setJustifyContentMode(JustifyContentMode.BETWEEN);
        content.setSizeFull();
        add(content);

        addTitle(content);

        addGroupSelect(content);

        addAchievementSelect(content);

        addComment(content);

        addActions(content);
    }

    private void addActions(VerticalLayout content) {
        Button ok = new Button(getTranslation("dialog.achievement.commit"));
        ok.addClickListener(e -> submit());
        Button cancel = new Button(getTranslation("dialog.achievement.cancel"));
        cancel.addClickListener(e -> cancel());

        HorizontalLayout actions = new HorizontalLayout(cancel, ok);
        actions.setWidthFull();
        actions.setJustifyContentMode(JustifyContentMode.END);

        content.add(actions);
    }

    private void addTitle(VerticalLayout content) {
        HorizontalLayout title = new HorizontalLayout();
        title.setAlignItems(FlexComponent.Alignment.BASELINE);
        title.setJustifyContentMode(JustifyContentMode.CENTER);
        title.setWidthFull();
        title.add(new Icon(VaadinIcon.TROPHY));
        title.add(new H2(getTranslation("dialog.achievement.achievement")));
        title.setMargin(false);
        title.setPadding(false);
        content.add(title);
    }

    private void addAchievementSelect(VerticalLayout content) {
        achievementSelect = new Select<>();
        achievementSelect.setLabel(getTranslation("dialog.achievement.achievement"));
        achievementSelect.setEnabled(false);
        achievementSelect.setItemLabelGenerator(this::getTranslation);
        achievementSelect.setWidthFull();
        content.add(achievementSelect);
    }

    private void addComment(VerticalLayout content) {
        comment = new TextArea();
        comment.setWidthFull();
        comment.setHeightFull();
        comment.setLabel(getTranslation("dialog.log.comment"));
        comment.setPlaceholder(getTranslation("dialog.log.comment.placeholder"));
        content.setFlexGrow(1, comment);
        content.add(comment);
    }

    private void addGroupSelect(VerticalLayout content) {
        groupSelect = new Select<>();
        groupSelect.setLabel(getTranslation("dialog.achievement.category"));
        groupSelect.setItems(Achievement.Group.values());
        groupSelect.setItemLabelGenerator(this::getTranslation);
        groupSelect.setWidthFull();
        groupSelect.addValueChangeListener(e -> selectedGroup(e.getValue()));
        content.add(groupSelect);
    }

    public AchievementDialog(IAchievementService achievementService, Profile profile) {
        this(achievementService, profile, null);
    }

    public void setSelectedAchievement(Achievement achievement) {
        groupSelect.setValue(achievement.getGroup());
        achievementSelect.setValue(achievement);
    }

    private void selectedGroup(Achievement.Group group) {
        achievementSelect.setEnabled(true);
        achievementSelect.setItems(achievementService.loadAllAchievementsByGroup(group));
    }


    private String getTranslation(Achievement.Group group) {
        return getTranslation("achievement.group." + group.name().toLowerCase());
    }

    private String getTranslation(Achievement achievement) {
        return getTranslation(achievement.getId());
    }


    public void cancel() {
        close();
    }

    public void submit() {
        if (achievementSelect.getValue() == null || groupSelect.getValue() == null) {
            achievementSelect.setInvalid(achievementSelect.getValue() == null);
            groupSelect.setInvalid(groupSelect.getValue() == null);
        } else {
            Achievement achievement = achievementSelect.getValue();
            LogEntry logEntry = createLogEntry(achievement);
            profile.addLogEntry(logEntry);
            notifyEntryListener(logEntry);

            Notification.show(getTranslation("dialog.achievement.committed", getTranslation(achievement)));
            close();
        }
    }

    private void notifyEntryListener(LogEntry logEntry) {
        if (entryListener != null) {
            entryListener.newLogEntry(logEntry);
        }
    }

    private LogEntry createLogEntry(Achievement achievement) {
        LogEntry logEntry = new LogEntry(LogEntry.Type.Achievement);
        logEntry.setTopicId(achievement.getId());
        logEntry.setDateTime(LocalDateTime.now());
        logEntry.setComment(comment.getValue());
        logEntry.setScore(achievement.getScore().clone());
        return logEntry;
    }

}

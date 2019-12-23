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
import org.cleancode.journal.domain.Achievement;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.service.IAchievementService;

import java.io.Serializable;


public class AchievementDialog extends Dialog {


    private final IAchievementService achievementService;
    private final Profile profile;
    private final NewAchievementListener entryListener;
    private final TextArea comment;
    private final Select<Achievement.Group> groupSelect;
    private final Select<Achievement> achievementSelect;

    public AchievementDialog(IAchievementService achievementService, Profile profile, NewAchievementListener entryListener) {
        this.achievementService = achievementService;
        this.profile = profile;
        this.entryListener = entryListener;

        VerticalLayout content = new VerticalLayout();
        content.setJustifyContentMode(JustifyContentMode.BETWEEN);
        content.setSizeFull();
        add(content);

        HorizontalLayout title = new HorizontalLayout();
        title.setAlignItems(FlexComponent.Alignment.BASELINE);
        title.setJustifyContentMode(JustifyContentMode.CENTER);
        title.setWidthFull();
        title.add(new Icon(VaadinIcon.TROPHY));
        title.add(new H2(getTranslation("dialog.achievement.achievement")));
        title.setMargin(false);
        title.setPadding(false);
        content.add(title);

        setWidth("360px");
        setHeight("600px");

        groupSelect = new Select<>();
        groupSelect.setLabel(getTranslation("dialog.achievement.category"));
        groupSelect.setItems(Achievement.Group.values());
        groupSelect.setItemLabelGenerator(this::getTranslation);
        groupSelect.setWidthFull();
        groupSelect.addValueChangeListener(e -> selectedGroup(e.getValue()));
        content.add(groupSelect);


        achievementSelect = new Select<>();
        achievementSelect.setLabel(getTranslation("dialog.achievement.achievement"));
        achievementSelect.setEnabled(false);
        achievementSelect.setItemLabelGenerator(this::getTranslation);
        achievementSelect.setWidthFull();
        content.add(achievementSelect);


        comment = new TextArea();
        comment.setWidthFull();
        comment.setHeightFull();
        comment.setLabel(getTranslation("dialog.log.comment"));
        comment.setPlaceholder(getTranslation("dialog.log.comment.placeholder"));
        content.setFlexGrow(1, comment);
        content.add(comment);

        setCloseOnOutsideClick(false);
        setCloseOnOutsideClick(false);

        Button ok = new Button(getTranslation("dialog.achievement.commit"));
        ok.addClickListener(e -> submit());
        Button cancel = new Button(getTranslation("dialog.achievement.cancel"));
        cancel.addClickListener(e -> cancel());

        HorizontalLayout actions = new HorizontalLayout(cancel, ok);
        actions.setWidthFull();
        actions.setJustifyContentMode(JustifyContentMode.END);

        content.add(actions);
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
        if (!achievementSelect.isInvalid() && !groupSelect.isInvalid()) {
            Notification.show(getTranslation("dialog.achievement.committed", getTranslation(achievementSelect.getValue())));
        }
        close();
    }

    public interface NewAchievementListener extends Serializable {
        void newAchievement(Achievement newLogEntry);
    }

}

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
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.service.INameService;
import org.springframework.beans.factory.annotation.Autowired;

@Route(layout = MainView.class)
public class ProfileView extends VerticalLayout {
    private final INameService nameService;

    public ProfileView(@Autowired INameService nameService, @Autowired Profile profile) {
        this.nameService = nameService;

        add(createNameField(nameService));

        add(createPasswordField());

        add(createGradeSelect(profile));

        add(new AddSpeedDial());
    }

    private HorizontalLayout createNameField(@Autowired INameService nameService) {
        HorizontalLayout nameSelection = new HorizontalLayout();
        nameSelection.setSpacing(false);
        nameSelection.setAlignItems(Alignment.BASELINE);

        String newUserName = nameService.getRandomName();
        TextField userName = new TextField(newUserName);
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

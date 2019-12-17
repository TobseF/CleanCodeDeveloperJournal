package org.cleancode.journal.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.cleancode.journal.component.AddSpeedDial;
import org.cleancode.journal.service.INameService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(layout = MainView.class)
public class ProfileView extends VerticalLayout {
    private final TextField userName;
    private final INameService nameService;

    public ProfileView(@Autowired INameService nameService) {
        this.nameService = nameService;

        HorizontalLayout nameSelection = new HorizontalLayout();
        nameSelection.setSpacing(false);
        add(nameSelection);
        nameSelection.setAlignItems(Alignment.BASELINE);

        String newUserName = nameService.getRandomName();
        userName = new TextField(newUserName);
        userName.setLabel(getTranslation("user.name"));
        nameSelection.add(userName);

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel(getTranslation("user.password"));
        add(passwordField);

        Button newName = new Button();
        newName.addClickListener((e) -> generateNewUserName());
        newName.setIcon(new Icon(VaadinIcon.REFRESH));
        nameSelection.add(newName);

        add(new AddSpeedDial());
    }

    @PostConstruct
    private void bind() {
        generateNewUserName();
    }

    public void generateNewUserName() {
        String newName = nameService.getRandomName();
        userName.setValue(newName);
        Notification.show(getTranslation("profile.action.changed-username", newName));
    }
}
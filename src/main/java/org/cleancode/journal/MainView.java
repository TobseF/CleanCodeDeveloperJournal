package org.cleancode.journal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.cleancode.journal.service.INameService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

//@PreserveOnRefresh
@Route
@PWA(name = "Clean Code Developer Journal", shortName = "Clean Code Journal")
public class MainView extends VerticalLayout {

    private final TextField userName;
    private final INameService nameService;

    public MainView(@Autowired INameService nameService) {
        this.nameService = nameService;

        add(new H1(getTranslation("app.name")));

        HorizontalLayout nameSelection = new HorizontalLayout();
        nameSelection.setSpacing(false);
        add(nameSelection);
        nameSelection.setAlignItems(Alignment.BASELINE);

        String newUserName = nameService.getRandomName();
        userName = new TextField(newUserName);
        userName.setLabel(getTranslation("user.name"));
        nameSelection.add(userName);

        Button newName = new Button();
        newName.addClickListener((e) -> generateNewUserName());
        newName.setIcon(new Icon(VaadinIcon.REFRESH));
        nameSelection.add(newName);
    }

    @PostConstruct
    private void bind() {
        generateNewUserName();
    }

    public void generateNewUserName() {
        String newName = nameService.getRandomName();
        userName.setValue(newName);
        Notification.show("Your new name is " + newName);
    }

}

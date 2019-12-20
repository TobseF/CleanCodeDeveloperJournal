package org.cleancode.journal.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.renderer.TextRenderer;
import org.cleancode.journal.domain.LogEntry;
import org.cleancode.journal.domain.Profile;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.cleancode.journal.service.IGradeService;

import java.util.List;


public class LogDialog extends Dialog {


    public LogDialog(IGradeService gradeService, Profile profile) {

        VerticalLayout content = new VerticalLayout();
        content.setJustifyContentMode(JustifyContentMode.BETWEEN);
        content.setSizeFull();
        add(content);

        HorizontalLayout title = new HorizontalLayout();
        title.setAlignItems(FlexComponent.Alignment.BASELINE);
        title.setJustifyContentMode(JustifyContentMode.CENTER);
        title.setWidthFull();
        title.add(new Icon(VaadinIcon.NOTEBOOK));
        title.add(new H2("Log"));
        title.setMargin(false);
        title.setPadding(false);
        content.add(title);


        setWidth("470px");
        setHeight("600px");

        Select<GradeTopic> topicSelect = new Select<>();
        topicSelect.setLabel(getTranslation("dialog.log.choose-block"));
        List<GradeTopic> topics = gradeService.loadGrade(profile.getCurrentGrade(), getLocale()).listAllGradeTopics();
        topicSelect.setItems(topics);
        topicSelect.setItemLabelGenerator(GradeTopic::getName);
        topicSelect.setWidth("420px");
        content.add(topicSelect);

        RadioButtonGroup<LogEntry.Type> voting = new RadioButtonGroup<>();
        voting.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        voting.setItems(List.of(LogEntry.Type.Fulfilled, LogEntry.Type.Violated, LogEntry.Type.Irrelevant));
        voting.setLabel(getTranslation("dialog.log.vote.question"));
        voting.setRenderer(new TextRenderer<>(this::getTranslation));
        content.add(voting);

        TextArea comment = new TextArea();
        comment.setWidthFull();
        comment.setHeightFull();
        comment.setLabel(getTranslation("dialog.log.comment"));
        comment.setPlaceholder(getTranslation("dialog.log.comment.placeholder"));
        content.setFlexGrow(1, comment);
        content.add(comment);

        setCloseOnOutsideClick(false);
        setCloseOnOutsideClick(false);

        Button ok = new Button("OK");
        ok.addClickListener(e -> submit());
        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> cancel());

        HorizontalLayout actions = new HorizontalLayout(cancel,ok);
        actions.setWidthFull();
        actions.setJustifyContentMode(JustifyContentMode.END);

        content.add(actions);
    }

    public String getTranslation(LogEntry.Type type){
        switch (type){
            case Fulfilled: return getTranslation("dialog.log.vote.question.yes");
            case Violated: return getTranslation("dialog.log.vote.question.no");
            default: return getTranslation("dialog.log.vote.question.irrelevant");
        }
    }

    public void cancel(){
        close();
    }

    public void submit(){
        close();
    }
}

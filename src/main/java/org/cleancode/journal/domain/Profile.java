package org.cleancode.journal.domain;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@VaadinSessionScope
public class Profile implements Serializable {
    private GradeColor currentGrade = GradeColor.Red;

    private Set<String> favoriteTopicIds = new HashSet<>();

    public GradeColor getCurrentGrade() {
        return currentGrade;
    }

    public boolean hasFavorite(GradeTopic topic) {
        return favoriteTopicIds.contains(topic.getId());
    }

    public void addFavorite(GradeTopic topic) {
        favoriteTopicIds.add(topic.getId());
    }

    public void removeFavorite(GradeTopic topic) {
        favoriteTopicIds.remove(topic.getId());
    }

    public Collection<String> getFavoriteTopicIds() {
        return favoriteTopicIds;
    }


    public void setCurrentGrade(GradeColor currentGrade) {
        this.currentGrade = currentGrade;
    }

}

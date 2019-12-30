package org.cleancode.journal.domain;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.cleancode.journal.domain.grade.GradeColor;
import org.cleancode.journal.domain.grade.GradeTopic;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Component
@VaadinSessionScope
public class Profile implements Serializable {
    private GradeColor currentGrade = GradeColor.Red;
    private Score score = new Score();
    private String name = "Alex"; //start with sample data
    private LocalDate stared = LocalDate.now();
    private int level = 1;

    private Set<String> favoriteTopicIds = new HashSet<>();
    private List<LogEntry> log = new LinkedList<>();

    public Profile() {
        score.setExperience(42); //start with sample data
    }

    public LocalDate getStared() {
        return stared;
    }

    public void setStared(LocalDate stared) {
        this.stared = stared;
    }

    public void addScore(Score score) {
        this.score.add(score);
    }

    public void addExperience(int experience) {
        getScore().setExperience(getScore().getExperience() + experience);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Score getScore() {
        return score;
    }

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


    public List<LogEntry> getLog() {
        return log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLogEntry(LogEntry logEntry) {
        log.add(logEntry);
        addScore(logEntry.getScore());
    }

    public void setCurrentGrade(GradeColor currentGrade) {
        this.currentGrade = currentGrade;
    }

}

package org.cleancode.journal.domain;

import java.io.Serializable;

public class Achievement implements Serializable {


    private Group group;
    /**
     * Unique id
     */
    private String id;

    private Score score = new Score();

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Achievement{" + id + '\'' + ", XP " + score.getExperience() + '}';
    }


    public enum Group {
        Grade, Log, CleanCode, Social, Dev, Health, Knowledge
    }
}

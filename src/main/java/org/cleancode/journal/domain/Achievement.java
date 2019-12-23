package org.cleancode.journal.domain;

import java.util.Objects;

public class Achievement {


    private Group group;
    /**
     * Unique id
     */
    private String id;
    /**
     * XP are points you receive for completing achievements.
     */
    private int experience;
    /**
     * CHA: Gained by completing achievements that involve social skills, interaction or communication with others.
     */
    private int charisma;
    /**
     * TAL: Gained by completing achievements that improve or require a specialized skill or ability.
     */
    private int talent;
    /**
     * STR: Gained by completing achievements that improve or require physical health and fitness.
     */
    private int strength;
    /**
     * INT: Gained by completing achievements that improve knowledge or requires education and research to complete-
     */
    private int intellect;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    @Override
    public String toString() {
        return "Achievement{" + id + '\'' + ", XP " + experience + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
        return experience == that.experience &&
                charisma == that.charisma &&
                talent == that.talent &&
                strength == that.strength &&
                intellect == that.intellect &&
                group == that.group &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, id, experience, charisma, talent, strength, intellect);
    }

    public enum Group {
        Grade, Log, CleanCode, Social, Dev, Health, Knowledge;
    }
}

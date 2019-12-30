package org.cleancode.journal.domain;

import java.io.Serializable;
import java.util.stream.IntStream;

public class Score implements Serializable {

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

    public int getExperience() {
        return experience;
    }

    public int getMax() {
        return IntStream.of(charisma, talent, strength, intellect).max().orElse(0);
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


    public void add(Score score) {
        charisma += score.charisma;
        intellect += score.intellect;
        talent += score.talent;
        strength += score.strength;
        experience += score.experience;
    }

    public String getSkills() {
        String skills = "";
        if (charisma != 0) {
            skills += "CHA " + charisma + " ";
        }
        if (intellect != 0) {
            skills += "INT " + intellect + " ";
        }
        if (talent != 0) {
            skills += "TAL " + talent + " ";
        }
        if (strength != 0) {
            skills += "STR" + strength + " ";
        }
        return skills;
    }

    public Score clone() {
        Score score = new Score();
        score.charisma = charisma;
        score.experience = experience;
        score.intellect = intellect;
        score.talent = talent;
        score.strength = strength;
        return score;
    }
}

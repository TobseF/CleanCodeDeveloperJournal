package org.cleancode.journal.grade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.approvaltests.Approvals;
import org.cleancode.journal.domain.Achievement;
import org.cleancode.journal.domain.Score;
import org.cleancode.journal.domain.grade.*;
import org.cleancode.journal.domain.grade.GradeRating.Responsibility;
import org.cleancode.journal.domain.grade.GradeRating.StarsOutOf3;
import org.junit.Test;

import java.util.Locale;

public class JsonTest {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void gradeTest() throws Exception {

        Grade grade = new Grade();
        grade.setLocale(Locale.ENGLISH);
        grade.setGradeColor(GradeColor.Red);
        grade.setNumber(GradeColor.Red.getNumber());

        Practice practice = new Practice();
        grade.addPractice(practice);
        practice.setName("Boy Scout Rule");
        practice.setId("boy-scout-rule");
        practice.setDescription("Lorem Ispum");
        practice.setSectionWhy("Because of you");
        {
            GradeRating rating = new GradeRating();
            rating.setCorrectness(StarsOutOf3._2);
            rating.setResponsibility(Responsibility.SingleDev);
            practice.setGradeRating(rating);
        }

        Principle principle = new Principle();
        grade.addPrinciples(principle);
        principle.setName("Keep it simple, stupid (KISS)");
        principle.setId("kiss");
        principle.setDescription("Lorem Ispum");
        principle.setSectionWhy("Because you can");

        {
            GradeRating rating = new GradeRating();
            rating.setEvolvability(StarsOutOf3._2);
            rating.setCorrectness(StarsOutOf3._2);
            rating.setResponsibility(Responsibility.SingleDev);
            principle.setGradeRating(rating);
        }


        Approvals.verifyJson(gson.toJson(grade));
    }

    @Test
    public void achievementTest() {
        Achievement achievement = new Achievement();
        achievement.setGroup(Achievement.Group.Dev);
        achievement.setId("achievement.dev.write-test");
        Score score = achievement.getScore();
        score.setCharisma(42);
        score.setExperience(43);
        score.setStrength(44);
        score.setIntellect(45);
        score.setTalent(46);

        Achievement[] achievements = {achievement, achievement};

        Approvals.verifyJson(gson.toJson(achievements));
    }
}
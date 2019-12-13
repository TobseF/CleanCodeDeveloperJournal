package org.cleancode.journal.grade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.approvaltests.Approvals;
import org.cleancode.journal.domain.grade.*;
import org.cleancode.journal.domain.grade.GradeRating.Responsibility;
import org.cleancode.journal.domain.grade.GradeRating.StarsOutOf3;
import org.junit.Test;

import java.util.Locale;

public class JsonTest {

    @Test
    public void test() throws Exception {

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

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Approvals.verifyJson(gson.toJson(grade));
    }
}
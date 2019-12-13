package org.cleancode.journal.domain.grade;

import java.util.Objects;

public class GradeRating {

    private StarsOutOf3 evolvability = StarsOutOf3._0;
    private StarsOutOf3 correctness = StarsOutOf3._0;
    private StarsOutOf3 productionEfficiency = StarsOutOf3._0;
    private StarsOutOf2 continuousImprovement = StarsOutOf2._0;
    private Responsibility responsibility;

    public StarsOutOf3 getEvolvability() {
        return evolvability;
    }

    public void setEvolvability(StarsOutOf3 evolvability) {
        this.evolvability = evolvability;
    }

    public StarsOutOf3 getCorrectness() {
        return correctness;
    }

    public void setCorrectness(StarsOutOf3 correctness) {
        this.correctness = correctness;
    }

    public StarsOutOf3 getProductionEfficiency() {
        return productionEfficiency;
    }

    public void setProductionEfficiency(StarsOutOf3 productionEfficiency) {
        this.productionEfficiency = productionEfficiency;
    }

    public StarsOutOf2 getContinuousImprovement() {
        return continuousImprovement;
    }

    public void setContinuousImprovement(StarsOutOf2 continuousImprovement) {
        this.continuousImprovement = continuousImprovement;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeRating that = (GradeRating) o;
        return evolvability == that.evolvability && correctness == that.correctness && productionEfficiency == that.productionEfficiency && continuousImprovement == that.continuousImprovement && responsibility == that.responsibility;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evolvability, correctness, productionEfficiency, continuousImprovement, responsibility);
    }

    public enum Responsibility {Team, SingleDev}

    public enum StarsOutOf2 {_0, _1, _2}

    public enum StarsOutOf3 {_0, _1, _2, _3}
}

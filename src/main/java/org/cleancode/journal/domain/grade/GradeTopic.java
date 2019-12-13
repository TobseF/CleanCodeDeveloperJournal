package org.cleancode.journal.domain.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GradeTopic {

    private String name;
    private String id;
    private String sectionWhy;
    private String description;
    private GradeRating gradeRating;

    private List<GradeSource> sources = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSectionWhy() {
        return sectionWhy;
    }

    public void setSectionWhy(String sectionWhy) {
        this.sectionWhy = sectionWhy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GradeRating getGradeRating() {
        return gradeRating;
    }

    public void setGradeRating(GradeRating gradeRating) {
        this.gradeRating = gradeRating;
    }

    public List<GradeSource> getSources() {
        return sources;
    }

    public void setSources(List<GradeSource> sources) {
        this.sources = sources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradeTopic)) return false;
        GradeTopic that = (GradeTopic) o;
        return name.equals(that.name) && id.equals(that.id) && Objects.equals(sectionWhy, that.sectionWhy) && Objects.equals(description, that.description) && Objects.equals(gradeRating, that.gradeRating) && sources.equals(that.sources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, sectionWhy, description, gradeRating, sources);
    }
}

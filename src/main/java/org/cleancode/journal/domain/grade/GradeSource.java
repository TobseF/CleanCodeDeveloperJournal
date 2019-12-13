package org.cleancode.journal.domain.grade;

import java.io.Serializable;
import java.util.Objects;

public class GradeSource implements Serializable {
    private String source;
    private String author;
    private String description;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeSource that = (GradeSource) o;
        return source.equals(that.source) && author.equals(that.author) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, author, description);
    }


}

package org.cleancode.journal.domain.grade;

import java.io.Serializable;
import java.util.Objects;

public class GradeSource implements Serializable {

    private String name;
    private String link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeSource source = (GradeSource) o;
        return Objects.equals(name, source.name) &&
                Objects.equals(link, source.link) &&
                Objects.equals(author, source.author) &&
                Objects.equals(description, source.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link, author, description);
    }
}

package library.entity;

import java.util.Date;
import java.util.List;

public class Book {
    Long id;
    List<Author> a;
    List<Genre> g;
    String ISBN;
    Date created;
    Date update;
    String title;

    public Book(Long id, List<Author> a, List<Genre> g, String ISBN, Date created, Date update, String title) {
        this.id = id;
        this.a = a;
        this.g = g;
        this.ISBN = ISBN;
        this.created = created;
        this.update = update;
        this.title = title;
    }

    public Book() {
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Author> getA() {
        return a;
    }

    public void setA(List<Author> a) {
        this.a = a;
    }

    public List<Genre> getG() {
        return g;
    }

    public void setG(List<Genre> g) {
        this.g = g;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

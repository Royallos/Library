package library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Book {
    int id;
    String Author;
    String Genre;
    String ISBN;
    String title;

    public Book(int id, String Author, String Genre, String ISBN, String title) {
        this.id = id;
        this.Author = Author;
        this.Genre = Genre;
        this.ISBN = ISBN;
        this.title = title;
    }

    public Book() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}

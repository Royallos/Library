package library.entity;


public class Book {
    int id;
    Author author;
    Genre genre;
    String ISBN;
    String title;

    public Book(int id, String ISBN, String title, Author author, Genre genre) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;

    }

    public Book() {
    }


    public int getGenreId() {
        return genre.getId();
    }
    public String getGenreName() {
        return genre.getName();
    }


    public int getAuthorId() {
        return author.getId();
    }
    public String getAuthorName() {
        return author.getName();
    }
    public String getAuthorSurname() {
        return author.getSurname();
    }

    public void setAuthorId(Author author) {
        this.author = author;
    }
    public void setGenreId(Genre genre) {
        this.genre = genre;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}

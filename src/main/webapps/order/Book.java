package main.webapps.order;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private String pub;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pub='" + pub + '\'' +
                '}';
    }

    public Book() {
        id = UUID.randomUUID().toString();
        title="";
        author="";
        pub="";
    }

    public Book(String title, String author, String pub) {
        this(UUID.randomUUID().toString(), title, author, pub);
    }

    public Book(String id, String title, String author, String pub) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pub = pub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }
}

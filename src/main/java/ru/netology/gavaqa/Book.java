package ru.netology.gavaqa;

public class Book extends Product {
    protected String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        this.author = author;
    }
}


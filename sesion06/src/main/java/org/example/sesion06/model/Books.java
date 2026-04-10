package org.example.sesion06.model;

public record Books(int id, String nameBook, String author, double price) {
    public int getId() {
        return id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

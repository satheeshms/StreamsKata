package com.satz.kata.pojo;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private Integer price;

    public Book(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        return this.name.equals(b.name)
            && this.author.equals(b.author)
            && this.price.equals(b.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price);
    }

    
}

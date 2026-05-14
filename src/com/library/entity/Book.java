package com.library.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private Author author;
    private int edition;
    private BookStatus status;
    private double price;
    private LocalDate purchaseDate;
    private Category category;

    public Book(long id, String title, Author author, int edition, double price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
        this.status = BookStatus.AVAILABLE;
        this.purchaseDate = LocalDate.now();
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {return price;}

    public boolean isAvailable(){
        return status == BookStatus.AVAILABLE;
    }

    public boolean isBorrowed(){
        return status == BookStatus.BORROWED;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title;
    }

    public void setEdition(int edition) {
        if(edition < 0){
            throw new IllegalArgumentException("Edition cannot be negative");
        }
        this.edition = edition;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void markAsBorrowed(){
        if(status == BookStatus.BORROWED){
            throw new IllegalStateException("Book is already borrowed");
        }
        this.status = BookStatus.BORROWED;
    }
    public void markAsAvailable(){
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author.getFullName() +
                ", edition=" + edition +
                ", status=" + status +
                ", price=" + price +
                '}';
    }

}

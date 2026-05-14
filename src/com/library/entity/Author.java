package com.library.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.books = new HashSet<>();
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getId() == author.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                '}';
    }
}

package com.library.entity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Member extends Person {
    private Set<Book> borrowedBooks;
    private LocalDate dateOfMembership;
    private Contact contact;
    private Address address;

    public Member(long id,
                  String firstName,
                  String lastName,
                  LocalDate dateOfMembership,
                  Contact contact,
                  Address address) {
        super(id, firstName, lastName);
        this.borrowedBooks = new HashSet<>();
        this.dateOfMembership = dateOfMembership;
        this.contact = contact;
        this.address = address;
    }

    public Set<Book> getBorrowedBooks() {
        return Collections.unmodifiableSet(borrowedBooks);
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public void addBorrowedBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }
        borrowedBooks.add(book);

    }

    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }

    public abstract int getBookLimit();

    public boolean hasReachedLimit(){
        return borrowedBooks.size() >= getBookLimit();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", dateOfMembership=" + dateOfMembership +
                ", contact=" + contact +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getId() == member.getId();
    }

    @Override
    public int hashCode() {
       return Objects.hash(getId());
    }
}

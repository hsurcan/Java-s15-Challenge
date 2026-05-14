package com.library.entity;

import java.time.LocalDate;

public class Loan {
    private long id;
    private Member member;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(long id, Member member, Book book) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.returned = false;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void markAsReturned(){
        this.returnDate = LocalDate.now();
        this.returned = true;
    }

    public boolean isReturned(){
        return returned;
    }

    public Member getMember(){
        return member;
    }

    public Book getBook(){
        return book;
    }
}

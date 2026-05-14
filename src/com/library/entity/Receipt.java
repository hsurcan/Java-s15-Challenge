package com.library.entity;

import java.time.LocalDate;

public class Receipt {
    private long id;
    private Member member;
    private Book book;
    private double amount;
    private LocalDate receiptDate;
    private boolean refunded;

    public Receipt(long id, Member member, Book book, double amount) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.amount = amount;
        this.receiptDate = LocalDate.now();
        this.refunded = false;
    }

    public void refund() {
        this.refunded = true;
    }

    public boolean isRefunded() {
        return refunded;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", member=" + member.getFullName() +
                ", book=" + book.getTitle() +
                ", amount=" + amount +
                ", receiptDate=" + receiptDate +
                ", refunded=" + refunded +
                '}';
    }
}

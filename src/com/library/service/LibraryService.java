package com.library.service;

import com.library.entity.Book;
import com.library.entity.Library;
import com.library.entity.Member;
import com.library.entity.Receipt;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Library library;
    private BillingService billingService;
    private Map<Long, Receipt> receipts;

    public LibraryService(Library library, BillingService billingService) {
        this.library = library;
        this.billingService = billingService;
        this.receipts = new HashMap<>();
    }

    public void borrowBook(long memberId, long bookId){
        Member member = library.findMemberById(memberId);
        Book book = library.findBookById(bookId);

        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available.");
        }

        if (member.hasReachedLimit()) {
            throw new IllegalStateException("Member has reached book limit.");
        }

        member.addBorrowedBook(book);
        book.markAsBorrowed();
        Receipt receipt = billingService.createReceipt(member, book);
        receipts.put(bookId, receipt);
        System.out.println("Receipt created:");
        System.out.println(receipt);
    }

    public void returnBook(long memberId, long bookId){
        Member member = library.findMemberById(memberId);
        Book book = library.findBookById(bookId);


        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (!member.getBorrowedBooks().contains(book)) {
            throw new IllegalStateException("This member did not borrow this book.");
        }

        member.removeBorrowedBook(book);
        book.markAsAvailable();

        Receipt receipt = receipts.get(bookId);
        billingService.refundReceipt(receipt);
        System.out.println("Refund Receipt created:");
        System.out.println(receipt);

        double fine = billingService.calculateFine(3);
        System.out.println("Fine amount: " + fine);
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        if (library.findBookById(book.getId()) != null) {
            throw new IllegalArgumentException("This book already exists.");
        }

        library.addBook(book);
    }

    public void removeBook(long bookId) {
        Book book = library.findBookById(bookId);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (book.isBorrowed()) {
            throw new IllegalStateException("Borrowed book cannot be removed.");
        }

        library.removeBook(bookId);
    }

    public void updateBook(long bookId, String title, int edition, double price) {
        Book book = library.findBookById(bookId);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        book.setTitle(title);
        book.setEdition(edition);
        book.setPrice(price);
    }

    public void addMember(Member member){
        if(member == null){
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if(library.findMemberById(member.getId()) != null){
            throw new IllegalArgumentException("This member already exists.");
        }

        library.addMember(member);
    }

    public void removeMember(long memberId){
        Member member = library.findMemberById(memberId);

        if(member == null){
            throw new IllegalArgumentException("Member not found.");
        }

        library.removeMember(memberId);
    }

}

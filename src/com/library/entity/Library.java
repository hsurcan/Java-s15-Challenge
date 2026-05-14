package com.library.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Long, Book> books;
    private Map<Long, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public Map<Long, Book> getBooks() {
        return Collections.unmodifiableMap(books);
    }

    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    public void removeBook(long bookId){
            books.remove(bookId);
    }

    public void addMember(Member member){
        members.put(member.getId(), member);
    }

    public void removeMember(long memberId){
            members.remove(memberId);
    }

    public Book findBookById(long bookId) {
        return books.get(bookId);
    }

    public Member findMemberById(long memberId) {
        return members.get(memberId);
    }
}

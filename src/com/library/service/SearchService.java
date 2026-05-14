package com.library.service;

import com.library.entity.Book;
import com.library.entity.Category;
import com.library.entity.Library;
import com.library.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private Library library;

    public SearchService(Library library) {
        this.library = library;
    }

    public Book findBookById(long bookId) {
        return library.findBookById(bookId);
    }

    public Member findMemberById(long memberId) {
        return library.findMemberById(memberId);
    }

    public List<Book> findBooksByTitle(String title) {
        return library.getBooks()
                .values()
                .stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthorName(String authorName) {
        return library.getBooks()
                .values()
                .stream()
                .filter(book -> book.getAuthor()
                        .getFullName()
                        .equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(Category category) {
        return library.getBooks()
                .values()
                .stream()
                .filter(book -> book.getCategory() == category)
                .collect(Collectors.toList());
    }
}

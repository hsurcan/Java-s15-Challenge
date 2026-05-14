package com.library;

import com.library.entity.*;
import com.library.service.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BillingService billingService = new BillingService();
        LibraryService libraryService = new LibraryService(library, billingService);
        SearchService searchService = new SearchService(library);

        Author orwell = new Author(1, "George", "Orwell");
        Author rowling = new Author(2, "J.K.", "Rowling");

        Book book1 = new Book(101, "1984", orwell, 1, 100.0, Category.NOVEL);
        Book book2 = new Book(102, "Animal Farm", orwell, 1, 80.0, Category.NOVEL);
        Book book3 = new Book(103, "Harry Potter", rowling, 1, 150.0, Category.FANTASY);

        Contact contact = new Contact("student@mail.com", "05551234567");

        Address address = new Address(
                "Ataturk Street",
                "10",
                "5",
                "Istanbul",
                "34000"
        );

        Student student = new Student(
                1,
                "Ali",
                "Yilmaz",
                LocalDate.now(),
                contact,
                address,
                "STU1001",
                "Computer Engineering"
        );

        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);
        libraryService.addMember(student);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1 - Show book by ID");
            System.out.println("2 - Search books by title");
            System.out.println("3 - Search books by author");
            System.out.println("4 - Search books by category");
            System.out.println("5 - Add book");
            System.out.println("6 - Update book");
            System.out.println("7 - Remove book");
            System.out.println("8 - Borrow book");
            System.out.println("9 - Return book");
            System.out.println("10 - Show student's borrowed books");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    Book book = searchService.findBookById(bookId);
                    System.out.println(book == null ? "Book not found." : book);
                }

                else if (choice == 2) {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.println(searchService.findBooksByTitle(title));
                }

                else if (choice == 3) {
                    System.out.print("Author full name: ");
                    String authorName = scanner.nextLine();

                    System.out.println(searchService.findBooksByAuthorName(authorName));
                }

                else if (choice == 4) {
                    System.out.print("Category, example NOVEL or FANTASY: ");
                    String categoryInput = scanner.nextLine().toUpperCase();

                    Category category = Category.valueOf(categoryInput);
                    System.out.println(searchService.findBooksByCategory(category));
                }

                else if (choice == 5) {
                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author ID: ");
                    long authorId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Author first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Author last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Edition: ");
                    int edition = scanner.nextInt();

                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Category, example NOVEL or FANTASY: ");
                    Category category = Category.valueOf(scanner.nextLine().toUpperCase());

                    Author author = new Author(authorId, firstName, lastName);
                    Book book = new Book(bookId, title, author, edition, price, category);

                    libraryService.addBook(book);
                    System.out.println("Book added successfully.");
                }

                else if (choice == 6) {
                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("New title: ");
                    String title = scanner.nextLine();

                    System.out.print("New edition: ");
                    int edition = scanner.nextInt();

                    System.out.print("New price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    libraryService.updateBook(bookId, title, edition, price);
                    System.out.println("Book updated successfully.");
                }

                else if (choice == 7) {
                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    libraryService.removeBook(bookId);
                    System.out.println("Book removed successfully.");
                }

                else if (choice == 8) {
                    System.out.print("Member ID: ");
                    long memberId = scanner.nextLong();

                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    libraryService.borrowBook(memberId, bookId);
                    System.out.println("Book borrowed successfully.");
                }

                else if (choice == 9) {
                    System.out.print("Member ID: ");
                    long memberId = scanner.nextLong();

                    System.out.print("Book ID: ");
                    long bookId = scanner.nextLong();
                    scanner.nextLine();

                    libraryService.returnBook(memberId, bookId);
                    System.out.println("Book returned successfully.");
                }

                else if (choice == 10) {
                    System.out.println(student.getBorrowedBooks());
                }

                else if (choice == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
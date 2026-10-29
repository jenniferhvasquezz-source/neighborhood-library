package com.pluralsight;

import java.awt.print.Book;
import java.util.Scanner;

public class NeighborhoodLibrary {
    private String checkedOutTo;

    public void main(String[] args) {
        int id;
        private String isbn;
        private String title;
        private boolean isCheckedOut;
        private String checkedOutTo;

        // Constructor
        public Book(int id, String isbn, String title){
            this.id = id;
            this.isbn = isbn;
            this.title = title;
            this.isCheckedOut = false;
            this.checkedOutTo = "";
        }
        // Methods required by project
        public void checkOut(String name){
            this.isCheckedOut = true;
            this.CheckedOutTo = name;
        }
        public void checkIn() {
            this.isCheckedOut = false;
            this.checkedOutTo = "";
        }
        public void setId(int id){
            this.id = id;
        }
        public void setIsbn(String isbn){
            this.isbn = isbn;
        }
        public void setTitle(String title){
        }
        public boolean isCheckedOut() {
            return isCheckedOut;
        }
        public void setCheckedOut(boolean checkedOut){
            isCheckedOut = checkedOut;
        }
        public String getCheckedOutTo() {
            return checkedOutTo;
        }
        public void setCheckedOutTo(String checkedOutTo) {
            this.checkedOutTo = checkedOutTo;

// Initialize inventory array with at least 20 books with unique IDs
                    Book[] inventory = {
                            new Book(1, "978-0134685991", "Effective Java"),
                            new Book(2, "978-0596009205", "Head First Java"),
                            new Book(3, "978-0135957059", "Clean Code"),
                            new Book(4, "978-0201633610", "Design Patterns"),
                            new Book(5, "978-0321356680", "Effective C++"),
                            new Book(6, "978-0201485679", "Refactoring"),
                            new Book(7, "978-0132350884", "Clean Architecture"),
                            new Book(8, "978-0596007126", "Head First Design Patterns"),
                            new Book(9, "978-0321125217", "Domain-Driven Design"),
                            new Book(10, "978-0201633566", "The Pragmatic Programmer"),
                            new Book(11, "978-1449373323", "Designing Data-Intensive Applications"),
                            new Book(12, "978-0134494166", "Java: The Complete Reference"),
                            new Book(13, "978-1118008188", "Data Structures and Algorithms in Java"),
                            new Book(14, "978-0321751041", "The C++ Programming Language"),
                            new Book(15, "978-0137081073", "The Algorithm Design Manual"),
                            new Book(16, "978-0201896831", "The Art of Computer Programming"),
                            new Book(17, "978-0596517748", "JavaScript: The Good Parts"),
                            new Book(18, "978-1491950357", "Fluent Python"),
                            new Book(19, "978-0132382538", "Working Effectively with Legacy Code"),
                            new Book(20, "978-0321146533", "Test Driven Development")
                    };
                    boolean running = true;
// Home Screen Loop
                    while (running) {
                        System.out.println("
                                        ========================================");
                                System.out.println(" WELCOME TO THE NEIGHBORHOOD LIBRARY");
                        System.out.println("========================================");
                        System.out.println("1 - Show Available Books");
                        System.out.println("2 - Show Checked Out Books");
                        System.out.println("3 - Exit");
                        System.out.print("Please enter your choice: ");
                        String choice = scanner.nextLine().trim();
                        switch (choice) {
                            case "1":
                                showAvailableBooks(inventory, scanner);
                                break;
                            case "2":
                                showCheckedOutBooks(inventory, scanner);
                                break;
                            case "3":
                                System.out.println("Thank you for using the Neighborhood Library. Goodbye!");
                                running = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        }
                    }
                    scanner.close();
                }
                // Screen: Show Available Books and handle checkouts[span_13](start_span)[span_13](end_span)[span_14](start_span)[span_14](end_span)
                public static void showAvailableBooks(Book[] inventory, Scanner scanner) {
                    System.out.println("
                            --- Available Books ---");
                    boolean hasAvailable = false;
                    for (Book book : inventory) {
                        if (!book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
                            hasAvailable = true;
                        }
                    }
                    if (!hasAvailable) {
                        System.out.println("There are currently no available books in the library.");
                        return;
                    }
                    System.out.print("
                            Enter the ID of the book you want to check out (or type 0 to return): ");
                    int bookId;
                    try {
                        bookId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to home screen.");
                        return;
                    }
                    if (bookId == 0) {
                        return;
                    }
                    Book selectedBook = null;
                    for (Book book : inventory) {
                        if (book.getId() == bookId && !book.isCheckedOut()) {
                            selectedBook = book;
                            break;
                        }
                    }
                    if (selectedBook != null) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine().trim();
                        selectedBook.checkout(name);
                        System.out.println("Success! "" + selectedBook.getTitle() + "" has been checked out to " + name + ".");
                    } else {
                        System.out.println("Invalid ID or the book is not available.");
                    }
                }
                // Screen: Show Checked Out Books and handle check-ins[span_15](start_span)[span_15](end_span)[span_16](start_span)[span_16](end_span)
                public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
                    System.out.println("
                            --- Checked Out Books ---");
                    boolean hasCheckedOut = false;
                    for (Book book : inventory) {
                        if (book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle() + " | Checked Out To: " + book.getCheckedOutTo());
                            hasCheckedOut = true;
                        }
                    }
                    if (!hasCheckedOut) {
                        System.out.println("There are currently no books checked out.");
                        return;
                    }
                    System.out.println("
                            Options:");
                    System.out.println("C - Check In a book");
                    System.out.println("X - Go back to the home screen");
                    System.out.print("Enter your choice: ");
                    String option = scanner.nextLine().trim().toUpperCase();
                    if (option.equals("C")) {
                        System.out.print("Enter the ID of the book you want to check in: ");
                        int bookId;
                        try {
                            bookId = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Returning to home screen.");
                            return;
                        }
                        Book selectedBook = null;
                        for (Book book : inventory) {
                            if (book.getId() == bookId && book.isCheckedOut()) {
                                selectedBook = book;
                                break;
                            }
                        }
                        if (selectedBook != null) {
                            selectedBook.checkIn();
                            System.out.println("Success! "" + selectedBook.getTitle() + "" has been checked back into the library.");
                        } else {
                            System.out.println("Invalid ID or the book is not currently checked out.");
                        }
                    }
                }
            }

        }

        }


    }
}

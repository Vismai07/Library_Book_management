package library;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nMenu: addBook/addPatron/checkout/return/showBooks/showPatrons/exit");
            System.out.print("Enter option: ");
            String option = sc.nextLine();

            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting system...");
                break;
            }

            switch (option.toLowerCase()) {
                case "addbook":
                    System.out.print("Book title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("ISBN: ");
                    long isbn = Long.parseLong(sc.nextLine());
                    System.out.print("Publication year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    library.addBook(new Book(title, author, isbn, year));
                    break;

                case "addpatron":
                    System.out.print("Patron name: ");
                    String name = sc.nextLine();
                    System.out.print("Patron ID: ");
                    String id = sc.nextLine();
                    library.addPatron(new Patron(name, id));
                    break;

                case "checkout":
                    System.out.print("Patron ID: ");
                    String checkoutId = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    long checkoutIsbn = Long.parseLong(sc.nextLine());
                    library.checkoutBook(checkoutId, checkoutIsbn);
                    break;

                case "return":
                    System.out.print("Patron ID: ");
                    String returnId = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    long returnIsbn = Long.parseLong(sc.nextLine());
                    library.returnBook(returnId, returnIsbn);
                    break;

                case "showbooks":
                    library.showAllBooks();
                    break;

                case "showpatrons":
                    library.showAllPatrons();
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}

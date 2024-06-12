package HN_JV240408_BS_NguyenDucHai.Exam_basic.ra.run;

import HN_JV240408_BS_NguyenDucHai.Exam_basic.ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static Book[] books = new Book[100];
    public static int indexBook = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************MENU******************");
            System.out.println("1.Enter the number of newly added books and enter information for each book");
            System.out.println("2.Display information about all books in the library");
            System.out.println("3.Arrange the books according to increasing profits");
            System.out.println("4.Delete books by book code");
            System.out.println("5.Relatively search for books by title or description");
            System.out.println("6.Change book information according to book code");
            System.out.println("7.Exit");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteBook(sc);
                    break;
                case 5:
                    searchBook(sc);
                    break;
                case 6:
                    updateBook(sc);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        } while (true);
    }

    /*---------------------------------CRUD---------------------------------*/
    //Add
    public static void addBook(Scanner sc) {
        System.out.println("Input the numbers of books you want to add");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Input book " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(sc);
            books[indexBook] = book;
            indexBook++;
        }
        System.out.println("------------------------------------");
        System.out.println("Add " + number + " new book successfully");
    }

    //Book
    public static void displayAllBooks() {
        if(indexBook == 0) {
            System.err.println("List of books is empty");
            return;
        }
        System.out.println("************BOOKS INFORMATION*************");
        for (int i = 0; i < indexBook; i++) {
            books[i].displayData();
        }
    }

    //Sort
    public static void sortByInterest() {
        if (indexBook == 0) {
            System.err.println("List of books is empty");
            return;
        }
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Sort by interest successfully");
    }

    //DeleteBook
    public static void deleteBook(Scanner sc) {
        if (indexBook == 0) {
            System.err.println("List of books is empty");
            return;
        }
        System.out.println("Input the book id you want to delete");
        int id = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        int indexDelete = 0;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookId() == id) {
                indexDelete = i;
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.err.println("Book not found");
        } else {
            for (int i = indexDelete; i < indexBook; i++) {
                books[i] = books[i + 1];
            }
            indexBook--;
            System.out.println("delete book successfully");
        }
    }

    //Search by name or description
    public static void searchBook(Scanner sc) {
        if (indexBook == 0) {
            System.err.println("List of books is empty");
            return;
        }
        System.out.println("Input the book name or book descriptions you want to search");
        String bookSearch = sc.nextLine();
        int count = 0;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookName().contains(bookSearch) || books[i].getDescriptions().contains(bookSearch)) {
                books[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Book not found");
        }else {
            System.out.println("Found " + count + " books");
        }
    }

    //Update Book by id
    public static void updateBook(Scanner sc) {
        if(indexBook == 0) {
            System.err.println("List of books is empty");
            return;
        }
        System.out.println("Input the book id you want to update");
        int id = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookId() == id) {
                System.out.println("Book information");
                books[i].displayData();
                System.out.println("Change information for book");
                books[i].updateData(sc);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.err.println("Book not found");
        } else {
            System.out.println("Update book successfully");
        }
    }
}

package HN_JV240408_BS_NguyenDucHai.Exam_basic.ra.bussiness;

import HN_JV240408_BS_NguyenDucHai.Exam_basic.ra.run.BookManagement;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName, author, descriptions;
    private double importPrice, exportPrice;
    private float interest;
    private boolean bookStatus = true;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }


    /*------------------------Input Data--------------------------*/
    public void inputData(Scanner sc) {
        this.bookId = inputBookId();
        this.bookName = inputBookName(sc);
        this.author = inputAuthor(sc);
        this.descriptions = inputDescription(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
        this.interest = (float)this.exportPrice - (float)this.importPrice;
        this.bookStatus = inputBookStatus(sc);
    }

    /*------------------------Update Data--------------------------*/
    public void updateData(Scanner sc) {
        this.bookName = inputBookName(sc);
        this.author = inputAuthor(sc);
        this.descriptions = inputDescription(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
        this.interest = (float)this.exportPrice - (float)this.importPrice;
        this.bookStatus = inputBookStatus(sc);
    }

    /*------------------------Display Data------------------------*/
    public void displayData() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("ID : %3d | BookName: %15s | Author: %15s | Description: %20s | ImportPrice: %5.2f | ExportPrice: %5.2f | Interest: %5.2f | Status: %5s \n",
                this.bookId, this.bookName, this.author, this.descriptions, this.importPrice, this.exportPrice, this.interest,this.bookStatus?"Active":"inActive");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    /*-------------------Input Book Information-------------------*/

    //inputBookId
    public int inputBookId() {
        if (BookManagement.indexBook == 0) {
            return 1;
        } else {
            int max = BookManagement.books[0].getBookId();
            for (int i = 0; i < BookManagement.indexBook; i++) {
                if(max < BookManagement.books[i].getBookId()){
                    max = BookManagement.books[i].getBookId();
                }
            }
            return max+1;
        }
    }

    //inputBookName
    public String inputBookName(Scanner sc){
        while(true){
            System.out.println("Input book name");
            String bookName = sc.nextLine();
            if(bookName.trim().isEmpty()){
                System.err.println("Book name must not be empty, please try again");
            }else{
                return bookName;
            }
        }
    }

    //inputAuthor
    public String inputAuthor(Scanner sc){
        while (true){
            System.out.println("Input book author");
            String bookAuthor = sc.nextLine();
            if(bookAuthor.trim().isEmpty()){
                System.err.println("Book author must not be empty, please try again");
            }else{
                return bookAuthor;
            }
        }
    }

    //inputDescriptions
    public String inputDescription(Scanner sc){
        while (true){
            System.out.println("Input book description");
            String bookDescription = sc.nextLine();
            if(!bookDescription.trim().isEmpty()){
                if(bookDescription.length() >=10){
                    return bookDescription;
                }else{
                    System.err.println("Book description must be less than 10 characters, please try again");
                }
            }else{
                System.err.println("Book description must not be empty, please try again");
            }
        }
    }

    //inputImportPrice
    public double inputImportPrice(Scanner sc){
        while (true){
            System.out.println("Input book import price");
            double importPrice = Double.parseDouble(sc.nextLine());
            if(importPrice > 0){
                return importPrice;
            }else{
                System.err.println("Book import price must be positive, please try again");
            }
        }
    }

    //inputExportPrice
    public double inputExportPrice(Scanner sc){
        while (true){
            System.out.println("Input book export price");
            double exportPrice = Double.parseDouble(sc.nextLine());
            if(exportPrice > importPrice*1.2){
                return exportPrice;
            }else{
                System.err.println("Book export price must greater than import price 1.2, please try again");
            }
        }
    }

    //inputBookStatus
    public boolean inputBookStatus(Scanner sc){
        while (true){
            System.out.println("Input status for Book (True|False)");
            String statusBook = sc.nextLine();
            if(statusBook.equals("True") || statusBook.equals("False")){
                return Boolean.parseBoolean(statusBook);
            }else{
                System.err.println("Your input is wrong,try again");
            }
        }
    }
}

package Model;

public class Book {
    private int bookID;
    private String bookName;
    private String author;
    private String decription;
    private int quantity;

    public Book(int bookID, String bookName, String author, String decription, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.decription = decription;
        this.quantity = quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

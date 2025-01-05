package Model;

import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    String bookName;
    String author;

    Book() {
        bookName = "";
        author = "";
    }

    Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInstanceAsDelimitedString(String delimiter) {
        return bookName + delimiter + author;
    }

    public static Book getBookFromDelimitedString(String string, String delimiter) {
        String[] chunks = string.split(delimiter);

        if (chunks.length != 2) {
            return null;
        }

        try {
            String bookName = chunks[0];
            String author = chunks[1];
            return new Book(bookName, author);
        }
        catch (Exception e) {
            System.err.println("Could not create book from CSV");
        }

        return null;
    }
}

package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryRepository implements IRepository {
    private HashMap<String, Book> books;

    public BinaryRepository() {
        books = new HashMap<String, Book>();
    }

    public Book getBook(String bookName) throws RepositoryException {
        try {
            return books.get(bookName);
        } catch (Exception e) {
            throw new RepositoryException("Error when getting book: " + e.getMessage());
        }
        
    }

    public void addBook(Book book) throws RepositoryException {
        try {
            books.put(book.getBookName(), book);
        } catch (Exception e) {
            throw new RepositoryException("Error when adding book: " + e.getMessage());
        }
    }

    public void deleteBook(String bookName) throws RepositoryException {
        try {
            books.remove(bookName);
        }
        catch (Exception e) {
            throw new RepositoryException("Error when deleting book: " + e.getMessage());
        }
    }

    public void saveState() throws RepositoryException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("books.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(Book book : books.values()) {
                objectOutputStream.writeObject(book);
            }
            objectOutputStream.close();
        }
        catch (Exception e) {
            throw new RepositoryException("Error when saving state: " + e.getMessage());
        }
    }

    public void loadState() throws RepositoryException {
        try {
            FileInputStream fileInputStream = new FileInputStream("books.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Book> bookList = new ArrayList<>();
            while (true) {
                try {
                    Book book = (Book) objectInputStream.readObject();
                    bookList.add(book);
                } catch (Exception e) {
                    break;
                }
            }
            for(Book book : bookList) {
                addBook(book);
            }
            objectInputStream.close();
        } catch (Exception e) {
            throw new RepositoryException("Error when loading state: " + e.getMessage());
        }
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }
}

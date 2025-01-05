package Model;

import java.util.HashMap;

public interface IRepository {
    public Book getBook(String bookName) throws RepositoryException;
    public HashMap<String, Book> getBooks() throws RepositoryException;
    public void addBook(Book book) throws RepositoryException;
    public void deleteBook(String bookName) throws RepositoryException;
    public void saveState() throws RepositoryException;
    public void loadState() throws RepositoryException;
}

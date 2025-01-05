package Model;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import Controller.Controller;

public class Model {
    final private static int MAX_BOOK_LEN = 30;
    final private static int MAX_AUTHOR_LEN = 20;

    private Controller controller;
    private IRepository repo;

    public Model(IRepository repo) {
        this.repo = repo;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public String getBookTable() throws RepositoryException {
        HashMap<String, Book> books = repo.getBooks();
        String output = divider();
        output += row("Book Name", "Author Name");
        for (Book book : books.values()) {
            output += row(book.getBookName(), book.getAuthor());
        }
        return output;
    }

    private String row(String bookName, String authorName) {
        return "|" + lengthString(bookName, MAX_BOOK_LEN) + "|" + lengthString(authorName, MAX_AUTHOR_LEN) + "|\n" + divider();
    }

    private String lengthString(String string, int length) {
        if (string.length() > length) {
            return string.substring(0, length);
        }
        else {
            int spaces = length - string.length();
            for (int i = 0; i < spaces; i++) {
                string += " ";
            }
            return string;
        }
    }

    private String divider() {
        String divider = stretch(MAX_BOOK_LEN);
        divider += stretch(MAX_AUTHOR_LEN);
        divider += "+\n";
        return divider;
    }

    private String stretch(int length) {
        String stretch = "+";
        for (int i = 0; i < length; i++) {
            stretch += "-";
        }
        return stretch;
    }

    public void createBook(String bookName, String author) throws RepositoryException {
        Book book = new Book(bookName, author);
        repo.addBook(book);
    }

    public void deleteBook(String bookName) throws RepositoryException {
        repo.deleteBook(bookName);
    }

    public void editBook(String bookName) throws RepositoryException {
        Book book = repo.getBook(bookName);
        repo.deleteBook(bookName);
        book.setBookName(controller.getNewBookName());
        book.setAuthor(controller.getNewAuthor());
        repo.addBook(book);
    }

    private void putNewBooks(Collection<Book> newBooks) throws RepositoryException {
        for (Book book : newBooks) {
            repo.addBook(book);
        }
    }

    public void CSVExport() throws IOException, RepositoryException {
        HashMap<String, Book> books = repo.getBooks();
        ArrayList<String> content = new ArrayList<>();
        for (Book book : books.values()) {
            content.add(book.getInstanceAsDelimitedString(","));
        }
        try {
            Files.write(csvPath(), content, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            throw e;
        }
    }

    public void JSONExport() throws IOException, RepositoryException {
        Gson gson = new Gson();
        String json = gson.toJson(repo.getBooks());
        try {
            Files.write(jsonPath(), json.getBytes(StandardCharsets.UTF_8));
        }
        catch (IOException e) {
            throw e;
        }
    }

    public void XMLExport() throws IOException, RepositoryException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(repo.getBooks());
            Files.write(xmlPath(), xml.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw e;
        }
    }

    public void CSVImport() throws IOException, RepositoryException {
        try {
            List<String> lines = Files.readAllLines(csvPath());
            for(String line : lines) {
                Book book = Book.getBookFromDelimitedString(line, ",");
                if (book != null) {
                    repo.addBook(book);
                }
            }
        }
        catch (IOException e) {
            throw e;
        }
    }

    public void JSONImport() throws IOException, RepositoryException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(jsonPath()), StandardCharsets.UTF_8);
        Type listType = new TypeToken<List<Book>>() {}.getType();
        putNewBooks(gson.fromJson(json, listType));
    }

    public void XMLImport() throws IOException, RepositoryException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = new String(Files.readAllBytes(xmlPath()), StandardCharsets.UTF_8);
        putNewBooks(xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(List.class, Book.class)));
    }

    private Path jsonPath() {
        return Paths.get(System.getProperty("user.dir"), "books.json");
    }

    private Path csvPath() {
        return Paths.get(System.getProperty("user.dir"), "books.csv");
    }

    private Path xmlPath() {
        return Paths.get(System.getProperty("user.dir"), "books.xml");
    }   

    public void loadState() throws RepositoryException {
        repo.loadState();
    }

    public void saveState() throws RepositoryException {
        repo.saveState();
    }
}

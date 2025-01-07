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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;

import Controller.Controller;

public class Model {
    final private static int MAX_BOOK_LEN = 30;
    final private static int MAX_AUTHOR_LEN = 20;

    private Controller controller;
    private HashMap<String, Book> books;

    public Model() {
        books = new HashMap<String, Book>();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public String getBookTable() {
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

    public void addBook(String bookName, String author) {
        Book book = new Book(bookName, author);
        books.put(bookName, book);
    }

    public void deleteBook(String bookName) {
        try {
            books.remove(bookName);
        }
        catch (Exception e) {
            System.err.println("Could not remove " + bookName);
        }
    }

    public void editBook(String bookName) {
        try {
            Book book = books.get(bookName);
            books.remove(bookName);
            book.setBookName(controller.getNewBookName());
            book.setAuthor(controller.getNewAuthor());
            books.put(bookName, book);
        }
        catch (Exception e) {
            System.err.println("Could not edit " + bookName);
        }
    }

    private void putNewBooks(Collection<Book> newBooks) {
        for (Book book : newBooks) {
            books.put(book.getBookName(), book);
        }
    }

    public void CSVExport() throws IOException {
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

    public void JSONExport() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(getBooks());
        try {
            Files.write(jsonPath(), json.getBytes(StandardCharsets.UTF_8));
        }
        catch (IOException e) {
            throw e;
        }
    }

    public void XMLExport() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(getBooks());
            Files.write(xmlPath(), xml.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw e;
        }
    }

    public void CSVImport() throws IOException {
        try {
            List<String> lines = Files.readAllLines(csvPath());
            for(String line : lines) {
                Book book = Book.getBookFromDelimitedString(line, ",");
                if (book != null) {
                    books.put(book.getBookName(), book);
                }
            }
        }
        catch (IOException e) {
            throw e;
        }
    }

    public void JSONImport() throws IOException {
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(jsonPath()), StandardCharsets.UTF_8);
            Type listType = new TypeToken<List<Book>>() {}.getType();
            putNewBooks(gson.fromJson(json, listType));
        } catch (Exception e) {
            throw e;
        }
    }

    public void XMLImport() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(xmlPath()), StandardCharsets.UTF_8);
            putNewBooks(xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(List.class, Book.class)));
        }
        catch (Exception e) {
            throw e;
        }
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

    private Collection<Book> getBooks() {
        return books.values();
    }    
    
    public void saveState() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("books.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(Book book : books.values()) {
                objectOutputStream.writeObject(book);
            }
            objectOutputStream.close();
        }
        catch (Exception e) {
            System.err.println("Could not save state");
        }
    }

    public void loadState() {
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
            putNewBooks(bookList);
            objectInputStream.close();
        } catch (Exception e) {
            System.err.println("Could not load state: " + e);
        }
    }
}

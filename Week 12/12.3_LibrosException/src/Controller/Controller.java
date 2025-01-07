package Controller;

import java.io.IOException;

import Model.Model;
import View.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        model.loadState();
        view.run();
    }

    public String getBookTable() {
        return model.getBookTable();
    }

    public void addBook(String bookName, String author) {
        model.addBook(bookName, author);
    }

    public void deleteBook(String bookName) {
        model.deleteBook(bookName);
    }

    public void editBook(String bookName) {
        model.editBook(bookName);
    }

    public void CSVExport() throws IOException {
        model.CSVExport();
    }

    public void JSONExport() throws IOException {
        model.JSONExport();
    }

    public void XMLExport() throws IOException {
        model.XMLExport();
    }

    public void CSVImport() throws IOException {
        model.CSVImport();
    }

    public void JSONImport() throws IOException {
        model.JSONImport();
    }

    public void XMLImport() throws IOException {
        model.XMLImport();
    }

    public String getNewBookName() {
        return view.getNewBookName();
    }

    public String getNewAuthor() {
        return view.getNewAuthor();
    }

    public void saveState() {
        model.saveState();
    }
}

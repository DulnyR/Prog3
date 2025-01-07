package Controller;

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

    public void CSVExport() {
        model.CSVExport();
    }

    public void JSONExport() {
        model.JSONExport();
    }

    public void XMLExport() {
        model.XMLExport();
    }

    public void CSVImport() {
        model.CSVImport();
    }

    public void JSONImport() {
        model.JSONImport();
    }

    public void XMLImport() {
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

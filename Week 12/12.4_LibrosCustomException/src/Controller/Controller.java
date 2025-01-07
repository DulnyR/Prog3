package Controller;

import java.io.IOException;

import Model.Model;
import Model.RepositoryException;
import View.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        try {
            model.loadState();
        } catch (RepositoryException re) {
            view.printErrorMessage(re.getMessage());
        }
        
        view.run();
    }

    public String getBookTable() throws RepositoryException {
        return model.getBookTable();
    }

    public void addBook(String bookName, String author) throws RepositoryException {
        model.createBook(bookName, author);
    }

    public void deleteBook(String bookName) throws RepositoryException {
        model.deleteBook(bookName);
    }

    public void editBook(String bookName) throws RepositoryException {
        model.editBook(bookName);
    }

    public void CSVExport() throws IOException, RepositoryException {
        model.CSVExport();
    }

    public void JSONExport() throws IOException, RepositoryException  {
        model.JSONExport();
    }

    public void XMLExport() throws IOException, RepositoryException  {
        model.XMLExport();
    }

    public void CSVImport() throws IOException, RepositoryException  {
        model.CSVImport();
    }

    public void JSONImport() throws IOException, RepositoryException  {
        model.JSONImport();
    }

    public void XMLImport() throws IOException, RepositoryException  {
        model.XMLImport();
    }

    public String getNewBookName() {
        return view.getNewBookName();
    }

    public String getNewAuthor() {
        return view.getNewAuthor();
    }

    public void saveState() throws RepositoryException {
        model.saveState();
    }
}

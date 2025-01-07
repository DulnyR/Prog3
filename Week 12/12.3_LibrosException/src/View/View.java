package View;

import java.io.IOException;

import com.coti.tools.Esdia;

import Controller.Controller;

public class View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("Welcome to Book Viewer!");

        int input = 0;

        while (input != 11) {
            input = Esdia.readInt(
                "1. Show list of books in a table\n" +
                "2. Add new book\n" +
                "3. Delete book\n" +
                "4. Edit book\n" +
                "5. Export to CSV\n" +
                "6. Export to JSON\n" +
                "7. Export to XML\n" +
                "8. Import CSV\n" +
                "9. Import JSON\n" +
                "10. Import XML\n" +
                "11. Exit\n" +
                "Choose option: "
            );

            switch (input) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    CSVExport();
                    break;
                case 6:
                    JSONExport();
                    break;
                case 7:
                    XMLExport();
                    break;
                case 8:
                    CSVImport();
                    break;
                case 9:
                    JSONImport();
                    break;
                case 10:
                    XMLImport();
                    break;
                case 11:
                    saveState();
                    break;
                default:
                    System.out.println("Incorrect option.");
                    break;
            }
        }
    }

    private void showBooks() {
        System.out.println(controller.getBookTable());
    }

    private void addBook() {
        String bookName = Esdia.readString("Enter book name: ");
        String author = Esdia.readString("Enter author name: ");
        controller.addBook(bookName, author);
    }

    private void deleteBook() {
        showBooks();
        String bookName = Esdia.readString("Enter name of book to delete: ");
        controller.deleteBook(bookName);
    }

    private void editBook() {
        showBooks();
        String bookName = Esdia.readString("Enter name of book to edit: ");
        controller.editBook(bookName);
    }

    private void CSVExport() {
        try {
            controller.CSVExport();
        } catch(IOException e) {
            System.err.println("Error when exporting CSV file: ");
        }
    }

    private void JSONExport() {
        try {
            controller.JSONExport();
        } catch(IOException e) {
            System.err.println("Error when exporting JSON file: ");
        }
    }

    private void XMLExport() {
        try {
            controller.XMLExport();
        } catch(IOException e) {
            System.err.println("Error when exporting XML file: ");
        }
    }

    private void CSVImport() {
        try {
            controller.CSVImport();
        } catch(IOException e) {
            System.err.println("Error when importing CSV file: ");
        }
    }

    private void JSONImport() {
        try {
            controller.JSONImport();
        } catch(IOException e) {
            System.err.println("Error when importing JSON file: ");
        }
    }

    private void XMLImport() {
        try {
            controller.XMLImport();
        } catch(IOException e) {
            System.err.println("Error when importing XML file: ");
        }
    }

    private void saveState() {
        controller.saveState();
    }

    public String getNewBookName() {
        return Esdia.readString("Enter new book name: ");
    }

    public String getNewAuthor() {
        return Esdia.readString("Enter new author name: ");
    }
}

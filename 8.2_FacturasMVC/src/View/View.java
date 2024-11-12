package View;

import java.util.ArrayList;

import com.coti.tools.Esdia;

import Controller.Controller;
import Model.Bill;

public class View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("Welcome to Bill Viewer!");

        options();
    }

    public void options() {
        String answer = "";
        while(!answer.equals("q")) {
            answer = Esdia.readString(
            "1.- Import files from disc\n" +
            "2.- Get minimum value\n" +
            "3.- Get list of bills (given minimum price)\n" +
            "4.- Print bills\n" +
            "5.- Export options\n" +
            "q.- Exit\n" +
            "Choose Option: "
            );

            switch (answer) {
                case "1":
                    String fileName = Esdia.readString("Enter file name: ");
                    controller.importFile(fileName);
                    System.out.println("File imported successfully");
                    break;
                case "2":
                    int minimumValue = Esdia.readInt("Enter minimum value: ");
                    controller.setMinimumValue(minimumValue);
                    System.out.println("Minimum value has been set to " + minimumValue);
                    break;
                case "3":
                    ArrayList<Bill> filteredBills = controller.getFilteredBills();
                    for(Bill bill : filteredBills) {
                        System.out.println(bill.toString());
                    }
                    break;
                case "4":
                    ArrayList<Bill> bills = controller.getBills();
                    for(Bill bill : bills) {
                        System.out.println(bill.toString());
                    }
                    break;
                case "5":
                    generateFile();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    private void generateFile() {
        int option = 0;
        while (option < 1 || option > 3) {
            option = Esdia.readInt("Enter format (1 - HTML, 2 - CSV): ");
            switch(option) {
                case 1:
                    controller.generateHTML();
                    System.out.println("HTML generated successfully");
                    break;
                case 2:
                    controller.generateCSV();
                    System.out.println("CSV generated successfully");
                    break;
                default:
                    break;
            }
        }
    }
}

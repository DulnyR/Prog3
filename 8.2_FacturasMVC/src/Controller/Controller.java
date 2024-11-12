package Controller;

import Model.Model;
import View.View;

import java.util.ArrayList;

import Model.Bill;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.run();
    }

    public void importFile(String fileName) {
        model.importFile(fileName);
    }

    public void setMinimumValue(int minimumValue) {
        model.setMinimumValue(minimumValue);
    }

    public ArrayList<Bill> getFilteredBills() {
        return model.getFilteredBills();
    }

    public ArrayList<Bill> getBills() {
        return model.getBills();
    }

    public void generateHTML() {
        model.generateHTML();
    }

    public void generateCSV() {
        model.generateCSV();
    }
}

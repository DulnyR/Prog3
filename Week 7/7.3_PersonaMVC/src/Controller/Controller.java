package Controller;

import java.util.ArrayList;

import Model.Model;
import Model.Person;
import View.View;

public class Controller {
    Model model;
    View view;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.run();
    }

    public void importData(String fileName) {
        model.importData(fileName);
    }

    public ArrayList<Person> getPeople() {
        return model.getPeople();
    }
}

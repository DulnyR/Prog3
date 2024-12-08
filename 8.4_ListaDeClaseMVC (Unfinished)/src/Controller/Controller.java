package Controller;

import Model.Model;
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
}

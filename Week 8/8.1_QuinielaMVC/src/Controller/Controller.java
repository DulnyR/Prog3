package Controller;

import java.util.ArrayList;

import Model.Match;
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

    public void processFile(String fileName) {
        model.processFile(fileName);
    }

    public void fileReadSuccess(String fileName) {
        view.fileReadSuccess(fileName);
    }

    public void fileReadFail(String fileName) {
        view.fileReadFail(fileName);
    }

    public ArrayList<Match> getMatches() {
        return model.getMatches();
    }
}

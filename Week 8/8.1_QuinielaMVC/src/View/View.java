package View;
import java.util.ArrayList;

import com.coti.tools.Esdia;

import Controller.Controller;
import Model.Match;

public class View {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("Welcome to Match Viewer!\n");

       askForFile();

       printMatches();
    }

    public void askForFile() {
        String fileName = Esdia.readString("Enter file name: ");

        controller.processFile(fileName);
    }

    public void fileReadSuccess(String fileName) {
        System.out.println("Reading " + fileName + " was successful!");
    }

    public void fileReadFail(String fileName) {
        System.out.println("Could not read " + fileName + ".");
    }

    public void printMatches() {
        ArrayList<Match> matches = controller.getMatches();
        for(Match match: matches) {
            System.out.println(match.getHomeTeam().getTeamName() + " played against " + match.getAwayTeam().getTeamName());
        }
    }
}

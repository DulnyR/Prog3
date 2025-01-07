package Model;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Controller.Controller;

public class Model {
    private Pools pools;
    private Controller controller;

    public Model() {
        pools = new Pools();
    }

    public Pools getPools() {
        return pools;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setPools(Pools pools) {
        this.pools = pools;
    }

    public void processFile(String fileName) {
        Path path = Paths.get(System.getProperty("user.dir"), fileName);
        File fileRef = path.toFile();

        if (fileRef.exists() && fileRef.isFile()) {
            controller.fileReadSuccess(fileName);
            List<String> lines;

            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                linesToMatches(lines);
            }
            catch (Exception e) {
                controller.fileReadFail(fileName + " " + e);
            }
        }
        else {
            controller.fileReadFail(fileName);
        }
    }

    public void linesToMatches(List<String> lines) {
        for(String line: lines) {
            String[] teams = line.split("-");
            Team homeTeam = new Team(teams[0]);
            Team awayTeam = new Team(teams[1]);
            Match match = new Match(homeTeam, awayTeam);
            pools.addMatch(match);
        }
    }

    public ArrayList<Match> getMatches() {
        return pools.getMatches();
    }
}

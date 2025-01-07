package Model;

import java.util.ArrayList;

public class Pools {
    private ArrayList<Match> matches;

    Pools() {
        matches = new ArrayList<Match>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void clearPool() {
        matches = new ArrayList<Match>();
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}

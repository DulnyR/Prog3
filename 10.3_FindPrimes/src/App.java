import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PrimeFinder> finders = new ArrayList<>();

        int limit = 100000;

        finders.add(new NaiveFinder("Naive", limit));
        finders.add(new EratostenesFinder("Erato", limit));

        for (PrimeFinder finder : finders) {
            finder.calculate();
        }
    }
}

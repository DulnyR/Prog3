import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PrimeFinder> finders = new ArrayList<>();

        finders.add(new NaiveFinder("Naive", 1000));
        finders.add(new EratostenesFinder("Erato", 1000));

        for (PrimeFinder finder : finders) {
            finder.calculate();
        }
    }
}

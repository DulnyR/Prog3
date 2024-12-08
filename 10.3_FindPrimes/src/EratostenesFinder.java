import java.util.ArrayList;

public class EratostenesFinder extends PrimeFinder {

    EratostenesFinder(String string, int limit) {
        super(string, limit);
    }

    @Override
    public ArrayList<Integer> calculatePrimes() {
        int tope = (int) Math.floor(Math.sqrt(limit)) + 1;

        ArrayList<Integer> compuestos = new ArrayList<>();
        for (int i = 2; i <= tope; i++) {
            if (!compuestos.contains(i)) {
                for (int j = i; j <= limit / i + 1; j++)
                    compuestos.add(i * j);
            }
        }

        return compuestos;
    }
}

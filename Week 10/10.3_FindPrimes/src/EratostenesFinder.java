import java.util.ArrayList;
import java.util.List;

public class EratostenesFinder extends PrimeFinder {

    EratostenesFinder(String string, int limit) {
        super(string, limit);
    }

    @Override
    public ArrayList<Integer> calculatePrimes() {
		int tope = (int) Math.floor(Math.sqrt(limit)) + 1;

		List<Long> compuestos = new ArrayList<Long>();
        ArrayList<Integer> primos = new ArrayList<Integer>();
		int pos = 0;
		for (int i = 2; i <= tope; i++) {
			if (!compuestos.contains(Long.valueOf(i))) {
				for (int j = i; j <= limit / i + 1; j++)
					compuestos.add(Long.valueOf(i * j));
			}
		}

		for (pos = 2; pos < limit; pos++) {
			if (!compuestos.contains(Long.valueOf(pos)))
				primos.add(pos);
		}

        return primos;
    }
}

import java.util.ArrayList;

public class NaiveFinder extends PrimeFinder {

    NaiveFinder(String name, int limit) {
        super(name, limit);
    }

    @Override
    public ArrayList<Integer> calculatePrimes() {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    static boolean isPrime(int n)
    {
        if (n <= 1) {
            return false;
        }
            
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


}

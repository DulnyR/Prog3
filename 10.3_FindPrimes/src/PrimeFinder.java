import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public abstract class PrimeFinder {
    String name;
    int limit;
    long requiredTime;
    int primeQuantity;

    PrimeFinder(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    public long getRequiredTime() {
        return requiredTime;
    }

    public int getPrimeQuantity() {
        return primeQuantity;
    }

    public void calculate() {
        Instant start = Instant.now();
        ArrayList<Integer> primes = calculatePrimes();
        Instant finish = Instant.now();
        requiredTime = Duration.between(start, finish).toMillis();
        System.out.println("ha tardado " + requiredTime + " ms en encontrar " + primes.size() + " primos hasta el numero " + limit);
    }

    public abstract ArrayList<Integer> calculatePrimes();

}

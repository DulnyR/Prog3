package com.maven;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Abstract class for Prime Finder.
 */
public abstract class PrimeFinder {
    String name;
    int limit;
    long requiredTime;
    int primeQuantity;

    /**
     * Constructor for Prime Finder.
     * @param name name of finder
     * @param limit number where to stop
     */
    PrimeFinder(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    /**
     * Method returns name of Prime Finder.
	 * @return name of prime finder
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns limit of Prime Finder.
	 * @return limit of Prime Finder.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Method returns required time of Prime Finder.
	 * @return required time of Prime Finder.
     */
    public long getRequiredTime() {
        return requiredTime;
    }

    /**
     * Method returns quantity of primes.
	 * @return quantity of primes.
     */
    public int getPrimeQuantity() {
        return primeQuantity;
    }

    /**
     * Method calculates time required to calculate primes.
     */
    public final void calculate() {
        Instant start = Instant.now();
        ArrayList<Integer> primes = calculatePrimes();
        Instant finish = Instant.now();
        requiredTime = Duration.between(start, finish).toMillis();
        System.out.println(name + " ha tardado " + requiredTime + " ms en encontrar " + primes.size() + " primos hasta el numero " + limit);
    }

    /**
     * Method calculates primes.
     * @return array list of primes.
     */
    public abstract ArrayList<Integer> calculatePrimes();

}

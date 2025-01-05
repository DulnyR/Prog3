package com.maven;

import java.util.ArrayList;

/**
 * Class for Naive Finder.
 */
public class NaiveFinder extends PrimeFinder {

    /**
     * Constructor for Naive Finder.
     * @param name name of finder
     * @param limit number where to stop
     */
    NaiveFinder(String name, int limit) {
        super(name, limit);
    }

    /**
     * Calculates primes with naive method.
	 * @return ArrayList of primes
     */
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

    /**
     * Checks if number is prime.
	 * @param n number to check
	 * @return Boolean stating whether n is prime or not
     */
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

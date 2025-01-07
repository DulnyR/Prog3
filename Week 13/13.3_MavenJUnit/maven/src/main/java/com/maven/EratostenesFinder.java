package com.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for Eratosthenes sieve
 */
public class EratostenesFinder extends PrimeFinder {

	/**
     * Constructor for Eratosthenes sieve.
	 * @param name name of finder
	 * @param limit number where to stop
     */
    EratostenesFinder(String name, int limit) {
        super(name, limit);
    }

	/**
     * Method calculates compound numbers using Eratosthenes sieve and then gets all non-compund (prime) numbers.
	 * @return ArrayList of primes
     */
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

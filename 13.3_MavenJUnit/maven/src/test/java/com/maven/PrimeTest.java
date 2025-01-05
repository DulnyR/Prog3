package com.maven;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimeTest {

    @Test
    public void testIsPrime() {
        Boolean result = NaiveFinder.isPrime(17);
        assertTrue(result);
    }
}

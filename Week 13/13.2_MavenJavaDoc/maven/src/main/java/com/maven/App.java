package com.maven;

import java.util.ArrayList;

// GitHub Pages hecho en https://github.com/DulnyR/JavaDocTest

/**
 * Main app class
 */
public class App {

    /**
    * Default constructor.
    * This constructor initializes the App class.
    */
    public App() {}

    /**
     * Main method.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<PrimeFinder> finders = new ArrayList<>();

        int limit = 100000;

        finders.add(new NaiveFinder("Naive", limit));
        finders.add(new EratostenesFinder("Erato", limit));

        for (PrimeFinder finder : finders) {
            finder.calculate();
        }
    }
}

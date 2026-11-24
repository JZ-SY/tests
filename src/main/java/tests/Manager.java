package tests;
import tests.Assisted_test;
import tests.Design_test;
import tests.Independent_test;
import tests.Tests;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Manager {
    private final ArrayList<Tests> alltests = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(Manager.class.getName());

    public Manager() {
        alltests.add(new Assisted_test);
        alltests.add(new Design_test);
        alltests.add(new Independent_test);
    }


    public int size() {
        return alltests.size();
    }

    public Tests get(int i) {
        return alltests.get(i);
    }

    public Tests find(String name) {
        for (Tests t : alltests) if (t.getName().equals(name)) return t;
        return null;
    }

    public void updateAll() {
        for (Tests t : alltests) {
            try {
                t.update();
            } catch (RuntimeException e) {
                System.out.println(t.getName() + " failed: " + e.getMessage());
            }
        }
    }

    public void report(int tick) {
        System.out.println("=== Report at tick " + tick + " ===");
        for (Tests t : alltests) System.out.println("  " + t);

    }
}
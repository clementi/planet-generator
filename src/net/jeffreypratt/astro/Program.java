package net.jeffreypratt.astro;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

public class Program {
    private static final double MINIMUM_ESI = 0.8;

    public static void main(String[] args) {
        int planetCount = 1000;

        PlanetGenerator generator = new RandomPlanetGenerator();
        PlanetDisplayer displayer = new PlanetDisplayer(System.out);

        Collection<Planet> planets = new HashSet<>();

        for (int i = 0; i < planetCount; i++)
            displayer.display(generator.generate());
    }
}

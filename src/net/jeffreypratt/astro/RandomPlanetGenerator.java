package net.jeffreypratt.astro;

import net.jeffreypratt.stats.RandomX;

public class RandomPlanetGenerator implements PlanetGenerator {
    private static final RandomX random = new RandomX();

    @Override
    public Planet generate() {
        return new Planet(random.nextWeibull(1, 5), random.nextWeibull(1, 1.5), 288 * random.nextWeibull(1, 1.5));
    }
}

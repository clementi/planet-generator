package net.jeffreypratt.astro;

import java.io.PrintStream;

public class PlanetDisplayer {
    private PrintStream out;

    public PlanetDisplayer(PrintStream out) {
        this.out = out;
    }
    public void display(Planet planet) {
        out.println(String.format(
                "%g,%g,%g,%g,%g,%g,%g",
                planet.getMassEm(),
                planet.getRadiusEr(),
                planet.getDensityEd(),
                planet.getGravityEg(),
                planet.getEscapeVelocityEev(),
                planet.getSurfaceTempKelvins(),
                planet.getEsi()));
    }
}

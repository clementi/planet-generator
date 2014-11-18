package net.jeffreypratt.astro;

public class Planet {
    private final double massEm;
    private final double densityEd;
    private final double surfaceTempKelvins;

    private static final double GRAV_CONSTANT = 6.6743e-11;
    private static final double EARTH_MASS_KG = 5.9742412e+24;
    private static final double EARTH_RADIUS_M = 6371010;
    private static final double EARTH_ESCAPE_VELOCITY_M_PER_S = 11188.068;
    private static final double EARTH_GRAVITY_M_PER_S2 = 9.80665;

    public Planet(final double massEm, final double densityEd, final double surfaceTempKelvins) {
        this.massEm = massEm;
        this.densityEd = densityEd;
        this.surfaceTempKelvins = surfaceTempKelvins;
    }

    public double getMassEm() {
        return this.massEm;
    }

    public double getDensityEd() {
        return this.densityEd;
    }

    public double getSurfaceTempKelvins() {
        return this.surfaceTempKelvins;
    }

    public double getRadiusEr() {
        double volume = this.massEm / this.densityEd;
        return Math.cbrt(3 / (4 * Math.PI) * volume);
    }

    public double getEscapeVelocityEev() {
        return Math.sqrt(2 * GRAV_CONSTANT * this.massEm * EARTH_MASS_KG / (this.getRadiusEr() * EARTH_RADIUS_M))
                / EARTH_ESCAPE_VELOCITY_M_PER_S;
    }

    public double getGravityEg() {
        double radiusM = this.getRadiusEr() * EARTH_RADIUS_M;
        return GRAV_CONSTANT * this.massEm * EARTH_MASS_KG / square(radiusM) / EARTH_GRAVITY_M_PER_S2;
    }

    public double getEsi() {
        double radiusEr = this.getRadiusEr();
        double escapeVelocityEev = this.getEscapeVelocityEev();
        return Math.pow(1 - Math.abs((radiusEr - 1) / (radiusEr + 1)), 0.57 / 4)
                * Math.pow(1 - Math.abs((this.densityEd - 1) / (this.densityEd + 1)), 1.07 / 4)
                * Math.pow(1 - Math.abs((escapeVelocityEev - 1) / (escapeVelocityEev + 1)), 0.70 / 4)
                * Math.pow(1 - Math.abs((this.surfaceTempKelvins - 288) / (this.surfaceTempKelvins + 288)), 5.58 / 4);
     }

    private static double square(final double x) {
        return x * x;
    }
}

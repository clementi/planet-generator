package net.jeffreypratt.stats;

import java.util.Random;

public class RandomX extends Random {
    public double nextWeibull(final double scale, final double shape) {
        return scale * Math.pow(-Math.log(1 - this.nextDouble()), 1 / shape);
    }
}

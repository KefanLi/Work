package lab14;

import lab14lib.Generator;

public class SawToothGenerator implements Generator {
    private int period;
    private int state;

    public SawToothGenerator(int period) {
        this.state = 0;
        this.period = period;
    }

    @Override
    public double next() {
        if (state % period != 0) {
            double n = normalize(state);
            state += 1;
            return n;
        }
        state = 0;
        double n = normalize(state);
        state += 1;
        return n;
    }

    private double normalize(int state) {
        double num = (double) state / (period / 2);
        return num - 1;
    }
}

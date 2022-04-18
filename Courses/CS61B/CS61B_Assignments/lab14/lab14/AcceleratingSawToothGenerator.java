package lab14;

import lab14lib.Generator;

public class AcceleratingSawToothGenerator implements Generator {
    private int period;
    private int state;
    private double factor;

    public AcceleratingSawToothGenerator(int period, double factor) {
        this.period = period;
        this.state = 0;
        this.factor = factor;
    }

    @Override
    public double next() {
        if (state % period != 0) {
            double n = normalize(state);
            state += 1;
            return n;
        }
        if (state % period == 0 && state != 0) {
            state = 0;
            double n = normalize(state);
            state += 1;
            this.period = (int) Math.round(period * factor);
            return n;
        }
        double n = normalize(state);
        state += 1;
        return n;
    }

    private double normalize(int state) {
        double num = (double) state / (period / 2);
        return num - 1;
    }
}

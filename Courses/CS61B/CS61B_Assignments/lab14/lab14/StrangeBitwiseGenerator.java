package lab14;

import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;
    private int weiredState;

    public StrangeBitwiseGenerator(int period) {
        this.state = 0;
        this.period = period;
        this.weiredState = state & (state >>> 3) % period;
    }

    @Override
    public double next() {
        if (state % period != 0) {
            double n = normalize(weiredState);
            state += 1;
            weiredState = state & (state >>> 3) % period;
            return n;
        }
        state = 0;
        weiredState = state & (state >>> 3) % period;
        double n = normalize(weiredState);
        state += 1;
        weiredState = state & (state >>> 3) % period;
        return n;
    }

    private double normalize(int state) {
        double num = (double) state / (period / 2);
        return num - 1;
    }
}

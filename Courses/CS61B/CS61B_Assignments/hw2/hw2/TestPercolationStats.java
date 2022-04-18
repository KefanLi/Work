package hw2;

import org.junit.Test;

public class TestPercolationStats {
    @Test
    public void testPercolationStatsOne() {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats test = new PercolationStats(20, 30, pf);
        System.out.println(test.mean());
        System.out.println(test.stddev());
        System.out.println(test.confidenceHigh());
        System.out.println(test.confidenceLow());
    }
}

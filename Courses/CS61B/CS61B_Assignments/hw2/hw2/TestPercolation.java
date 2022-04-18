package hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPercolation {
    @Test
    public void testPercolationOne() {
        Percolation test = new Percolation(5);
        test.open(3, 4);
        test.open(2, 4);
        test.open(2, 2);
        test.open(2, 3);
        test.open(0, 2);
        test.open(1, 2);
        assertEquals(true, test.isFull(2, 2));
        assertEquals(false, test.percolates());
        test.open(3, 3);
        test.open(4, 3);
        assertEquals(true, test.percolates());
        assertEquals(8, test.numberOfOpenSites());
    }

    @Test
    public void testIsFull() {
        Percolation test = new Percolation(5);
        for (int i = 0; i < 5; i++) {
            test.open(i, 2);
        }
        for (int i = 2; i < 5; i++) {
            test.open(i, 4);
        }
        test.isFull(2, 4);
        assertEquals(false, test.isFull(2, 4));
    }

    @Test
    public void testCornerCase() {
        Percolation test = new Percolation(2);
        test.open(0, 1);
        assertEquals(false, test.isFull(0, 0));
        assertEquals(true, test.isFull(0, 1));
    }

}

import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void isSameNumberTest() {
        assertTrue(Flik.isSameNumber(10, 10));
        assertTrue(Flik.isSameNumber(10, 20));
    }
}

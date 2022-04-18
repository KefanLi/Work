package ArrayMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestArrayMap {

    @Test
    public void testPut() {
        ArrayMap<String, Integer> test = new ArrayMap<String, Integer>();
        for (int i = 0; i < 100; i++) {
            test.put("NO." + i, i);
        }
        boolean flag = test.containsKey("NO.5");
        assertEquals(flag, true);
        int expectedSize = test.size();
        assertEquals(expectedSize, 100);
        int expectedGet = test.get("NO.6");
        assertEquals(expectedGet, 6);
        List<String> L = test.keys();
        List<String> expectedList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            expectedList.add("NO." + i);
        }
        assertEquals(expectedList, L);
    }


}

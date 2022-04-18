package ArrayMap;

import java.util.ArrayList;
import java.util.List;

public class MapHelper {
    public static <K, V> V get(Map61B<K, V> map, K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> m) {
        List<K> keys = m.keys();
        K max = keys.get(0);
        for (int i = 0; i < keys.size(); i++) {
            if ((max.compareTo(keys.get(i)) < 0)) {
                max = keys.get(i);
            }
        }
        return max;
    }
}

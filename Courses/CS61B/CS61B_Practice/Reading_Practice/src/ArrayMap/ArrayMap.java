package ArrayMap;

import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    @Override
    /**
     * returns the size of the map
     */
    public int size() {
        return size;
    }

    @Override
    /**
     * whether the map contains key
     */
    public boolean containsKey(K key) {
        int index = keyFinder(key);
        if (index != -1) {
            return true;
        }
        return false;
    }

    @Override
    /**
     * Associate key with value.
     */
    public void put(K key, V value) {
        int index = keyFinder(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
        } else {
            values[index] = value;
        }
    }

    /**
     * Returns the index of the key, if it exists. Otherwise returns -1.
     * @param key
     * @return
     */
    private int keyFinder(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    /**
     * Returns value, assuming key exists.
     */
    public V get(K key) {
        int index = keyFinder(key);
        return values[index];
    }

    @Override
    /**
     * Returns a list of all keys.
     */
    public List keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }
}

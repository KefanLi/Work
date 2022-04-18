package hw3.hash;

import java.util.List;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Set;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Oomage o : oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            if (map.containsKey(bucketNum)) {
                map.put(bucketNum, map.get(bucketNum) + 1);
            } else {
                map.put(bucketNum, 1);
            }
        }
        Set<Integer> set = map.keySet();
        int size = oomages.size();
        for (int i : set) {
            int numOfEachBucket = map.get(i);
            if (numOfEachBucket > (size / 50) && numOfEachBucket < (size / 2.5)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

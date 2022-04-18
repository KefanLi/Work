package ADTsExamPre;

import java.util.Comparator;
import java.util.HashMap;

import org.junit.Test;

import java.util.Map;

import java.util.PriorityQueue;

public class countCommonWords {
    public static void topPopularWords(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }

        PriorityQueue<String> wordContainer = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o2) - count.get(o1);
            }
        });

        for (String s : count.keySet()) {
            wordContainer.add(s);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(wordContainer.poll());
        }
    }

    @Test
    public void testTopPopularWords() {
        String[] testList = {"1", "1", "2", "2", "2", "3", "3", "3", "3",
                "3", "4", "4", "4", "4", "4", "4", "4",};
        topPopularWords(testList, 3);
    }
}

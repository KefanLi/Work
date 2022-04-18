package InheritanceImplements;

import java.util.*;

public class getWordImplement {
    public static List<String> getWords(String inputFileName) {
        List<String> containerList = new ArrayList<String>();
        In in = new In(inputFileName);
        while (!in.isEmpty()) {
            containerList.add(in.readString());
        }
        return containerList;
    }

    public static int countUniqueWords(List<String> Lst) {
        Set<String> containerSet = new HashSet<String>();
        for (int i = 0; i < Lst.size(); i++) {
            containerSet.add(Lst.get(i));
        }
        return containerSet.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> targets, List<String> words) {
        Map<String, Integer> containerMap = new HashMap<>();
        for (String ithWord : targets) {
            if (containerMap.containsKey(ithWord)) {
                continue;
            }
            int numberOfWord = 0;
            for (String word : words) {
                if (word == ithWord) {
                    numberOfWord += 1;
                }
            }
            containerMap.put(ithWord, numberOfWord);
        }
        return containerMap;
    }
}

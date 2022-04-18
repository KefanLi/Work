
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class HuffmanEncoder {
    public static Map<Character, Integer> buildFrequencyTable(char[] inputSymbols) {
        Map<Character, Integer> frequencyTable = new HashMap<>();
        for (char c : inputSymbols) {
            if (frequencyTable.containsKey(c)) {
                frequencyTable.put(c, frequencyTable.get(c) + 1);
            } else {
                frequencyTable.put(c, 1);
            }
        }
        return frequencyTable;
    }

    public static void main(String[] args) {
        char[] someFile = FileUtils.readFile(args[0]);
        Map<Character, Integer> frequencyTable = buildFrequencyTable(someFile);
        BinaryTrie decodingTrie = new BinaryTrie(frequencyTable);
        ObjectWriter ow = new ObjectWriter(args[0] + ".huf");
        ow.writeObject(decodingTrie);
        Map<Character, BitSequence> lookUpTable = decodingTrie.buildLookupTable();
        List<BitSequence> bitSequenceList = new ArrayList<>();
        for (char c : someFile) {
            BitSequence sequence = lookUpTable.get(c);
            bitSequenceList.add(sequence);
        }
        ow.writeObject(BitSequence.assemble(bitSequenceList));
    }
}

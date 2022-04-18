
import java.util.ArrayList;
import java.util.List;

public class HuffmanDecoder {

    public static void main(String[] args) {
        ObjectReader or = new ObjectReader(args[0]);
        Object trie = or.readObject();
        Object sequence = or.readObject();
        BinaryTrie decodingTrie = (BinaryTrie) trie;
        BitSequence decodingSequence = (BitSequence) sequence;
        List<Character> charList = new ArrayList<>();

        while (decodingSequence.length() >= 1) {
            Match match = decodingTrie.longestPrefixMatch(decodingSequence);
            charList.add(match.getSymbol());
            decodingSequence = decodingSequence.lastNBits(decodingSequence.length()
                    - match.getSequence().length());
        }
        char[] chars = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            chars[i] = charList.get(i);
        }
        FileUtils.writeCharArray(args[1], chars);
    }
}

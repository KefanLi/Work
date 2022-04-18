public class Palindrome {
    /**
     * Returns a deque where the characters appear in the
     * same order as in the String
     *
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word) {
        char[] wordInChar = word.toCharArray();
        Deque<Character> D = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            D.addLast(wordInChar[i]);
        }
        return D;
    }

    /**
     * Find whether the given word is palindrome
     *
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        boolean A = isPalindrome(wordToDeque(word));
        return A;
    }

    /**
     * Helper method for isPalindrome
     *
     * @param D
     * @return
     */
    private boolean isPalindrome(Deque<Character> D) {
        if (D.size() == 1 || D.size() == 0) {
            return true;
        } else {
            if (D.removeFirst() == D.removeLast()) {
                isPalindrome(D);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> D = wordToDeque(word);
        int back = D.size() - 1;
        for (int i = 0; i < back; i++) {
            if (cc.equalChars(D.get(i), D.get(back))) {
                back -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    /* Solution 1: use get method in deque
    public boolean isPalindrome(String word) {
        Deque<Character> D = wordToDeque(word);
        int backOfDeque = D.size() - 1;
        for (int frontOfDeque = 0; frontOfDeque < backOfDeque; frontOfDeque++) {
            if (D.get(frontOfDeque) == D.get(backOfDeque)) {
                backOfDeque -= 1;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
     */
}

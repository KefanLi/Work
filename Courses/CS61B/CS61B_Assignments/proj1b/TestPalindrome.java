import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome1() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("improve"));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("improve", offByOne));
        assertTrue(palindrome.isPalindrome("aabb", offByOne));
        assertTrue(palindrome.isPalindrome("abab", offByOne));
        assertFalse(palindrome.isPalindrome("abcd", offByOne));
        assertTrue(palindrome.isPalindrome("$%$%", offByOne));
        assertTrue(palindrome.isPalindrome("ABAB", offByOne));
        assertFalse(palindrome.isPalindrome("AbAb", offByOne));
    }
}

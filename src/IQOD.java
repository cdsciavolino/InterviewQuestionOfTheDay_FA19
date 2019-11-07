import java.util.HashMap;
import java.util.Map;

// Interview question of the day!
class IQOD {

    /**
     * Returns true iff the characters in word1 can be rearranged to form word2 (i.e.
     * if they are anagrams of each other). False otherwise.
     *
     * Leetcode Reference: https://leetcode.com/problems/valid-anagram/
     *
     * Time: O(n) where n is the max(word1.length(), word2.length())
     * Space: O(c) where c is the number of distinct characters possible
     *
     * @param word1 First word
     * @param word2 Second word
     * @return True or false whether they are anagrams of each other
     */
    static boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Count all the distinct characters in word1
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        for (char c : word1.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Check for unseen characters and unavailable characters
        for (char c : word2.toCharArray()) {
            if (!charCounts.containsKey(c)) return false;
            if (charCounts.get(c) == 0) return false;
            charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
        }
        return true;
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    /**
     * Returns true iff the string `parens` contains a valid series of parentheses (),
     * brackets [], and braces {}. False otherwise.
     *
     *  - Opening brackets must be closed by the same type of bracket
     *  - Opening brackets must be closed in the correct order
     *
     * Leetcode Reference: https://leetcode.com/problems/valid-parentheses/
     *
     * Time: O(n) where n is the length of the input string `parens`
     * Space: O(n) where n is the length of the input string `parens`
     *
     * @param parens string sequence of (, ), [, ], {, } characters
     * @return true or false if the sequence is valid
     */
    static boolean isValidParentheses(String parens) {
        // Create mapping from closing character -> opening character
        Map<Character, Character> matches = new HashMap<Character, Character>();
        matches.put(')', '(');
        matches.put(']', '[');
        matches.put('}', '{');

        // Check for corresponding characters in the string
        Stack<Character> seen = new Stack<Character>();
        for (char c : parens.toCharArray()) {
            if (!matches.containsKey(c)) seen.push(c);              // it's an opening character, push it to `seen`
            else if (seen.isEmpty()) return false;                  // no matching opening character
            else if (matches.get(c) != seen.pop()) return false;    // incorrect matching opening character
        }

        // check no unmatched opening character
        return seen.isEmpty();
    }

    /**
     * Given an absolute path for a file (Unix-style), simplify it to the
     * shortest possible absolute path to the same directory.
     *
     * Formal Constraints & Definitions
     *  - the `.` sequence means stay in the current directory
     *  - the `..` sequence means move up a directory
     *  - the `//` sequence can be interpreted to be `/./`
     *  - the final return string must begin with a `/` character
     *  - you cannot move up further than the root directory
     *
     * Leetcode Reference: https://leetcode.com/problems/simplify-path/
     *
     * Time: O(n) where n is the number of `/` separated operations in input `path`
     * Space: O(n) where n is the number of `/` separated operations in input `path`
     *
     * @param path Absolute path to convert
     * @return The shortest absolute path denoted by the input string `path`
     */
    static String simplifyFilePath(String path) {
        if (path == null || "".equals(path)) return path;

        // Break the original filepath into operations and simulate each operation
        String[] pathOps = path.split("/");
        Stack<String> curPath = new Stack<String>();
        for (int i = 1; i < pathOps.length; i++) {
            String op = pathOps[i];

            // if `//` or `/./`, then do nothing
            if (!op.equals("") && !op.equals(".")) {
                if (op.equals("..")) {
                    // `..` -> move up a directory if we're not in the root directory
                    if (!curPath.isEmpty()) curPath.pop();
                } else {
                    // `desktop` -> move down to `op` directory
                    curPath.push(op);
                }
            }
        }

        // Convert the stack into a `/` separated string and prepend first `/`
        return "/" + String.join("/", curPath);
    }
}

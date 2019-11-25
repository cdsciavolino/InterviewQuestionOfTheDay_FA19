import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IQODTest {
    @Test
    void testAreAnagrams() {
        assertTrue(IQOD.areAnagrams("abcd", "cbad"));
        assertTrue(IQOD.areAnagrams("night", "thing"));
        assertTrue(IQOD.areAnagrams("save", "vase"));
        assertTrue(IQOD.areAnagrams("", ""));
        assertTrue(IQOD.areAnagrams("swims", "swims"));

        assertFalse(IQOD.areAnagrams("notthesamesize", "notthesamesiz"));
        assertFalse(IQOD.areAnagrams("onediffletter", "onedifflettes"));
        assertFalse(IQOD.areAnagrams("saves", "savess"));
        assertFalse(IQOD.areAnagrams("savse", "savee"));
    }

    @Test
    void testValidParentheses() {
        assertTrue(IQOD.isValidParentheses("()"));
        assertTrue(IQOD.isValidParentheses("[]"));
        assertTrue(IQOD.isValidParentheses("{}"));
        assertTrue(IQOD.isValidParentheses("()[]{}"));
        assertTrue(IQOD.isValidParentheses("([{}])"));

        assertFalse(IQOD.isValidParentheses("(]"));
        assertFalse(IQOD.isValidParentheses("([)]"));
        assertFalse(IQOD.isValidParentheses("())"));
        assertFalse(IQOD.isValidParentheses("((()()()())"));
    }

    @Test
    void testAbsoluteFilePath() {
        assertEquals("", IQOD.simplifyFilePath(""));
        assertEquals("/", IQOD.simplifyFilePath("/../"));
        assertEquals("/home/foo", IQOD.simplifyFilePath("/home//foo/"));
        assertEquals("/c", IQOD.simplifyFilePath("/a/./b/../../c/"));
        assertEquals("/c", IQOD.simplifyFilePath("/a/./b/../../c/"));
        assertEquals("/a/b/c", IQOD.simplifyFilePath("/a//b////c/d//././/.."));
        assertEquals(
                "/home/chris/documents/cos226",
                IQOD.simplifyFilePath("/home/chris/desktop/.././/documents/cos226/"));
    }

    @Test
    void testMinWordTransform() {
        List<String> wordList = new ArrayList<String>();
        Collections.addAll(wordList, "hot","dot","dog","lot","log","cog");
        assertEquals(5, IQOD.minWordTransform("hit", "cog", wordList));

        wordList.remove("cog");
        assertEquals(0, IQOD.minWordTransform("hit", "cog", wordList));
        assertEquals(2, IQOD.minWordTransform("hit", "hot", wordList));
        assertEquals(0, IQOD.minWordTransform("cog", "hit", wordList));
    }

    @Test
    void testCheapestFlightsWithLayovers() {
        int numCities = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        assertEquals(200, IQOD.cheapestFlightsWithLayovers(numCities, flights, 0, 2, 1));
        assertEquals(500, IQOD.cheapestFlightsWithLayovers(numCities, flights, 0, 2, 0));

        numCities = 4;
        flights = new int[][] {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1},
                {0, 2, 5},
        };
        assertEquals(3, IQOD.cheapestFlightsWithLayovers(numCities, flights, 0, 3, 2));
        assertEquals(6, IQOD.cheapestFlightsWithLayovers(numCities, flights, 0, 3, 1));
    }
}

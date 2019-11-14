import org.junit.jupiter.api.Test;

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
}

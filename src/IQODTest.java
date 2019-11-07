import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}

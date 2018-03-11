package spbstu;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    private Trie trie;

    @Test
    public void put() {
        trie = new Trie();
        trie.put("test");
        trie.put("tee");
        trie.put("tree");
        assertEquals(trie.printSorted(), "-t-e-e\n" +
                "  \\s-t\n" +
                " \\r-e-e\n");
    }

    @Test
    public void find() {
        trie = new Trie();
        trie.put("test");
        assertEquals(trie.printSorted(), "-t-e-s-t\n");
        assertTrue(trie.find("test"));
        assertFalse(trie.find("tee"));
    }
}
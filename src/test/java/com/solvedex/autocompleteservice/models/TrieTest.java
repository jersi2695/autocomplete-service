package com.solvedex.autocompleteservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TrieTest
{

    private Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
    }

    @Test
    void testInsertAndSearch() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");

        List<String> words = trie.searchWordsWithPrefix( "app" );
        assertEquals(3, words.size());
        assertTrue(words.containsAll(Arrays.asList("app", "apple", "apply")));

        words = trie.searchWordsWithPrefix( "appl" );
        assertTrue(words.contains("apple"));
        assertTrue(words.contains("apply"));
        assertFalse(words.contains("app"));

        assertFalse(trie.searchWordsWithPrefix("xyz").contains("apple"));
    }


    @Test
    void testSearchWordsWithPrefix_NoWordsWithPrefix() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");

        List<String> words = trie.searchWordsWithPrefix("xyz");

        assertEquals(0, words.size());
    }

    @Test
    void testSearchWordsWithPrefix_EmptyTrie() {
        List<String> words = trie.searchWordsWithPrefix("app");

        assertEquals(0, words.size());
    }
}

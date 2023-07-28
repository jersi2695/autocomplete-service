package com.solvedex.autocompleteservice.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Trie
{
    private Node root;

    public Trie(){
        root = new Node();
    }


    public Node getRoot()
    {
        return root;
    }


    public void insert( String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt( i );
            current.getChildren().putIfAbsent(c, new Node());
            current = current.getChildren().get(c);
        }
        current.setEndOfWord( true );
    }

    public List<String> searchWordsWithPrefix( String prefix) {
        List<String> result = new ArrayList<>();
        Node current = root;

        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt( i );
            if (!current.getChildren().containsKey(c)) {
                return result;
            }
            current = current.getChildren().get(c);
        }

        searchWordsFromNode(current, prefix, result);
        return result;
    }

    private void searchWordsFromNode(Node node, String currentWord, List<String> result) {
        if (node.isEndOfWord()) {
            result.add(currentWord);
        }
        for (char c : node.getChildren().keySet()) {
            searchWordsFromNode(node.getChildren().get(c), currentWord + c, result);
        }
    }
}

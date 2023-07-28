package com.solvedex.autocompleteservice.models;


import java.util.HashMap;
import java.util.Map;


public class Node
{
    private Map<Character, Node> children;
    private boolean isEndOfWord;

    public Node() {
        children = new HashMap<>();
    }


    public Map<Character, Node> getChildren()
    {
        return children;
    }


    public void setChildren( final Map<Character, Node> children )
    {
        this.children = children;
    }


    public boolean isEndOfWord()
    {
        return isEndOfWord;
    }


    public void setEndOfWord( final boolean endOfWord )
    {
        isEndOfWord = endOfWord;
    }
}

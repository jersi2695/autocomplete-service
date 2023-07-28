package com.solvedex.autocompleteservice.controllers;

import com.solvedex.autocompleteservice.models.Trie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AutoCompleteController
{

    private final Trie trie;

    public AutoCompleteController(Trie trie){
        this.trie = trie;
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<String>> autocomplete( @RequestParam String prefix) {
        List<String> completions = trie.searchWordsWithPrefix(prefix);
        return ResponseEntity.ok(completions);
    }

}

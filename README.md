# Autocomplete-Service

I used for this solution a Trie, this is a tree data structure used for storing strings allowing all the string that share common prefix they will come from a common node.

The words are loaded in the AutocompleteConfig class, and it creates a bean of Trie that is injected to the AutocompleController, here it is available to future requests.

To test the application run the AutocompleteServiceApplication, then open index.html in your preferred browser. Other option is using postman.

Here is the curl you can import to Postman.

```
curl --location --request GET 'http://localhost:8080/autocomplete?prefix=ABC'
```
package com.solvedex.autocompleteservice.config;

import com.solvedex.autocompleteservice.models.Trie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


@Configuration
public class AutocompleteConfig
{

    Logger logger = LoggerFactory.getLogger( AutocompleteConfig.class );

    @Bean
    public Trie loadTrieData(){
        ClassPathResource resource = new ClassPathResource( "words.txt");
        Trie trie = new Trie();
        try ( InputStreamReader streamReader =
                   new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
              BufferedReader reader = new BufferedReader( streamReader)) {

            String word;
            int count = 0;
            while ((word = reader.readLine()) != null) {
                trie.insert(word);
                count++;
            }
            logger.info( "Trie inserted " + count + " words" );

        } catch (IOException e) {
            logger.error( "Error when trying to read the words file", e );
        }
        return trie;
    }
}

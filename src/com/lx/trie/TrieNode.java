package com.lx.trie;


import lombok.Data;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Data
public class TrieNode {

    private char c;
    private boolean keyNode;

    private String getKeyNodeAsString(){
        return keyNode ? "*" : "";

    }

    private Map<Character, TrieNode> children = new HashMap<>();

    @Override
    public String toString(){
        String jsonX =   "{\"" + String.valueOf(c)  + "\": "+ getJsonValue(children) + "}";

        JSONObject json = new JSONObject(jsonX);


        return json.toString(2);


    }


    public String getJsonValue( Map<Character, TrieNode> children){



        return  "{" +
                children.keySet().stream()
                .map(chdrn -> "\"" +String.valueOf(chdrn + children.get(chdrn).getKeyNodeAsString()) +  "\": "+ getJsonValue(children.get(chdrn).children))
                .collect(Collectors.joining(","))
                + "}";

    }


}




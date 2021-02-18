package com.lx.trie;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Trie {

    TrieNode root;




    public Trie(){
        root = new TrieNode();


    }

    public Trie(List<String> initStrings){

        root = new TrieNode();

        Map<Character,TrieNode> rootTrieMap = new HashMap<>();
        root.setC('Я');
        root.setChildren(rootTrieMap);

       for(String s: initStrings){

           Map<Character,TrieNode> currentMap = rootTrieMap;


           char[] strCharArray =  s.toCharArray();

           for(int i = 0; i< strCharArray.length; i++){

               char c = strCharArray[i];

               final int j = i;

               if(j == strCharArray.length - 1){
                   currentMap.computeIfPresent(c, (k,v) ->{
                      v.setKeyNode(true);
                      return v;
                   });
               }

               currentMap.computeIfAbsent(c,k -> {
                   TrieNode tn =  new TrieNode();
                   tn.setC(k);
                   tn.setKeyNode(j == strCharArray.length - 1);
                   return tn;
               });





               currentMap = currentMap.get(c).getChildren();

           }
       }
    }

    @Override
    public String toString(){
        return this.root.toString();
    }



}

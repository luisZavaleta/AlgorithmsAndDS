package com.lx.trie;

import java.util.List;

public class Main {

    public static void main(String... args){




       List<String > ls = List.of("Luis", "Lex", "Lutor", "Zavaleta", "Zopilote", "Zamorano", "Luciernaga", "Lexico", "Lexicografico", "Batman", "Zava");

        Trie t = new Trie(ls);

        System.out.println(t);

    }
}

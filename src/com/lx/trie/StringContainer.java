package com.lx.trie;

public interface StringContainer {

    public void insert(String key);
    public void remove(String key);
    public void contains(String key);
    public void longestPrefix(String key);
    public void keyStartingWith(String prefix);

}

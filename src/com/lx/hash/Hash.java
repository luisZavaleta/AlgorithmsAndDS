package com.lx.hash;

public interface Hash {

   default public long hash(String key){
       throw new UnsupportedOperationException("");
   }

    default public long hash(String key, int seed){
        throw new UnsupportedOperationException("");
    }
}

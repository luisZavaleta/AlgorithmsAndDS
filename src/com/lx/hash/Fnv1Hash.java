package com.lx.hash;

public class Fnv1Hash implements Hash{

    public static final long BITS_MASK = 0xffffffffL;
    public static final long FNV_BASIS = 0x811c9dc5L;
    public static final long FNV_PRIME = (1 << 24) + 0x193;


    @Override
    public final long hash(String key) {

        byte[] keyb = key.getBytes();

        long hash = FNV_BASIS;
        for(int i = 0; i < keyb.length; i++) {
            hash *= FNV_PRIME;
            hash &= BITS_MASK;
            hash ^= 0xFF & keyb[i];
        }

        return hash;
    }
}

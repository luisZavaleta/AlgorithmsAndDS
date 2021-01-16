package com.lx.bloomfilter.util;


import com.lx.hash.Fnv1Hash;
import com.lx.hash.MurmurHash;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class BloomFilterUtil {

    private static Optional<Set<String>> contacts;


    public static Set<String> getContacts(){



        return contacts.orElseGet(() -> {

            Set<String> defaultContacts = new HashSet();

            defaultContacts.add("Luis");
            defaultContacts.add("Miguel");
            defaultContacts.add("Zavaleta");
            defaultContacts.add("Vazquez");

            contacts =  Optional.of(defaultContacts);


            return contacts.get();
        });

    }


    public int[] findBitCoordinates(long index){

        int bits_per_byte = 8;

        int byteIndex = (int)(index / bits_per_byte);
        int bitOffSet =  (int)(index % bits_per_byte);

        return new int[]{byteIndex, bitOffSet};
    }


    public boolean readBit(byte[] bitArray, long index){

        int[] bitCoordinates = findBitCoordinates(index);

        int byteIndex = bitCoordinates[0];
        int bitOffSet =  bitCoordinates[1];


        return ((bitArray[byteIndex] >> bitOffSet) & 1) == 1;


    }


    public void writeBit(byte[] bitArray, long index){
        int[] bitCoordinates = findBitCoordinates(index);

        int byteIndex = bitCoordinates[0];
        int bitOffSet =  bitCoordinates[1];
        byte mask = (byte)(1 << bitOffSet);

        bitArray[byteIndex] = (byte) (bitOffSet | mask);
    }



    public long[] key2Positions(int seed, String key){

        MurmurHash mh = new MurmurHash();
        Fnv1Hash fnv1 = new Fnv1Hash();

        long hM = mh.hash(key, seed);
        long  hF = fnv1.hash(key);


        return new long[]{hM, hF};
    }



    public long[] initHashFunctions(int numHashFunctions,  int numBits, String key, int seed){

        long[] hashes = key2Positions(seed, key);

        return LongStream.rangeClosed(1,numHashFunctions)
                .map(x -> (hashes[0] + x * hashes[1] + x * x) % numBits)
                .toArray();


    }








}

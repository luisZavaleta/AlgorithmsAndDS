package com.lx.bloomfilter.util;

import com.lx.hash.Fnv1Hash;
import com.lx.hash.MurmurHash;

import java.util.Arrays;

public class MyBloomFilterUtil {

    public static int BITS_PER_BYTE = 8;


    public static long[] getHashes(int seed, String key){

        MurmurHash mh = new MurmurHash();
        Fnv1Hash fnv1 = new Fnv1Hash();

        long hM = mh.hash(key, seed);
        long  hF = fnv1.hash(key);


        return new long[]{hM, hF};
    }


    public static long[] getHashes(int seed, String key, long totalBits){

        long[] hashes = getHashes(seed,key);

        hashes = Arrays.stream(hashes).map(hash -> abs(hash) % totalBits).toArray();


        return hashes;


    }

    private static long abs(long x){

        return (x + (x >> 63)) ^ (x >> 63);
    }

    public static int[] findBitCoordinates(long index){


        int byteIndex = (int)(index / BITS_PER_BYTE);
        int bitOffSet =  (int)(index % BITS_PER_BYTE);

        return new int[]{byteIndex, bitOffSet};
    }

    public static boolean readBit(byte[] bitArray, long index){

        int[] bitCoordinates = findBitCoordinates(index);

        int byteIndex = bitCoordinates[0];
        int bitOffSet =  bitCoordinates[1];

        return ((bitArray[byteIndex] >> bitOffSet) & 1) == 1;
    }



    public static void writeBit(byte[] bitArray, long index){
        int[] bitCoordinates = findBitCoordinates(index);

        int byteIndex = bitCoordinates[0];
        int bitOffSet =  bitCoordinates[1];
        byte mask = (byte)(1 << bitOffSet);

        bitArray[byteIndex] = (byte) (bitOffSet | mask);
    }

}

package com.lx.bloomfilter;


import com.lx.bloomfilter.util.MyBloomFilterUtil;

import java.util.*;

public class MyBloomFilter {


    Set<String> items = new HashSet<String>();
    private int seed = 8759;
    byte[] filterByteArray = new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    private long totalBits = filterByteArray.length *  MyBloomFilterUtil.BITS_PER_BYTE;



    public boolean contains(String item){


        long[] hashes = MyBloomFilterUtil.getHashes(seed, item, totalBits);


        boolean mightExists = Arrays.stream(hashes).allMatch(hash -> MyBloomFilterUtil.readBit(filterByteArray, hash));

        System.out.println("Hashes for " + item + " are " + Arrays.toString(hashes) );
        System.out.println("mightExists ===> " + mightExists);




        if(mightExists){
            return items.contains(item);
        }else{
            return false;
        }

    }


    public void insert(String item){

        if(!contains(item)){
            long[] hashes = MyBloomFilterUtil.getHashes(seed, item, totalBits);

            Arrays.stream(hashes).forEach(hash -> {
                MyBloomFilterUtil.writeBit(filterByteArray, hash);
                items.add(item);

            });

        }
    }







}

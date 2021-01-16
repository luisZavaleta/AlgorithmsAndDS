package com.lx.bloomfilter;

import com.lx.bloomfilter.util.BloomFilterUtil;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class BloomFilter {

    long size;
    long maxSize;
    int seed;
    long numBits;
    int numHashFunctions;



    BloomFilter(long maxSize, float maxTolerance, Optional<Integer> optSeed){

        int seed = optSeed.orElseGet(() -> {
             Random ra = new Random();
             return ra.nextInt();
        });

        this.size = 0;
        this.maxSize = maxSize;
        this.seed = seed;
        this.numBits  = (long) Math.ceil(maxSize * Math.log(maxTolerance)/ Math.log(2d) / Math.log(2d));

        if (numBits > this.maxSize){
            throw new RuntimeException("Overflow");
        }

        this.numHashFunctions = (int)Math.ceil(Math.log(maxTolerance) / Math.log(2d));
       // numElements =



    }


    Set<String> contactList;




    public  BloomFilter initBloomFilter(int minSize){
        contactList = BloomFilterUtil.getContacts();

        int size = 2*contactList.size() > minSize  ? 2*contactList.size() : minSize;

        contactList.stream().forEach(this::insert);

        return this;
    }

    public  void insert(String contact){
        throw new UnsupportedOperationException("To be implemented");
    }


    public boolean checkContact(String contact){

        if(this.contains(contact)){
            return contactList.contains(contact);
        }else{
            return false;
        }

    }

    public boolean contains(String contact){

        throw new UnsupportedOperationException("To be implemented");

    }

    public boolean addContact(String contact){

        if(contactList.add(contact)){
           this.insert(contact);
           return true;
        }

        return false;
    }



}





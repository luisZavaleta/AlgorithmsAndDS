package com.lx;

import com.lx.bloomfilter.util.BloomFilterUtil;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        BloomFilterUtil bfu = new BloomFilterUtil();

        var a = 5;

        var b = a >> 2;



      //  System.out.println((b & 1) == 1);

       /* byte[] ba= new byte[]{23, 101, 100};

        boolean x = bfu.readBit(ba, 8);

        System.out.println(ba[1]);
        System.out.println(Integer.toBinaryString(ba[1]));
        System.out.println(x);

        */

        int varA = 27;
        int index = 2;

        int c = 1 << index;

        System.out.println(Integer.toBinaryString(varA));

        System.out.println(Integer.toBinaryString(c));

        int d = c | varA;

        System.out.println(Integer.toBinaryString(d));







    }



}


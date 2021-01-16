package com.lx.bloomfilter.main;

import com.lx.bloomfilter.MyBloomFilter;

public class Main {

    public static void main(String[] args) {

        MyBloomFilter mbf = new MyBloomFilter();


        mbf.insert("Luis");
        mbf.insert("DDD");
        boolean a =  mbf.contains("Hola");
        boolean b =   mbf.contains("Hola");
        boolean c =  mbf.contains("Mundo");
        boolean d =  mbf.contains("Luis");
        boolean e =  mbf.contains("Zavaleta");
       mbf.contains("AAA");
        mbf.contains("DDD");
        mbf.contains("ZZZ");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);






    }



}


package com.lx.disjoint;

import java.util.Optional;

public class Main {

    public static void main(String ... args){
        DisJoinSet djs = new DisJoinSetNaiveImp();

        djs.init();

        djs.add(Optional.of("BATMAAAAN"));
        djs.add(Optional.of("BATMAAAAN"));

        System.out.println(djs.getMap());


        djs.merge("Vazquez", "Miguel");

        System.out.println(djs.getMap());


        System.out.println(djs.areDisjoint("Vazquez", "Miguel"));

        System.out.println(djs.areDisjoint("Vazquez", "Zavaleta"));


    }
}

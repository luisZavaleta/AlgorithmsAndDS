package com.lx.disjoint;

import java.util.*;
import java.util.stream.Collectors;

public class DisJoinSetNaiveImp implements DisJoinSet{

    Map<String, Set<String>> partitionMap;

    @Override
    public void init() {
        partitionMap = new HashMap<>();

        partitionMap = DisJoinSetUtil.disJoinUniverse.stream().map(x -> {
            Set<String> s = new HashSet<>();
            s.add(x);

            return s;
        }).collect(Collectors.toMap( s  -> (String)s.toArray()[0], s -> s));


        System.out.println(partitionMap);
    }

    @Override
    public Optional<Set<String>> findPartition(String element) {
        return Optional.ofNullable(partitionMap.get(element));
    }

    @Override
    public boolean merge(String a, String b) {

        if(partitionMap.get(a) == null || partitionMap.get(a) == null){
            throw new IllegalArgumentException("One of the elements does not exists");
        }

        if(partitionMap.get(a).equals(partitionMap.get(b))){
            return false;
        }else{
            partitionMap.get(a).addAll(partitionMap.get(b));
            partitionMap.put(b, partitionMap.get(a));
            return true;
        }

    }

    @Override
    public boolean areDisjoint(String a, String b) {
        return  partitionMap.get(a) != null && (partitionMap.get(a) == partitionMap.get(b));
    }


    @Override
    public boolean add(Optional<String> a) {

      boolean containsKey = partitionMap.containsKey(a.orElse(""));

      partitionMap.computeIfAbsent(a.orElse(""), k -> {
          Set s = new HashSet<String>();
          s.add(k);

          return s;
      });

      return containsKey;
    }

    @Override
    public Map<String, Set<String>> getMap() {
        return partitionMap;
    }
}

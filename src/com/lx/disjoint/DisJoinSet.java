package com.lx.disjoint;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface DisJoinSet {

    public void init();

    public Optional<Set<String>> findPartition(String element);

    public boolean merge(String a, String b);

    public boolean areDisjoint(String a, String b);

    public boolean add(Optional<String> a);

    public Map<String, Set<String>> getMap();

}



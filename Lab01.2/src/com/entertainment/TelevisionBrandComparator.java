package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandComparator
        implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        return tv1.getBrand().compareTo(tv2.getBrand());
    }
    /*
     @Override
public int compare(Radish radish1, Radish radish2){
        return radish1.getColor().compareTo(radish2.getColor());
    }
     */
}
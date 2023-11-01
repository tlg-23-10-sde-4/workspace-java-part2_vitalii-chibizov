package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator
        implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        int result = tv1.getBrand().compareTo(tv2.getBrand());

        if (result == 0) {  //  0 means tie by brand
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}
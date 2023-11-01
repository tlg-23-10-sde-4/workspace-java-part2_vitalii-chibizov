package com.entertainment.client;

import java.util.Arrays;
import java.util.List;

import com.entertainment.Television;
import com.entertainment.TelevisionBrandChannelComparator;
import com.entertainment.TelevisionBrandComparator;
import com.entertainment.TelevisionChannelComparator;

public class TelevisionTestSort {

    public static void main(String[] args) {
        // dataset for testing
        List<Television> tvList = createTelevisionList();

        // sort by natural order and print
        tvList.sort(new TelevisionBrandComparator());
        System.out.println("Sorted by brand (natural order)");
        Television.dump(tvList);
        System.out.println("-----------------------");


        // sort by supplied Comparator and print
        tvList.sort(new TelevisionChannelComparator());
        System.out.println("Sorted by channel");
        Television.dump(tvList);
        System.out.println("-----------------------");

        // sort by supplied Comparator and print
        tvList.sort(new TelevisionBrandChannelComparator());
        System.out.println("Sorted by brand, if tied then by channel");
        Television.dump(tvList);
        System.out.println("-----------------------");
    }



    // dataset for testing
    private static List<Television> createTelevisionList() {
        Television tv1 = new Television("Zenith", 30);
        tv1.changeChannel(44);

        Television tv2 = new Television("Hitachi", 10);
        tv2.changeChannel(9);

        Television tv3 = new Television("Sony", 50);
        tv3.changeChannel(13);

        Television tv4 = new Television("RCA", 25);

        Television tv5 = new Television("Hitachi", 5);

        Television tv6 = new Television("Sony", 40);

        return Arrays.asList(tv1, tv2, tv3, tv4, tv5, tv6);
    }
}
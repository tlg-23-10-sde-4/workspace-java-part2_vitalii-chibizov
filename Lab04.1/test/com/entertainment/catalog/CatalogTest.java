package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    //  single brand
    @Test
    public void testFindByBrand() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    @Test
    public void testFindByBrand_returnsTrue_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("WrongBrand");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());  //  check isEmpty -> it IS empty
    }

    @Test
    public void testFindByBrands_returnsTrue_whenWrongBrandInput() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("WrongBrand");
        assertNotNull(tvMap); //  check it exists
        assertFalse(tvMap.isEmpty());  //  check isEmpty -> it IS NOT empty
        assertEquals(0, tvMap.get("WrongBrand").size());
    }

    @Test
    public void testFindByBrands_returnsTrue_ifNumberOfMatchesMatch() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "NO-MATCHES");
        assertEquals(7, tvMap.get("Sony").size());
        assertEquals(9, tvMap.get("Zenith").size());
        assertEquals(0, tvMap.get("NO-MATCHES").size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetInventory_shouldThrowException_dueToReadOnly() {
        Collection<Television> inventory = Catalog.getInventory();
        inventory.removeAll(inventory);
    }

    @Test
    public void testRemoveDuplicates_returnsTrue_ifSizeOfHashSetMatch(){
        Collection<Television> inventory = Catalog.getInventory();
        assertEquals(30,inventory.size());

        Set<Television> uniqueInventory = new HashSet<>(inventory);
        assertEquals(23, uniqueInventory.size());   //  counted in catalog
    }

    @Test
    public void testLoudest_returnsTrueIfLoudestTV_match(){
        Set<Television> uniqueInventory = new HashSet<>(Catalog.getInventory());
        Television theLoudest = new Television();

        for (Television tv : uniqueInventory){
            if (tv.getVolume() > theLoudest.getVolume()){
                theLoudest = tv;
            }
        }
        assertEquals("Sony", theLoudest.getBrand());
        assertEquals(94, theLoudest.getVolume());
    }

}
/*
 catalog.add(new Television("Zenith",  0));
             catalog.add(new Television("Zenith",  0));
    catalog.add(new Television("Sony",    4));
    catalog.add(new Television("Sony",    50));
    catalog.add(new Television("Zenith",  33));
    catalog.add(new Television("RCA",     50));
    catalog.add(new Television("Zenith",  86));
    catalog.add(new Television("Hitachi", 13));
    catalog.add(new Television("Hitachi", 40));
    catalog.add(new Television("Zenith",  46));
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    94)); //  the loudest
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    50)); //  dup
    catalog.add(new Television("Hitachi", 50));
    catalog.add(new Television("Zenith",  37));
    catalog.add(new Television("RCA",     31));
    catalog.add(new Television("Sony",    87));
    catalog.add(new Television("Hitachi", 39));
    catalog.add(new Television("Zenith",  27));
    catalog.add(new Television("Zenith",  12));
    catalog.add(new Television("RCA",     10));
    catalog.add(new Television("Hitachi", 50)); //  dup
    catalog.add(new Television("RCA",     4));
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("RCA",     50)); //  dup
    catalog.add(new Television("Sony",    28));
    catalog.add(new Television("Zenith",  50));
    catalog.add(new Television("Zenith",  77));
    catalog.add(new Television("Sony",    22));
    catalog.add(new Television("RCA",     50)); //  dup
 */

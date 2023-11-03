package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1, tv2;

    @Before
    public void setUp() {
        tv1 = new Television();
        tv2 = new Television();
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_loweBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgException_whenInvalid_lowerBound() {
        tv1.setVolume(-1);
    }

    @Test
    public void setVolume_shouldThrowIllegalArgException_whenInvalid_upperBound() {
        try {
            tv1.setVolume(101);  // should trigger and go to catch
            fail("Should have thrown IllegalArgument exception");
        } catch (IllegalArgumentException e) {
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage());  // check for message accuracy
        }
    }

    @Test   //  you have to say throws in this case because it is checked
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldStoreValue_whenInValid_lowerBound() throws InvalidChannelException {
        tv1.changeChannel(0);
    }

    @Test
    public void testCompareTo() {
        tv1.setBrand("LG");
        tv2.setBrand("Siemens");
        assertTrue(tv1.compareTo(tv2) < 1);  // LG is less then Siemens

        tv2.setBrand("LG");
        assertTrue(tv1.compareTo(tv2) == 0); // they are same
    }

    @Test
    public void testEquals() {
        tv1.setBrand("LG");
        tv2.setBrand("LG");

        //  how to make sure that this
        assertEquals(tv1, tv2);
        //  works just like this
        if (tv1.equals(tv2)){
            System.out.println("equals");} else {
            System.out.println("false");}

        tv2.setBrand("Siemens");

        assertNotEquals(tv1, tv2);
        if (tv1.equals(tv2)){
            System.out.println("equals");} else {
            System.out.println("false");}
    }

}
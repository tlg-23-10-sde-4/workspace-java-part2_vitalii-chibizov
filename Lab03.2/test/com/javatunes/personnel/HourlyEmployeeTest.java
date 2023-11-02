package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    //  fixture -> business object(s) under test
    private HourlyEmployee emp, emp2;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Vitalii", Date.valueOf("2016-02-29"), 30.0, 40.0);
        emp2 = new HourlyEmployee("Vitalii", Date.valueOf("2016-02-29"), 30.0, 40.0);
    }


    @Test
    public void testPay() {
        assertEquals(1200.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(300.0, emp.payTaxes(), .001);
    }

    //  p.113
    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame(){
        assertEquals(emp, emp2);
        //  or  assertTrue(emp.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameDate_sameHours_sameRate(){
        emp2.setName("Alex");
        assertNotEquals(emp, emp2);
        //  or  assertFalse(emp.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentDate_sameHours_sameRate(){
        emp2.setHireDate(Date.valueOf("2023-01-01"));
        assertNotEquals(emp, emp2);
    }


    @Test
    public void equals_shouldReturnFalse_sameName_sameDate_differentHours_sameRate(){
        emp2.setHours(20.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameDate_sameHours_differentRate(){
        emp2.setRate(80.0);
        assertNotEquals(emp, emp2);
    }
/*

    @Test
    public void testHashCode() {
        assertEquals(emp.hashCode(), emp2.hashCode());
        emp2.setHours(20.0);
        assertNotEquals(emp.hashCode(), emp2.hashCode());

    }
*/

}
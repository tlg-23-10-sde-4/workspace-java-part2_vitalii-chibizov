package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    //  fixture -> business object(s) under test
    private SalariedEmployee emp, emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Vitalii", Date.valueOf("2020-02-28"), 4500.0);
        emp2 = new SalariedEmployee("Vitalii", Date.valueOf("2020-02-28"), 4500.0);
    }

    @Test
    public void print(){
        System.out.println(emp);
        System.out.println(emp2);
        System.out.println("-----------------");
    }


    @Test
    public void testPay() {
        assertEquals(4500.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1350.0, emp.payTaxes(), .001);
    }

    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame(){
        assertEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameDate_sameSalary(){
        emp2.setName("Alex");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentDate_sameSalary(){
        emp2.setHireDate(Date.valueOf("2023-01-01"));
        assertNotEquals(emp, emp2);
    }


    @Test
    public void equals_shouldReturnFalse_sameName_sameDate_differentSalary(){
        emp2.setSalary(20_000.0);
        assertNotEquals(emp, emp2);
    }
}
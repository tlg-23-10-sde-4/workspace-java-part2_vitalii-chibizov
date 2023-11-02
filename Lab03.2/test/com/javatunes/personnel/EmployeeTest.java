package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1, emp2;


    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Mary Lou", Date.valueOf("1999-01-01"));
        emp2 = new SalariedEmployee("Mary Lou", Date.valueOf("1999-01-01"));
    }

    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesSame(){
        assertEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameDate(){
        emp2.setName("Alex");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentDate(){
        emp2.setHireDate(Date.valueOf("2016-02-29"));
        assertNotEquals(emp1, emp2);
    }

}
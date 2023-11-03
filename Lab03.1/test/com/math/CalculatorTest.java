/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    //  fixture: business object(s) under test
    private Calculator calc;

    @BeforeClass
    public static void initializeTestRun(){
        System.out.println("finalizeTetRun");
    }

    @Before
    public void setUp(){
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    //  another name - tearDown
    public void cleanUp(){
        System.out.println("cleanUp");
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        double result = calc.divide(5, 2);
        assertEquals(2.5, result, .001);
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(10));
    }
}
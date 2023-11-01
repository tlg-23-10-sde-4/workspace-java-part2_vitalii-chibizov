package com.entertainment;

import java.time.LocalDate;
import java.time.Period;

class Person {
    private String firstName;
    private String lastName;
    private double shoeSize;
    private LocalDate birth;
    private boolean married;

    public Person() {
    }

    public Person(LocalDate birth) {
        this.birth = birth;
    }
    // other ctor not shown


    public String getName() {
        return firstName + lastName;
    }

    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    public LocalDate getBirthDate() {
        return birth;
    }


    public boolean isMarried() {
        return married;
    }
}
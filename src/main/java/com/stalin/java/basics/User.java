package com.stalin.java.basics;

import java.time.Year;

public class User {
    public int age;
    String name;
    UserRoleEnum userRole;
    boolean isMale;
    double salary;

    public int getYearOfBirthFromAge() {
        return Year.now().getValue() - age;
    }

    public String getUserName() {
        return this.name;
    }
}
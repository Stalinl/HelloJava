package com.stalin.java.basics;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello...");

        UserRoleEnum role = UserRoleEnum.ROLE_MASTER_ADMIN;
        System.out.println("Hello..." + role.toString());

        OptionalSample();
        inheritanceSample();
        abstractSample();
    }

    private static void OptionalSample() {

        User user = new User();
        user.name = "Stalin";
        user.age = 30;
        System.out.println("User Name: " + user.name + ". Age: " + user.age);

        // Optional<User> userOptionalX = Optional.of(null); // Will throw exception at runtime
        Optional<User> userOptional = Optional.ofNullable(user);

        boolean isValuePresent = userOptional.isPresent();
        User userX = userOptional.orElse(new User()); // will always call the given function whether you want it or not, regardless of Optional.isPresent() value
        User userY = userOptional.orElseGet(User::new); // will only call the given function when the Optional.isPresent() == false
        userOptional.orElseThrow(IllegalArgumentException::new);

        boolean isAdult = userOptional
                .filter(f -> f.age > 18)
                .isPresent();

        boolean isUserBornBefore2k = userOptional
                .map(User::getYearOfBirthFromAge)
                .filter(year -> year < 2000)
                .isPresent();

        // String userName = Optional.of(user).flatMap(User::getUserName).orElse("");
    }

    private static void inheritanceSample() {
        System.out.println("||||||||||||||||||| -Inheritance Sample");
        MyCalc myCalc = new MyCalc();
        myCalc.addition(2, 3);
        myCalc.multiplication(2, 3);
    }

    private static void abstractSample() {
        System.out.println("||||||||||||||||||| -Abstract Sample");
        WildAnimal wildAnimal = new WildAnimal("Lion", true);
        boolean isDanger = wildAnimal.isDanger;
        String name = wildAnimal.name;

        wildAnimal.move();
        wildAnimal.movingSpeed();
        wildAnimal.dangerDetails();
        wildAnimal.travel();
    }
}

class Calculator {
    public void addition(int x, int y) {
        System.out.println("The sum is: " + (x + y));
    }
}

class MyCalc extends Calculator {
    public void multiplication(int x, int y) {
        System.out.println("The multiplication is: " + (x * y));
    }
}

interface Animal {
    void move();

    void eat();

    void travel();
}

abstract class AnimalBase implements Animal {
    String name;

    public AnimalBase(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Animals can move.");
    }

    public abstract void movingSpeed();
}

class WildAnimal extends AnimalBase {

    boolean isDanger;

    public WildAnimal(String name, boolean isDanger) {
        super(name);
        this.isDanger = isDanger;
    }

    @Override
    public void movingSpeed() {
        System.out.println("All wild animals can walk and run.");
    }

    @Override
    public void eat() {
        System.out.println("Wild animals eat either vegetation or meat.");
    }

    @Override
    public void travel() {
        System.out.println("Wild animals mostly travel long distance.");
    }

    public void dangerDetails() {
        System.out.println(name + (this.isDanger ? " is a dangerous animal." : " is not a harmful animal"));
    }
}
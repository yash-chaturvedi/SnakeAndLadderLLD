package com.lld.model;

/**
 * @author Yash Chaturvedi
 */
public class Die {

    private static final int DEFAULT_SIDES = 6;

    private final int sides;

    public Die(int sides) {
        this.sides = sides;
    }

    public Die() {
        sides = DEFAULT_SIDES;
    }

    public int getSides() {
        return sides;
    }

    public int roll() {
        return (int)(Math.random() * sides) + 1;
    }
}

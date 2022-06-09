package com.lld.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yash Chaturvedi
 */
public class Board {

    private static final int DEFAULT_SIZE = 100;

    private final int size;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        this.size = DEFAULT_SIZE;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public Board() {
        this.size = DEFAULT_SIZE;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}

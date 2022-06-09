package com.lld.model;

import java.util.UUID;

/**
 * @author Yash Chaturvedi
 */
public class Player {

    private final String id;
    private String name;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

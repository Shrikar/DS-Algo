package org.example;

public class Player {
    private Integer position;
    private final String name;

    public Player(String name) {
        this.position = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}

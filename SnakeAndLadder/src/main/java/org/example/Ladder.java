package org.example;

public class Ladder implements Shifter {
    private final Integer from;
    private final Integer to;

    public Ladder(Integer from, Integer to) {
        if (from > to)
            throw new IllegalArgumentException("From should be less than To");
        this.from = from;
        this.to = to;
    }

    @Override
    public void shift(Player player) {
        System.out.printf("%s climbed ladder at %d moved to %d%n", player.getName(), this.from(), this.to());
        player.setPosition(to);
    }

    @Override
    public Integer from() {
        return from;
    }

    @Override
    public Integer to() {
        return to;
    }
}

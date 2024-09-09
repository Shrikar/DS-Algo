package org.example;

public class Snake implements Shifter {
    private final Integer from;
    private final Integer to;

    public Snake(Integer from, Integer to) {
        if (from < to)
            throw new IllegalArgumentException("From should be greater than to");
        this.from = from;
        this.to = to;
    }

    @Override
    public void move(Player player) {
        System.out.printf("%s bitten by snake at %d moved to %d%n", player.getName(), this.from(), this.to());
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

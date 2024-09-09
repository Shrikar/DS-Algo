package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shifter> snakes = List.of(new Snake(98, 79), new Snake(95, 75), new Snake(87, 36), new Snake(62, 19));
        List<Shifter> ladders = List.of(new Ladder(28, 84), new Ladder(80, 99), new Ladder(9, 31), new Ladder(4, 14));
        List<Player> players = List.of(new Player("shrikar"), new Player("keerthi"), new Player("shriyash"));
        RandomStrategy dice = new SixFaceDice();
        Board board = new Board(snakes, ladders, players, dice);
        board.start();
    }
}
package org.example;

import java.util.*;

public class Board {

    final Map<Integer, Shifter> map = new HashMap<>();
    final Queue<Player> playersQ = new ArrayDeque<>();
    final RandomStrategy strategy;

    public Board(List<Shifter> snakes, List<Shifter> ladders, List<Player> players, RandomStrategy strategy) {
        for (int i = 1; i <= 100; i++) {
            map.put(i, null);
        }
        snakes.forEach(s -> map.put(s.from(), s));
        ladders.forEach(l -> map.put(l.from(), l));
        this.strategy = strategy;
        playersQ.addAll(players);
    }

    public void start() {
        while (!playersQ.isEmpty()) {
            Player currentPlayer = playersQ.poll();
            Integer diceResult = strategy.rollDice();
            System.out.println("Dice:: " + diceResult);
            if (currentPlayer.getPosition() + diceResult == 100) {
                System.out.printf("%s reached 100!!!%n", currentPlayer.getName());
            } else if (currentPlayer.getPosition() + diceResult < 100) {
                Shifter shifter = map.get(currentPlayer.getPosition() + diceResult);
                if (shifter != null)
                    shifter.move(currentPlayer);
                else {
                    System.out.printf("%s moved from %d to %d%n", currentPlayer.getName(), currentPlayer.getPosition(), currentPlayer.getPosition() + diceResult);
                    currentPlayer.setPosition(currentPlayer.getPosition() + diceResult);
                }
                playersQ.add(currentPlayer);
            } else {
                System.out.printf("%s cannot move from %d %n", currentPlayer.getName(), currentPlayer.getPosition());
                playersQ.add(currentPlayer);
            }
        }
    }
}

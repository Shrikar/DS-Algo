package org.example;

import java.util.Random;

public class SixFaceDice implements RandomStrategy {
    Random r = new Random(System.currentTimeMillis());

    @Override
    public Integer rollDice() {
        return r.nextInt(1, 7);
    }
}

package org.example.LLDDesigns.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private final int diceSides;
    Dice(int diceSides){
        this.diceSides = diceSides;
    }

    public int rollDice(){
        return ThreadLocalRandom.current().nextInt(diceSides) + 1;
    }

}

package de.baromeus.dueldemo.utils;

import java.util.Random;

public class Utils {
    public static int rollDice(){
        return rollDice(6);
    }
    public static int rollDice(int sides){
        return rollDice(sides, 1);
    }
    public static int rollDice(int sides, int dices){
        Random rand = new Random();
        int count = 0;
        for(int i = 0; i < dices; i++){
            count += rand.nextInt(sides) + 1;
        }
        return count;
    }
}

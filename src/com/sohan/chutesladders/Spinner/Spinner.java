package com.sohan.chutesladders.Spinner;

import com.sohan.chutesladders.Player.Player;

import java.util.List;
import java.util.Random;

public class Spinner {
    private final int MAX_SPIN_NUMBER = 6;
    private final Random randomNumberGenerator = new Random();
    public Spinner() {
    }

    //this will give us a number from 1-6
    public int getSpinNumber(){
        return randomNumberGenerator.nextInt(MAX_SPIN_NUMBER) + 1;
    }

}

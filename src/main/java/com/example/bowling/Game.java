package com.example.bowling;

public class Game {
    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        if (score == 0)
            return 0;
        return -1;
    }
}

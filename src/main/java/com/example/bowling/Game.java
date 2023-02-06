package com.example.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    private List<Integer> rollScore = new ArrayList<>();

    public void roll(int pins) {
        rollScore.add(pins);
    }

    public int score() {
        for (int i = 0; i < rollScore.size(); i++) {
            if (i % 2 == 1)
                score += rollScore.get(i - 1) + rollScore.get(i);
        }


        return score;
    }
}

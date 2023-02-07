package com.example.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int score;
    private List<Integer> rollScore = new ArrayList<>();
    int[] frames = new int[10];
    int frame;
    int frameIndex;

    public void roll(int pins) {
        rollScore.add(pins);
    }

    public int score() {
        frame = 0;
        frameIndex = 1;
        boolean[] isStrike = new boolean[10];

        for (int i = 0; i < rollScore.size(); i++) {
            if (frameIndex == 1 && rollScore.get(i) == 10) {
                frames[frame] += rollScore.get(i) + rollScore.get(i + 1) + rollScore.get(i + 2);
                frame += 1;
                isStrike[frame] = true;
                continue;
            }

            if (!isStrike[frame] && frame >= 1 && rollScore.get(i - 2) + rollScore.get(i - 1) == 10) {
                frames[frame - 1] += rollScore.get(i);
            }

            if (frameIndex == 2) {
                frames[frame] += rollScore.get(i - 1) + rollScore.get(i);
                frame += 1;
                frameIndex = 1;
            } else
                frameIndex += 1;

        }
        return Arrays.stream(frames).sum();
    }
}

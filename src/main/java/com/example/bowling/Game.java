package com.example.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
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
        boolean[] isStrike = new boolean[11];

        for (int i = 0; i < rollScore.size(); i++) {


            if (isLastFrameSpare(i)) {
                addScoreForSpare(i);
            }
            if (frame == 10)
                break;

            if (isSpare(isStrike, i)) {
                addScoreForSpare(i);
            }

            if (isStrike(i)) {
                setStrike(isStrike, i);
                continue;
            }


            if (frameIndex == 2) {
                addScoreToFrame(i);
                frame += 1;
                frameIndex = 1;
            } else
                frameIndex += 1;

        }
        return Arrays.stream(frames).sum();
    }

    private void addScoreToFrame(int i) {
        frames[frame] += rollScore.get(i - 1) + rollScore.get(i);
    }

    private void addScoreForSpare(int i) {
        frames[frame - 1] += rollScore.get(i);
    }

    private void setStrike(boolean[] isStrike, int i) {
        frames[frame] += rollScore.get(i) + rollScore.get(i + 1) + rollScore.get(i + 2);
        frame += 1;
        isStrike[frame] = true;
    }

    private boolean isStrike(int i) {
        return frameIndex == 1 && rollScore.get(i) == 10;
    }

    private boolean isSpare(boolean[] isStrike, int i) {
        return frameIndex == 1 && !isStrike[frame] && frame >= 1 && rollScore.get(i - 2) + rollScore.get(i - 1) == 10;
    }

    private boolean isLastFrameSpare(int i) {
        return frame == 10 && rollScore.get(i - 2) + rollScore.get(i - 1) == 10;
    }
}

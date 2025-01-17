package com.example.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game = new Game();

    @Test
    void zeroPinsKnockedDownShouldReturnZeroScore() {
        game.roll(0);
        game.roll(0);

        var result = game.score();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void rollOneTwoTimesShouldReturnScore2() {
        game.roll(1);
        game.roll(1);

        var result = game.score();

        assertThat(result).isEqualTo(2);
    }

    @Test
    void rollOneThreeTimesShouldReturnScore2() {
        game.roll(1);
        game.roll(1);
        game.roll(1);

        var result = game.score();

        assertThat(result).isEqualTo(2);
    }

    @Test
    void rollSpareShouldReturnScore17() {
        game.roll(5);
        game.roll(5);
        game.roll(7);

        var result = game.score();

        assertThat(result).isEqualTo(17);
    }

    @Test
    void strike3And4ShouldReturnScore24() {
        game.roll(10);
        game.roll(3);
        game.roll(4);

        var result = game.score();

        assertThat(result).isEqualTo(24);
    }

    @Test
    void strikeFollowedBySpareShouldReturnScore33() {
        game.roll(10);
        game.roll(6);
        game.roll(4);
        game.roll(3);

        var result = game.score();

        assertThat(result).isEqualTo(33);
    }

    @Test
    void perfectGameShouldReturn300() {
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }

        var result = game.score();

        assertThat(result).isEqualTo(300);
    }

    @Test
    void spareFollowedBySpareShouldReturnScore30() {
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);

        var result = game.score();

        assertThat(result).isEqualTo(30);
    }

    @Test
    void spareStrikeSpareShouldReturnScore55() {
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(5);

        var result = game.score();

        assertThat(result).isEqualTo(55);
    }

    @Test
    void fullGameWithSparesStrikesAndOpenFramesShouldReturnCorrectScore() {
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(133);
    }

    @Test
    void fullGameWithSparesStrikesAndOpenFramesShouldReturnCorrectScore2() {
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(4);
        game.roll(1);
        game.roll(0);
        game.roll(0);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(6);

        var result = game.score();

        assertThat(result).isEqualTo(164);
    }


}

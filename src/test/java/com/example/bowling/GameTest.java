package com.example.bowling;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

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
}

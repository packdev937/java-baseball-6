package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.GameStatus;
import baseball.domain.TestRandomCreator;
import baseball.service.GameService;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameController 클래스")
class GameControllerTest {

    private GameService gameService;
    private GameController gameController;

    @BeforeEach
    void setup() {
        gameService = new GameService(new TestRandomCreator());
        gameController = new GameController(gameService);
    }

    @Test
    void 스트라이크_세_개일_때_게임_종료_상태를_반환한다() {
        gameController.initializeGame();
        GameStatus gameStatus = gameController.playGameRound(Arrays.asList(1, 2, 3));

        assertEquals(GameStatus.END, gameStatus);
    }

}
package Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Service.GameService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameServiceTest {
    GameService gameService;
    GameBoard board;


    @Before
    public void setup() {
        gameService = new GameService();
        board = new GameBoard();
        board.getGameBoard()[2][1] = null;
    }

    @Test
    public void MVPboard() {
        GameBoard expected = board;
        GameBoard actual = gameService.MVPboard();
        assertEquals(expected,actual);

    }
}

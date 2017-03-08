package SeviceTest;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gillianreynolds-titko on 3/8/17.
 */
public class GameServiceTest {

    GameService gameService;
    GameBoard board;
    GamePiece piece;

    @Before
    public void setUp(){
        gameService = new GameService();
        board = new GameBoard();
        piece = new GamePiece("emptyColor");
    }

    @Test
    public void MVPboardTest(){
            String expected = "redColor";
            board.getGameBoard()[0][1] = piece;
            GameBoard returnedBoard = gameService.MVPboard();
            String actual = returnedBoard.getGameBoard()[0][1].getColor();
            assertEquals(expected, actual);
    }
}


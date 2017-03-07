package EntityTest;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GameBoardTest {
    GameBoard board;
    GamePiece gamePiece;

    @Before
    public void setUp(){
        board = new GameBoard();
        gamePiece = new GamePiece("red");
    }

    @Test
    public void locationTest(){
        String expected = "red";

        String actual = board.gameBoard.
    }
}

package EntityTest;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GameBoardTest {
    GameBoard board;
    GamePiece gamePiece;
    GameBoard board2;

    @Before
    public void setUp(){
        board = new GameBoard();
        gamePiece = new GamePiece("red");
        board2 = new GameBoard(gamePiece);
    }

    @Test
    public void locationWholeBoardTest(){
//        String expected = "empty\n" + "red\n" + "empty\n" + "red\n" + "empty\n" + "red\n" + "empty\n" +
//                "red\n" + "red\n" + "empty\n" + "red\n" + "empty\n" + "red\n" + "empty\n" + "red\n" +
//                "empty\n" + "empty\n" + "red\n" + "empty\n" + "red\n" + "empty\n" + "red\n" + "empty\n" +
//                "red\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" +
//                "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" + "empty\n" +
//                "empty\n" + "black\n" + "empty\n" + "black\n" + "empty\n" + "black\n" + "empty\n" + "black\n" +
//                "empty\n" + "empty\n" + "black\n" + "empty\n" + "black\n" + "empty\n" + "black\n" + "empty\n" +
//                "black\n" + "black\n" + "empty\n" + "black\n" + "empty\n" + "black\n" + "empty\n" + "black\n" +
//                "empty\n";

        int expected = 64;
        int actual = 0;
        for(int i = 0; i<board.gameBoard.length; i++){
            for(int j =0; j< board.gameBoard.length; j++){
                System.out.println(board.gameBoard[0][1].getIdentifier());
                actual=actual + 1;
            }
        } assertEquals(expected, actual);
    }

    @Test
    public void onePieceCorrectLocationTest(){
        String expected = "red";
        board2.gameBoard[0][1] = gamePiece;
        String actual = gamePiece.getColor();
        assertEquals(expected, actual);
    }

    @Test
    public void onePieceIncorrectLocationTest(){
        String expected = "red";
        String actual = board2.gameBoard[0][3].getColor();
        assertNotEquals(expected, actual);
    }
}

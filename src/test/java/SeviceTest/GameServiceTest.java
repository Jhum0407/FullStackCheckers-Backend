package Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Service.GameService;
import eightbitsakabigbyte.Service.MoveRequest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameServiceTest {
    GameService gameService;
    GameBoard board;
    MoveRequest moveRequest;


    @Before
    public void setup() {
        gameService = new GameService();
        board = new GameBoard();
        moveRequest = new MoveRequest();
        board.getGameBoard()[2][1] = null;
//        moveRequest.setId(12);
//        moveRequest.setRow(3);
//        moveRequest.setColumn(0);
    }

//    @Test
//    public void MVPboard() {
//        GameBoard expected = board;
//        GameBoard actual = gameService.MVPboard();
//        assertEquals(expected,actual);
//
//    }

    @Test
    public void noMovesMadeTest() {
        String expected = "empty  -1  false\n" +
                "red  1  false\n" +
                "empty  -1  false\n" +
                "red  2  false\n" +
                "empty  -1  false\n" +
                "red  3  false\n" +
                "empty  -1  false\n" +
                "red  4  false\n" +
                "red  5  false\n" +
                "empty  -1  false\n" +
                "red  6  false\n" +
                "empty  -1  false\n" +
                "red  7  false\n" +
                "empty  -1  false\n" +
                "red  8  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "red  9  false\n" +
                "empty  -1  false\n" +
                "red  10  false\n" +
                "empty  -1  false\n" +
                "red  11  false\n" +
                "empty  -1  false\n" +
                "red  12  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  13  false\n" +
                "empty  -1  false\n" +
                "black  14  false\n" +
                "empty  -1  false\n" +
                "black  15  false\n" +
                "empty  -1  false\n" +
                "black  16  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  17  false\n" +
                "empty  -1  false\n" +
                "black  18  false\n" +
                "empty  -1  false\n" +
                "black  19  false\n" +
                "empty  -1  false\n" +
                "black  20  false\n" +
                "black  21  false\n" +
                "empty  -1  false\n" +
                "black  22  false\n" +
                "empty  -1  false\n" +
                "black  23  false\n" +
                "empty  -1  false\n" +
                "black  24  false\n" +
                "empty  -1  false\n";
        String actual = gameService.getBoard().toString();
        assertEquals(expected,actual);
    }

    @Test
    public void moveRedPieceTest() {
        String expected = "empty  -1  false\n" +
                "red  1  false\n" +
                "empty  -1  false\n" +
                "red  2  false\n" +
                "empty  -1  false\n" +
                "red  3  false\n" +
                "empty  -1  false\n" +
                "red  4  false\n" +
                "red  5  false\n" +
                "empty  -1  false\n" +
                "red  6  false\n" +
                "empty  -1  false\n" +
                "red  7  false\n" +
                "empty  -1  false\n" +
                "red  8  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "red  9  false\n" +
                "empty  -1  false\n" +
                "red  10  false\n" +
                "empty  -1  false\n" +
                "red  11  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "red  12  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  13  false\n" +
                "empty  -1  false\n" +
                "black  14  false\n" +
                "empty  -1  false\n" +
                "black  15  false\n" +
                "empty  -1  false\n" +
                "black  16  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  17  false\n" +
                "empty  -1  false\n" +
                "black  18  false\n" +
                "empty  -1  false\n" +
                "black  19  false\n" +
                "empty  -1  false\n" +
                "black  20  false\n" +
                "black  21  false\n" +
                "empty  -1  false\n" +
                "black  22  false\n" +
                "empty  -1  false\n" +
                "black  23  false\n" +
                "empty  -1  false\n" +
                "black  24  false\n" +
                "empty  -1  false\n";
        moveRequest.setId(12);
        moveRequest.setRow(3);
        moveRequest.setColumn(0);
        gameService.movePiece(moveRequest);
        String actual = gameService.getBoard().toString();
        assertEquals(expected,actual);
    }

    @Test
    public void moveBlackPieceTest() {
        String expected = "empty  -1  false\n" +
                "red  1  false\n" +
                "empty  -1  false\n" +
                "red  2  false\n" +
                "empty  -1  false\n" +
                "red  3  false\n" +
                "empty  -1  false\n" +
                "red  4  false\n" +
                "red  5  false\n" +
                "empty  -1  false\n" +
                "red  6  false\n" +
                "empty  -1  false\n" +
                "red  7  false\n" +
                "empty  -1  false\n" +
                "red  8  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "red  9  false\n" +
                "empty  -1  false\n" +
                "red  10  false\n" +
                "empty  -1  false\n" +
                "red  11  false\n" +
                "empty  -1  false\n" +
                "red  12  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  13  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  14  false\n" +
                "empty  -1  false\n" +
                "black  15  false\n" +
                "empty  -1  false\n" +
                "black  16  false\n" +
                "empty  -1  false\n" +
                "empty  -1  false\n" +
                "black  17  false\n" +
                "empty  -1  false\n" +
                "black  18  false\n" +
                "empty  -1  false\n" +
                "black  19  false\n" +
                "empty  -1  false\n" +
                "black  20  false\n" +
                "black  21  false\n" +
                "empty  -1  false\n" +
                "black  22  false\n" +
                "empty  -1  false\n" +
                "black  23  false\n" +
                "empty  -1  false\n" +
                "black  24  false\n" +
                "empty  -1  false\n";
        moveRequest.setId(13);
        moveRequest.setRow(4);
        moveRequest.setColumn(1);
        gameService.movePiece(moveRequest);
        String actual = gameService.getBoard().toString();
        assertEquals(expected,actual);

    }
}
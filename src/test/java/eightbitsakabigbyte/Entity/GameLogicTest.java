package eightbitsakabigbyte.Entity;

import eightbitsakabigbyte.Service.MoveRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jeriahhumphrey on 3/8/17.
 */
public class GameLogicTest {
    GameLogic logic;
    GameBoard board;
    MoveRequest request;



    @Before
    public void setUp(){
        logic= new GameLogic();
        board = new GameBoard();
        request = new MoveRequest();
        request.setId(15);

    }
    @Test
    public void isLegalMove(){

        assertEquals(15,board.getGameBoard()[5][4].getIdentifier());
    }


    @Test
    public void isLegalMoveToTheRight(){
        request.setRow(4);
        request.setColumn(5);
        assertTrue (logic.isLegalMove(board, request));
    }

    @Test
    public void isLegalMoveToTheLeft(){
        request.setRow(4);
        request.setColumn(3);
        assertTrue (logic.isLegalMove(board, request));
    }

    @Test
    public void isLegalMoveToWrongSpace(){
        request.setRow(4);
        request.setColumn(4);
        assertFalse (logic.isLegalMove(board, request));
    }

    @Test
    public void isLegalMoveOccupiedSpace(){
        request.setId(22);
        request.setRow(6);
        request.setColumn(3);
        assertFalse(logic.isLegalMove(board, request));
    }


}
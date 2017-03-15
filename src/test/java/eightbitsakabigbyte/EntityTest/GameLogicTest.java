package eightbitsakabigbyte.EntityTest;

import eightbitsakabigbyte.Entity.GameLogic;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import eightbitsakabigbyte.Service.GameService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {
    GameLogic logic;
    GamePieces currentPieces;
    GamePieces changedPieces;
    GamePieces changedPieces2;


    @Before
    public void setUp(){
        currentPieces=new GamePieces();
        changedPieces=new GamePieces();
        changedPieces2=new GamePieces();
        logic= new GameLogic();
        currentPieces.createGamePieces();
        changedPieces.createGamePieces();
        changedPieces2.createGamePieces();
        changedPieces.getPiece(13).setRow(4);
        changedPieces.getPiece(13).setColumn(3);

        changedPieces2.getPiece(21).setColumn(3);
        changedPieces2.getPiece(21).setRow(6);


    }

   @Test
    public void comparePiecesTest(){
        assertTrue(logic.comparePiecesOnBoard(currentPieces, changedPieces));
    }

    @Test
    public void comparePiecesTest2(){
        logic.comparePiecesOnBoard(currentPieces, changedPieces);
        assertEquals(13, logic.getChangeIndex() );
    }

    @Test
    public void isOccupiedSpaceTestUnoccupied(){
       assertFalse(logic.isOccupiedSpace(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheRight(){
        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheLeft(){
        changedPieces.getPiece(13).setColumn(1);
        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isIllegalMoveWrongSpotColumn(){
        changedPieces.getPiece(13).setColumn(2);
        assertFalse(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isIllegalMoveWrongSpotRow(){
        changedPieces.getPiece(13).setRow(3);
        assertFalse(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isOccupiedSpaceTestOccupied(){
        assertTrue(logic.isOccupiedSpace(currentPieces, changedPieces2));
    }

    @Test
    public void isIllegalMoveOccupiedSpace(){
        assertFalse(logic.isLegalMovePawn(currentPieces, changedPieces2));
    }














//
//
//    @Test
//    public void isLegalMoveToTheRight(){
//        request.setRow(4);
//        request.setColumn(5);
//        assertTrue (logic.isLegalMove(board, request));
//    }
//
//    @Test
//    public void isLegalMoveToTheLeft(){
//        request.setRow(4);
//        request.setColumn(3);
//        assertTrue (logic.isLegalMove(board, request));
//    }
//
//    @Test
//    public void isLegalMoveToWrongSpace(){
//        request.setRow(4);
//        request.setColumn(4);
//        assertFalse (logic.isLegalMove(board, request));
//    }
//
//    @Test
//    public void isLegalMoveOccupiedSpace(){
//        request.setId(22);
//        request.setRow(6);
//        request.setColumn(3);
//        assertFalse(logic.isLegalMove(board, request));
//    }


}
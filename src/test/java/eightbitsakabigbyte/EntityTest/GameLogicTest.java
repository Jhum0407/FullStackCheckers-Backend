package eightbitsakabigbyte.EntityTest;

import eightbitsakabigbyte.AILogic.PieceMovement;
import eightbitsakabigbyte.AILogic.Pieces;
import eightbitsakabigbyte.Entity.GameLogic;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import eightbitsakabigbyte.Service.GameService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {
    PieceMovement move;
    GameLogic logic;
    GamePieces currentPieces;
    GamePieces changedPieces;
    GamePieces changedPieces2;
    GamePieces changedPiecesKing;
    GamePieces changedPiecesKing2;


    @Before
    public void setUp(){
        move = new PieceMovement();
        currentPieces=new GamePieces();
        changedPieces=new GamePieces();
        changedPieces2=new GamePieces();
        changedPiecesKing= new GamePieces();
        changedPiecesKing2=new GamePieces();
        logic= new GameLogic();
        currentPieces.createGamePieces();
        changedPieces.createGamePieces();
        changedPieces2.createGamePieces();
        changedPiecesKing.createGamePieces();
        changedPiecesKing2.createGamePieces();
        changedPieces.getPiece(13).setRow(4);
        changedPieces.getPiece(13).setColumn(3);

        changedPieces2.getPiece(21).setColumn(3);
        changedPieces2.getPiece(21).setRow(6);

        changedPiecesKing.getPiece(13).setRow(3);
        changedPiecesKing.getPiece(13).setColumn(4);
        //changedPiecesKing2.getPiece(13).setRow(4);
        //changedPiecesKing2.getPiece(13).setColumn(3);




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
        assertTrue(logic.isLegalMove(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheLeft(){
        changedPieces.getPiece(13).setColumn(1);
        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isIllegalMoveWrongSpotColumn(){
        changedPieces.getPiece(13).setColumn(2);
        assertFalse(logic.isLegalMove(currentPieces, changedPieces));
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

    @Test
    public void isLegalMoveUpTotheRightKing(){

        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheLeftKing(){
        changedPieces.getPiece(13).setColumn(1);
        assertTrue(logic.isLegalMove(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveDownTotheLeftKing(){
        assertTrue(logic.isLegalMoveKing(changedPiecesKing, changedPiecesKing2));
    }

    @Test
    public void isLegalMoveDownTotheRightKing(){
        changedPiecesKing2.getPiece(13).setColumn(5);
        assertTrue(logic.isLegalMoveKing(changedPiecesKing, changedPiecesKing2));
    }

    @Test
    public void isAvailableJumpUpperRightTest(){
        changedPieces.getPiece(13).setColumn(3);
        changedPieces.getPiece(13).setRow(4);
        changedPieces.getPiece(10).setColumn(4);
        changedPieces.getPiece(10).setRow(3);
        assertEquals(Pieces.FRIENDLY, move.checkUpperRight(changedPieces.getPiece(13).getRow(), changedPieces.getPiece(13).getColumn(), changedPieces));

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
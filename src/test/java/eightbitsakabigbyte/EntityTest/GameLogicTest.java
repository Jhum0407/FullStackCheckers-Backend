package eightbitsakabigbyte.EntityTest;

import eightbitsakabigbyte.AILogic.PieceMovement;
import eightbitsakabigbyte.Entity.GameLogic;
import eightbitsakabigbyte.Entity.GamePieces;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {
    PieceMovement move;
    GameLogic logic;
    GamePieces currentPieces;
    GamePieces changedPieces;
    GamePieces changedPieces3;
    GamePieces changedPieces2;
    GamePieces changedPiecesKing;
    GamePieces changedPiecesKing2;
    GamePieces blankBoard;


    @Before
    public void setUp() {
        move = new PieceMovement();
        currentPieces = new GamePieces();
        changedPieces = new GamePieces();
        changedPieces2 = new GamePieces();
        changedPieces3=new GamePieces();
        changedPiecesKing = new GamePieces();
        changedPiecesKing2 = new GamePieces();
        logic = new GameLogic();
        currentPieces.createGamePieces();
        changedPieces.createGamePieces();
        changedPieces3.createGamePieces();
        changedPieces2.createGamePieces();
        changedPiecesKing.createGamePieces();
        changedPiecesKing2.createGamePieces();
        changedPieces.getPiece(13).setRow(4);
        changedPieces.getPiece(13).setColumn(3);
        changedPieces2.getPiece(21).setColumn(3);
        changedPieces2.getPiece(21).setRow(6);

        changedPiecesKing.getPiece(13).setRow(3);
        changedPiecesKing.getPiece(13).setColumn(4);
        changedPiecesKing2.getPiece(13).setRow(4);
        changedPiecesKing2.getPiece(13).setColumn(3);


    }

    @Test
    public void comparePiecesTest() {
        assertTrue(logic.comparePiecesOnBoard(currentPieces, changedPieces));
    }

    @Test
    public void comparePiecesTest2() {
        logic.comparePiecesOnBoard(currentPieces, changedPieces);
        assertEquals(13, logic.getChangeIndex());
    }

    @Test
    public void isOccupiedSpaceTestUnoccupied() {
        assertFalse(logic.isOccupiedSpace(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheRight() {
        assertTrue(logic.isLegalMove(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheLeft() {
        changedPieces.getPiece(13).setColumn(1);
        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isIllegalMoveWrongSpotColumn() {
        changedPieces.getPiece(13).setColumn(2);
        assertFalse(logic.isLegalMove(currentPieces, changedPieces));
    }

    @Test
    public void isIllegalMoveWrongSpotRow() {
        changedPieces.getPiece(13).setRow(3);
        assertFalse(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isOccupiedSpaceTestOccupied() {
        assertTrue(logic.isOccupiedSpace(currentPieces, changedPieces2));
    }

    @Test
    public void isIllegalMoveOccupiedSpace() {
        assertFalse(logic.isLegalMovePawn(currentPieces, changedPieces2));
    }

    @Test
    public void isLegalMoveUpTotheRightKing() {

        assertTrue(logic.isLegalMovePawn(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveUpTotheLeftKing() {
        changedPieces.getPiece(13).setColumn(1);
        assertTrue(logic.isLegalMove(currentPieces, changedPieces));
    }

    @Test
    public void isLegalMoveDownTotheLeftKing() {
        assertTrue(logic.isLegalMoveKing(changedPiecesKing, changedPiecesKing2));
    }

    @Test
    public void isLegalMoveDownTotheRightKing() {
        changedPiecesKing2.getPiece(13).setColumn(5);
        assertTrue(logic.isLegalMoveKing(changedPiecesKing, changedPiecesKing2));
    }

    @Test
    public void isAvailableJumpUpperRightTest() {
        changedPieces.getPiece(10).setColumn(4);
        changedPieces.getPiece(10).setRow(3);
        assertTrue(logic.isAvailableJumpUpperRight(changedPieces.getPiece(13), changedPieces));

    }

    @Test
    public void isAvailableJumpUpperLeftTest() {
        changedPieces.getPiece(8).setColumn(2);
        changedPieces.getPiece(8).setRow(3);
        assertTrue(logic.isAvailableJumpUpperLeft(changedPieces.getPiece(13), changedPieces));

    }
    @Test
    public void isAvailableJumpLowerLeftTest() {
        changedPieces.getPiece(13).setIsKing(true);
        changedPieces.getPiece(13).setColumn(4);
        changedPieces.getPiece(13).setRow(3);
        changedPieces.getPiece(10).setColumn(3);
        changedPieces.getPiece(10).setRow(4);
        assertTrue(logic.isAvailableJumpLowerLeft(changedPieces.getPiece(13), changedPieces));

    }

    @Test
    public void isAvailableJumpLowerRightTest() {
        changedPieces.getPiece(14).setIsKing(true);
        changedPieces.getPiece(14).setColumn(2);
        changedPieces.getPiece(14).setRow(3);
        changedPieces.getPiece(8).setColumn(3);
        changedPieces.getPiece(8).setRow(4);
        assertTrue(logic.isAvailableJumpLowerRight(changedPieces.getPiece(14), changedPieces));

    }

    @Test
    public void isTakenJumpLeftTest() {
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(10).setColumn(3);
        changedPieces3.getPiece(10).setRow(4);
        changedPieces3.getPiece(14).setRow(3);
        changedPieces3.getPiece(14).setColumn(2);
        assertTrue(logic.takenJumpLeft(currentPieces,changedPieces3));

    }

    @Test
    public void isTakenJumpLeftResizeTest() {
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(10).setColumn(3);
        changedPieces3.getPiece(10).setRow(4);
        changedPieces3.getPiece(14).setRow(3);
        changedPieces3.getPiece(14).setColumn(2);
        logic.takenJumpLeft(currentPieces,changedPieces3);
        assertEquals(23, changedPieces3.size());

    }
    @Test
    public void isLegalMoveJumpTest() {
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(10).setColumn(3);
        changedPieces3.getPiece(10).setRow(4);
        changedPieces3.getPiece(14).setRow(3);
        changedPieces3.getPiece(14).setColumn(2);
        assertTrue(logic.isLegalMove(currentPieces,changedPieces3));

    }

    @Test
    public void isLegalMoveForceJumpTest() {
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(10).setColumn(3);
        changedPieces3.getPiece(10).setRow(4);
        changedPieces3.getPiece(15).setRow(4);
        changedPieces3.getPiece(15).setColumn(5);
        assertFalse(logic.isLegalMove(currentPieces,changedPieces3));

    }


    @Test
    public void isTakenJumpRighttTest() {
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(13).setRow(3);
        changedPieces3.getPiece(13).setColumn(4);
        assertTrue(logic.takenJumpRight(currentPieces,changedPieces3));

    }
    @Test
    public void isTakenJumpLowerLeftTest() {
        currentPieces.getPiece(13).setIsKing(true);
        currentPieces.getPiece(13).setColumn(4);
        currentPieces.getPiece(13).setRow(3);
        currentPieces.getPiece(10).setColumn(3);
        currentPieces.getPiece(10).setRow(4);
        changedPieces3.getPiece(10).setColumn(3);
        changedPieces3.getPiece(10).setRow(4);
        assertTrue(logic.takenJumpLowerLeft(currentPieces, changedPieces3));

    }

    @Test
    public void isTakenJumpLowerRightTest() {
        currentPieces.getPiece(14).setIsKing(true);
        currentPieces.getPiece(14).setColumn(2);
        currentPieces.getPiece(14).setRow(3);
        currentPieces.getPiece(8).setColumn(3);
        currentPieces.getPiece(8).setRow(4);
        changedPieces3.getPiece(8).setColumn(3);
        changedPieces3.getPiece(8).setRow(4);
        assertTrue(logic.takenJumpLowerRight(currentPieces, changedPieces3));

    }



}



















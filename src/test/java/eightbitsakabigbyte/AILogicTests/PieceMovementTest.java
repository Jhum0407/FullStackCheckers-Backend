package eightbitsakabigbyte.AILogicTests;

import eightbitsakabigbyte.AILogic.PieceMovement;
import eightbitsakabigbyte.AILogic.Pieces;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import org.junit.Before;
import org.junit.Test;

import static eightbitsakabigbyte.AILogic.Pieces.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PieceMovementTest {
    PieceMovement pieceMovement;
    PieceMovement pieceMovement2;
    GamePieces board;
    GamePieces board2;

    @Before
    public void setUp() {
        board = new GamePieces();
        board.createGamePieces();
        board2 = new GamePieces();
        //aiController = new AIController();
        pieceMovement = new PieceMovement();

//        pieceMovement.board.add(new GamePiece(false, 1, 3, 4)); 0
//        pieceMovement.board.add(new GamePiece(true, 2, 4, 5)); 1
//        pieceMovement.board.add(new GamePiece(false, 14, 5, 6)); 2
//        pieceMovement.board.add(new GamePiece(true, 15, 4, 3));
//        pieceMovement.board.add(new GamePiece(true, -1, 7, 0));
//        pieceMovement.board.add(new GamePiece(false, 20, 6, 3));
//        pieceMovement.board.add(new GamePiece(false, 21, 5, 0));
//        pieceMovement.board.add(new GamePiece(false, 10, 4, 1));
//        pieceMovement.board.add(new GamePiece(true, 14, 7, 0));
//
//        pieceMovement2 = new PieceMovement();
//        pieceMovement2.board.add(new GamePiece(false, 19, 6, 3));
//        pieceMovement2.board.add(new GamePiece(false, 3, 5, 4));
//        pieceMovement2.board.add(new GamePiece(false, 5, 3, 4));
//        pieceMovement2.board.add(new GamePiece(false, 17, 4, 3));
//        pieceMovement2.board.add(new GamePiece(true, 2, 3, 4));
//        pieceMovement2.board.add(new GamePiece(false, 4, 2, 2));
    }

    @Test
    public void makeMoveTest() {
        pieceMovement.makeMove(board.getPiece(0), 5, 4);
        int expected = 5;
        int actual = board.getPiece(0).getRow();
        assertEquals(expected, actual);
    }

    @Test
    public void makeMoveTest2() {
        pieceMovement.makeMove(board.getPiece(0), 5, 4);
        int expected = 4;
        int actual = board.getPiece(0).getColumn();
        assertEquals(expected, actual);
    }


    @Test
    public void removePieceTest() {
        pieceMovement.removePiece(board.getPiece(2), board);
        int actual = board.size();
        int expected = 23;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest() {
        Pieces actual = pieceMovement.checkSpace(board.getPiece(1));
        Pieces expected = FRIENDLY;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest2() {
        board.getPiece(2).setIsKing(true);
        Pieces actual = pieceMovement.checkSpace(board.getPiece(2));
        Pieces expected = FRIENDLY_KING;
        assertEquals(expected, actual);
    }


    @Test
    public void checkSpaceTest4() {
        Pieces actual = pieceMovement.checkSpace(board.getPiece(8));
        Pieces expected = FRIENDLY;
        assertEquals(expected, actual);
    }


    @Test
    public void checkUpperLeftTest() {
        Pieces expected = FRIENDLY;
        Pieces actual = pieceMovement.checkUpperLeft(board.getPiece(9), board);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUpperRightTest() {
        Pieces expected = EMPTY;
        Pieces actual = pieceMovement.checkUpperRight(board.getPiece(12), board);
        assertEquals(expected, actual);
    }


    @Test
    public void checkLowerLeftTest() {
        board.getPiece(17).setIsKing(true);
        Pieces expected = ENEMY_KING;
        Pieces actual = pieceMovement.checkLowerLeft(board.getPiece(14), board);
        assertEquals(expected, actual);
    }


    @Test
    public void checkLowerRightTest() {
        Pieces expected = EMPTY;
        Pieces actual = pieceMovement.checkLowerRight(board.getPiece(9), board);
        assertEquals(expected, actual);
    }


    @Test
    public void checkAvailableJumpTest() {
        board.getPiece(14).setRow(4);
        board.getPiece(14).setColumn(4); //place a player piece at (4,4)
        board.getPiece(11).setRow(3);
        board.getPiece(11).setColumn(5); //place an AI piece at (3,5)
        boolean actual= pieceMovement.checkAvailableJump(board.getPiece(17), board);
        boolean expected = true;
        assertEquals(expected, actual);
    }


    @Test
    public void isAvoidJumpTest() {
        board2.setPiece(new GamePiece(false, 1, 3, 2));
        board2.setPiece(new GamePiece(false, 22, 4, 1));

        assertTrue(pieceMovement.isAvoidJump(board2.getPiece(0), board2));
    }


    @Test
    public void isMovingIntoJumpOnNextTurn() {
        board2.setPiece(new GamePiece(false, 1, 3, 2));
        board2.setPiece(new GamePiece(false, 22, 4, 1));

        assertTrue(pieceMovement.isMovingIntoJumpOnNextTurn(board2.getPiece(0), board2));
    }

    @Test
    public void isMovingIntoMultiJumpOnNextTurn() {
        board2.setPiece(new GamePiece(false, 1, 5, 2));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        board2.setPiece(new GamePiece(false, 2, 3, 2));
        assertTrue(pieceMovement.isMovingIntoMultiJumpOnNextTurn(board2.getPiece(0), board2));
    }

    @Test
    public void isGettingKingTest() {
        board2.setPiece(new GamePiece(false, 2, 7, 2));
        assertTrue(pieceMovement.isGettingKing(board2.getPiece(0)));
    }


    @Test
    public void isAJumpTest() {
        board2.setPiece(new GamePiece(false, 1, 5, 2));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        assertTrue(pieceMovement.isAJump(board2.getPiece(0), board2));

    }

    @Test
    public void isJumpTestTwo() {
        board2.setPiece(new GamePiece(true, 1, 7, 2));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        assertTrue(pieceMovement.isAJump(board2.getPiece(0), board2));
    }

    @Test
    public void isJumpTestThree() {
        board2.setPiece(new GamePiece(true, 1, 5, 0));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        assertTrue(pieceMovement.isAJump(board2.getPiece(0), board2));
    }

    @Test
    public void isBlockingOwnJumpTest() {
        board2.setPiece(new GamePiece(false, 1, 3, 6));
        board2.setPiece(new GamePiece(false, 22, 4, 5));
        board2.setPiece(new GamePiece(false, 2, 5, 4));
        assertTrue(pieceMovement.isBlockingOwnJump(board2.getPiece(2), board2));
    }

    @Test
    public void isBlockingOwnJumpTestTwo() {
        board2.setPiece(new GamePiece(false, 1, 2, 1));
        board2.setPiece(new GamePiece(false, 22, 3, 2));
        board2.setPiece(new GamePiece(false, 2, 4, 3));
        assertTrue(pieceMovement.isBlockingOwnJump(board2.getPiece(2), board2));    }

    @Test
    public void isSettingUpJumpTest() {
        board2.setPiece(new GamePiece(false, 1, 5, 2));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        board2.setPiece(new GamePiece(false, 2, 4, 3));
        assertTrue(pieceMovement.isSettingUpOwnJump(board2.getPiece(0), board2));
    }

    @Test
    public void isLeavingOthersForJumpTest() {
        board2.setPiece(new GamePiece(false, 1, 5, 2));
        board2.setPiece(new GamePiece(false, 22, 6, 1));
        board2.setPiece(new GamePiece(false, 2, 4, 3));
        assertTrue(pieceMovement.isLeavingOthersForJump(board2.getPiece(2), board2));    }


}





























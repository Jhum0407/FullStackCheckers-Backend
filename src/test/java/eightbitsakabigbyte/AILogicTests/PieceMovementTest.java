package eightbitsakabigbyte.AILogicTests;

import eightbitsakabigbyte.AILogic.PieceMovement;
import eightbitsakabigbyte.AILogic.Pieces;
import eightbitsakabigbyte.Entity.GamePiece;
import org.junit.Before;
import org.junit.Test;

import static eightbitsakabigbyte.AILogic.Pieces.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PieceMovementTest {
    PieceMovement pieceMovement;
    PieceMovement pieceMovement2;

    @Before
    public void setUp(){
        //aiController = new AIController();
        pieceMovement = new PieceMovement();
        pieceMovement.board.add(new GamePiece(false, 1, 3, 4));
        pieceMovement.board.add(new GamePiece(true, 2, 4, 5));
        pieceMovement.board.add(new GamePiece(false, 14, 5, 6));
        pieceMovement.board.add(new GamePiece(true, 15, 4, 3));
        pieceMovement.board.add(new GamePiece(true, -1, 7, 0));
        pieceMovement.board.add(new GamePiece(false, 20, 6, 3));
        pieceMovement.board.add(new GamePiece(false, 21, 5, 0));
        pieceMovement.board.add(new GamePiece(false, 10, 4, 1));
        pieceMovement.board.add(new GamePiece(true,14,7,0));

        pieceMovement2 = new PieceMovement();
        pieceMovement2.board.add(new GamePiece(false, 19, 6, 3));
        pieceMovement2.board.add(new GamePiece(false, 3, 5, 4));
        pieceMovement2.board.add(new GamePiece(false, 5, 3, 4));
        pieceMovement2.board.add(new GamePiece(false, 17, 4, 3));
        pieceMovement2.board.add(new GamePiece(true, 2, 3, 4));
        pieceMovement2.board.add(new GamePiece(false,4,2,2));
    }

    @Test
    public void makeMoveTest(){
        pieceMovement.makeMove(pieceMovement.board.get(1), 5, 4);
        int expected = 5;
        int actual = pieceMovement.board.get(1).getRow();
        assertEquals(expected, actual);
    }

    @Test
    public void makeMoveTest2(){
        pieceMovement.makeMove(pieceMovement.board.get(1), 5, 4);
        int expected = 4;
        int actual = pieceMovement.board.get(1).getColumn();
        assertEquals(expected, actual);
    }

    @Test
    public void removePieceTest(){
        pieceMovement.removePiece(pieceMovement.board.get(3));
        int actual = pieceMovement.board.size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest(){
        Pieces actual = pieceMovement.checkSpace(pieceMovement.board.get(2));
        Pieces expected = ENEMY;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest2(){
        Pieces actual = pieceMovement.checkSpace(pieceMovement.board.get(3));
        Pieces expected = ENEMY_KING;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest3(){
        Pieces actual = pieceMovement.checkSpace(pieceMovement.board.get(1));
        Pieces expected = FRIENDLY_KING;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest4(){
        Pieces actual = pieceMovement.checkSpace(pieceMovement.board.get(0));
        Pieces expected = FRIENDLY;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSpaceTest5(){
        Pieces actual = pieceMovement.checkSpace(pieceMovement.board.get(4));
        Pieces expected = EMPTY;
        assertEquals(expected, actual);
    }

    @Test
    public void checkUpperLeftTest(){
        Pieces expected = FRIENDLY;
        Pieces actual = pieceMovement.checkUpperLeft(pieceMovement.board.get(1));
        assertEquals(expected, actual);
    }

    @Test
    public void checkUpperRightTest(){
        Pieces expected = EMPTY;
        Pieces actual = pieceMovement.checkUpperRight(pieceMovement.board.get(1));
        assertEquals(expected, actual);
    }

    @Test
    public void checkLowerLeftTest(){
        Pieces expected = ENEMY_KING;
        Pieces actual = pieceMovement.checkLowerLeft(pieceMovement.board.get(0));
        assertEquals(expected, actual);
    }

    @Test
    public void checkLowerRightTest(){
        Pieces expected = EMPTY;
        Pieces actual = pieceMovement.checkLowerRight(pieceMovement.board.get(1));
        assertEquals(expected, actual);
    }

    @Test
    public void checkAvailableJumpTest(){
        pieceMovement.checkAvailableJump(pieceMovement.board.get(0));
        int expected = 6;
        int actual = pieceMovement.board.size();
        assertEquals(expected, actual);
    }

    @Test
    public void isAvoidJumpTest(){
        assertTrue(pieceMovement.isAvoidJump(pieceMovement.board.get(7)));
    }

    @Test
    public void isMovingIntoJumpOnNextTurn(){
        assertTrue(pieceMovement.isMovingIntoJumpOnNextTurn(pieceMovement.board.get(7)));
    }

    @Test
    public void isMovingIntoMultiJumpOnNextTurn(){
        assertTrue(pieceMovement2.isMovingIntoMultiJumpOnNextTurn(pieceMovement2.board.get(1)));
    }

    @Test
    public void isGettingKingTest(){
        assertTrue(pieceMovement.isGettingKing(pieceMovement.board.get(8)));
    }

    @Test
    public void isGettingKingTestTwo(){
        assertFalse(pieceMovement.isAvoidJump(pieceMovement.board.get(4)));
    }
    @Test
    public void isAJumpTest(){
        assertTrue(pieceMovement2.isAJump(pieceMovement2.board.get(1)));
    }
    @Test
    public void isJumpTestTwo(){
        assertFalse(pieceMovement2.isAJump(pieceMovement2.board.get(0)));
    }
    @Test
    public void isJumpTestThree(){
        assertTrue(pieceMovement2.isAJump(pieceMovement2.board.get(4)));
    }
    @Test
    public void isBlockingOwnJumpTest(){
        assertTrue(pieceMovement.isBlockingOwnJump(pieceMovement.board.get(6)));
    }

    @Test
    public void isBlockingOwnJumpTestTwo(){
        assertFalse(pieceMovement2.isBlockingOwnJump(pieceMovement2.board.get(5)));
    }

    @Test
    public void isSettingUpJumpTest(){
        assertFalse(pieceMovement2.isSettingUpOwnJump(pieceMovement2.board.get(2)));
    }

    @Test
    public void isLeavingOthersForJumpTest(){
        assertTrue(pieceMovement2.isLeavingOthersForJump(pieceMovement2.board.get(3)));
    }

    @Test
    public void isLeavingOthersForJumpTestTwo(){
        assertFalse(pieceMovement2.isLeavingOthersForJump(pieceMovement2.board.get(5)));
    }
    @Test
    public void
}































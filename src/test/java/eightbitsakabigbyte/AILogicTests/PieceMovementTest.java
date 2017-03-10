package eightbitsakabigbyte.AILogicTests;

import eightbitsakabigbyte.Entity.GamePiece;
import org.junit.Before;

import java.util.ArrayList;

public class PieceMovementTest {
    ArrayList<GamePiece> gamePieces;

    @Before
    public void setUp() {
        gamePieces = new ArrayList<>();
        gamePieces.add(new GamePiece(false, 1,3, 3));
        gamePieces.add(new GamePiece(true, 2, 4, 4));
        gamePieces.add(new GamePiece(false, 14, 5, 3));
        gamePieces.add(new GamePiece(true,15,4,3));


    }
}
package eightbitsakabigbyte.EntityTest;

import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by anthonypajerowski on 3/10/17.
 */
public class GamePiecesTest {
    GamePieces gamePieces;

    @Before
    public void setup(){
        gamePieces = new GamePieces();
    }

    @Test
    public void gamePiecesTest(){
        String expected = "";
        String actual = gamePieces.toString();
        assertEquals(expected,actual);
    }
}

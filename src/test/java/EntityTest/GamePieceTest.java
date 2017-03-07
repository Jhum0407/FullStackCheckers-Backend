package EntityTest;

import eightbitsakabigbyte.Entity.GamePiece;
import org.junit.Before;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GamePieceTest {
    GamePiece gamePiece;

    @Before
    public void setUp(){
        gamePiece = new GamePiece("red");
    }
}

package eightbitsakabigbyte.ServiceTest;

import eightbitsakabigbyte.Service.GameService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by anthonypajerowski on 3/10/17.
 */
public class GameServiceTest {
    GameService gameService;

    @Before
    public void setup() {
        gameService = new GameService();
    }

    @Test
    public void boardInitializationTest() {
        String expected = "1 0 1 false\n" +
                "2 0 3 false\n" +
                "3 0 5 false\n" +
                "4 0 7 false\n" +
                "5 1 0 false\n" +
                "6 1 2 false\n" +
                "7 1 4 false\n" +
                "8 1 6 false\n" +
                "9 2 1 false\n" +
                "10 2 3 false\n" +
                "11 2 5 false\n" +
                "12 2 7 false\n" +
                "13 5 0 false\n" +
                "14 5 2 false\n" +
                "15 5 4 false\n" +
                "16 5 6 false\n" +
                "17 6 1 false\n" +
                "18 6 3 false\n" +
                "19 6 5 false\n" +
                "20 6 7 false\n" +
                "21 7 0 false\n" +
                "22 7 2 false\n" +
                "23 7 4 false\n" +
                "24 7 6 false\n";
        String actual = gameService.toString();
        assertEquals(expected,actual);
    }
}

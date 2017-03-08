package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameBoard;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */

@RestController
@RequestMapping("/board")
public class GameController {

    @RequestMapping(method = RequestMethod.GET)
    public GameBoard getAllPieces(){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGameBoard(@RequestBody GameBoard board){

    }

}

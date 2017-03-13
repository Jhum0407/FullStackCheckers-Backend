package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eightbitsakabigbyte.Entity.MoveRequest;
import org.springframework.http.MediaType;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class GameController {

    @Autowired
    private GameService gameService;


    //Get the current board
    @RequestMapping(method = RequestMethod.GET)
    public GameService getAllPieces(){
        return gameService;
    }

    //Return
    @RequestMapping(value = "/move", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean getMoveRequest(@RequestBody MoveRequest request) {
        return true;
    }
}
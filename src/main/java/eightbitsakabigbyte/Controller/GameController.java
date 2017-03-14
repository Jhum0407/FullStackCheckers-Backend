package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameLogic;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
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

    //Get the requested board/move from the human player and return true if valid
    @RequestMapping(value = "/moverequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequestedMove(@RequestBody MoveRequest request){
        //send note to GameLogic to see if move is legal (if not return board/pieces to front-end) 
        //in Service, if move is legal, pass move and pieces to AI
        GameLogic gameLogic = new GameLogic();
        if(gameLogic.isLegalMove(request)){
            return true;
        } else
            return false;
    }

    //Return
    @RequestMapping(value = "/updatedboard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GamePieces getMoveRequest(@RequestBody MoveRequest request) {
        //receive AI's move and updated board from Service
        //return updated pieces back to front-end
        return null;
    }
}
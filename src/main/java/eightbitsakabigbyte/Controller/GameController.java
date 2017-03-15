package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.AILogic.AIController;
import eightbitsakabigbyte.Entity.GameLogic;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import eightbitsakabigbyte.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eightbitsakabigbyte.Entity.MoveRequest;
import org.springframework.http.MediaType;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class GameController {

    @Autowired
    private GameService gameService;
    GamePieces movedPieces = new GamePieces();
    //Get the changed board that has a move made

    @RequestMapping(method = RequestMethod.GET)
    public GameService getAllPieces(){
        //pieces.createGamePieces();
        return gameService;
    }

    //Get a fake board, change a piece, return new board
    public GamePieces getAChangedBoard(GamePieces gamePieces){
        gamePieces.createGamePieces();
        gamePieces.getPiece(14).setRow(4);
        gamePieces.getPiece(14).setColumn(1);
        movedPieces=gamePieces;
        return movedPieces;
    }


    //Get the requested board/move from the human player and return true if valid
//    @RequestMapping(value = "/moverequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public GamePieces getRequestedMove(@RequestBody ArrayList<GamePiece> gamePiece){
//        //send note to GameLogic to see if move is legal (if not return board/pieces to front-end) 
//        //in Service, if move is legal, pass move and pieces to AI
//        GameLogic gameLogic = new GameLogic();
//
//        if(gameLogic.isLegalMove(request)){
//            AIController aiController = new AIController();
//            aiController.decideMove(gamePiece);
//            return getAllPieces().gamePieces; //return an updated board
//        } else
//            return getAllPieces().gamePieces; //return the original board
//    }

    //Return
    @RequestMapping(value = "/returnedboard", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GamePieces getMoveRequest() {
        //receive AI's move and updated board from Service
        //return updated pieces back to front-end
        GameLogic gameLogic = new GameLogic();
        return gameLogic.returnedBoard();
    }
}
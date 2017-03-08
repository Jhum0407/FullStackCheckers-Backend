package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GameService gameService;
    JsonConverter jsonConverter = new JsonConverter();
    GameBoard board = new GameBoard();
    GameBoard mvpBoard = new GameBoard();
    GamePiece gamePiece = new GamePiece("emptyPiece");

    //Get a current state of the game board
    @RequestMapping(method = RequestMethod.POST)
    public String getAllPieces(){
        return jsonConverter.convertBoardToJson(board);
    }

    @RequestMapping(value = "/mvp", method = RequestMethod.POST)
    public String getMvpBoard(){
        mvpBoard = gameService.getGameBoardMVP(gamePiece);
        return jsonConverter.convertBoardToJson(mvpBoard);
    }

    //Give back an updated state of the game board
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGameBoard(@RequestBody GameBoard board){

    }

}

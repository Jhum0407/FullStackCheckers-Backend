package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eightbitsakabigbyte.Service.MoveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */

@RestController
@RequestMapping("/board")
public class GameController {

    @Autowired
    private GameService gameService = new GameService();
    JsonConverter jsonConverter = new JsonConverter();
    private GameBoard board = new GameBoard();
    GameBoard mvpBoard = new GameBoard();
    GamePiece gamePiece = new GamePiece("emptyPiece");
    private GameToJSON json = new GameToJSON();

    //Get a current state of the game board
//    @RequestMapping(method = RequestMethod.POST)
//    public String getAllPieces(){
//        return jsonConverter.convertBoardToJson(board);
//    }

    //Post the mvp board with one checker in position [0][1]
    @RequestMapping(method = RequestMethod.POST)
    public String sendGameBoard(){
        mvpBoard = gameService.MVPboard();
        System.out.println(board.toString());
        return jsonConverter.convertBoardToJson(mvpBoard);
    }

    //Give back an updated state of the game board
    @RequestMapping(value = "/move", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean getMoveRequest(@RequestBody MoveRequest request){
        System.out.println(request.toString());
        return true;
    }
}

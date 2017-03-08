package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
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
    private GameBoard board = new GameBoard();
    private GameToJSON json = new GameToJSON();

//    @RequestMapping(method = RequestMethod.GET)
//    public GamePiece[][] getAllPieces(){
//        return board.gameBoard;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String sendGameBoard(){
        System.out.println(board.toString());
        return json.convertBoardToJson(board);
    }

//    @RequestMapping(value = "/mvp", method = RequestMethod.POST)
//    public String sendMVPGameBoard() {
//        return json.convertBoardToJson(gameService);
//    }

    @RequestMapping(value = "/move", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean getMoveRequest(@RequestBody MoveRequest request){
        System.out.println(request.toString());
        return true;
    }
}

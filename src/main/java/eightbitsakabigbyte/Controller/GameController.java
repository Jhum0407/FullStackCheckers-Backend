package eightbitsakabigbyte.Controller;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eightbitsakabigbyte.Entity.MoveRequest;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/board")
public class GameController {

    @Autowired
    private GameService gameService;
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
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public GamePiece[][] sendGameBoard(){
        mvpBoard = gameService.MVPboard();
        System.out.println(board.toString());
        return board.getGameBoard();
//       return jsonConverter.convertBoardToJson(mvpBoard);
    }

//    @RequestMapping(value = "/movestatus", method = RequestMethod.POST)
//    public boolean isLegal(@RequestBody Boolean boolan){
//
//    }

    //Give back an updated state of the game board
    @CrossOrigin
    @RequestMapping(value = "/move", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean getMoveRequest(@RequestBody MoveRequest request){
        System.out.println(request.toString());
//        gameService.movePiece();
        return true;
    }
}

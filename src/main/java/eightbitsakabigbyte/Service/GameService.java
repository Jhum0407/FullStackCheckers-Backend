package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.springframework.stereotype.Service;

/**
 * Created by anthonypajerowski on 3/8/17.
 */

@Service("gameService")
public class GameService {

    private GameBoard board;
    private GamePiece emptyPiece;
    {
        emptyPiece = new GamePiece("empty");
        emptyPiece.setIdentifier(-1);
    }

    //Instantiate one piece for the MVP
    public GameBoard MVPboard(){
        for (int row = 0; row < board.getGameBoard().length; row++ ) {
            for (int column = 0; column < board.getGameBoard().length; column++) {
                board.getGameBoard()[row][column] = emptyPiece;
            }
        }
        board.getGameBoard()[0][1] = new GamePiece("black");
        return board;
    }

    //Create a method to redraw the board once moves are made
    public GameBoard redrawGameBoard(MoveRequest request){


        return null;
    }

//    public void getMoveRequest()
}

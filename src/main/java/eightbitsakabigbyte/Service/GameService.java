package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.springframework.stereotype.Service;

/**
 * Created by gillianreynolds-titko on 3/8/17.
 */

@Service("gameService")
public class GameService {

    private GameBoard gameBoard = new GameBoard();
    private GamePiece emptyGamePiece = new GamePiece("empty");


    //Instantiate one piece at [0][1] (upper left corner) for the MVP
    public GameBoard getGameBoardMVP(GamePiece gamePiece){
        for (int row = 0; row < gameBoard.getGameBoard().length; row++ ) {
            for (int column = 0; column < gameBoard.getGameBoard().length; column++) {
                gameBoard.getGameBoard()[row][column] = emptyGamePiece;
                emptyGamePiece.setIdentifier(-1);
            }
        }
        gameBoard.getGameBoard()[0][1] = gamePiece;
        gamePiece.setColor("black");
        gamePiece.setIdentifier(1);
        return gameBoard;
    }

    //Create a method to redraw the board once moves are made

    public GameBoard redrawGameBoard(GamePiece gamePiece, int[][] moveFrom, int[][] moveTo){

        return null;
    }

    public GameBoard redrawGameBoard(MoveRequest request){


        return null;
    }

//    public void getMoveRequest()
}

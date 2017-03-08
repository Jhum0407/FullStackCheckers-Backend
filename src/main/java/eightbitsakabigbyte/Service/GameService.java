package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.springframework.stereotype.Service;

/**
 * Created by gillianreynolds-titko on 3/8/17.
 */

@Service
public class GameService {

    private GameBoard board = new GameBoard();
    private GamePiece gamePiece = new GamePiece("emptyPiece");

    //Instantiate one piece for the MVP
    public GameBoard getGameBoardMVP(GamePiece gamePiece){
        for (int row = 0; row < board.gameBoard.length; row++ ) {
            for (int column = 0; column < board.gameBoard.length; column++) {
                board.gameBoard[row][column] = gamePiece;
            }
        }
        board.gameBoard[0][1] = new GamePiece("blackColor");
//        gamePiece.setColor("blackColor");
//        gamePiece.setIdentifier(1);
//        board.gameBoard[0][1] = gamePiece;
        return board;
    }

    //Create a method to redraw the board once moves are made
    public GameBoard redrawGameBoard(GamePiece gamePiece, int[][] moveFrom, int[][] moveTo){

        return null;
    }
}

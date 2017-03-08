package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import org.springframework.stereotype.Service;

/**
 * Created by anthonypajerowski on 3/8/17.
 */

@Service("gameService")
public class GameService {

    private GameBoard board = new GameBoard();
    private GamePiece emptyPiece;
    private GamePiece replacePiece;
    private MoveRequest move = new MoveRequest();
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

    public GameBoard redrawGameBoard() {
        return null;
    }


    //Create a method to redraw the board once moves are made
    public GameBoard movePiece(MoveRequest request) {

        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard().length; j++) {
                if (board.getGameBoard()[i][j].getIdentifier() == request.getId()){
                    board.getGameBoard()[i][j] = emptyPiece;
                }
                if (request.getId() < 13) {
                    replacePiece = new GamePiece("red");
                    replacePiece.setIdentifier(request.getId());
                    board.getGameBoard()[request.getRow()][request.getColumn()] = replacePiece;
                } else replacePiece = new GamePiece("black");
                replacePiece.setIdentifier(request.getId());
                board.getGameBoard()[request.getRow()][request.getColumn()] = replacePiece;
            }
        }
        return board;
    }

    public int removePiece() {
        return -1;
    }

    public boolean legalMove() {
        return true;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public GamePiece getEmptyPiece() {
        return emptyPiece;
    }

    public void setEmptyPiece(GamePiece emptyPiece) {
        this.emptyPiece = emptyPiece;
    }

    public MoveRequest getMove() {
        return move;
    }

    public void setMove(MoveRequest move) {
        this.move = move;
    }
}

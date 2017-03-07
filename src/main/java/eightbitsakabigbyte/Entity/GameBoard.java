package eightbitsakabigbyte.Entity;

import sun.plugin2.message.GetAppletMessage;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GameBoard {

    public GamePiece[][] gameBoard = new GamePiece[8][8];

    GamePiece redPiece = new GamePiece("red");
    GamePiece blackPiece = new GamePiece("black");

    //Instantiate a starting board
    public GameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard.length; column++) {
                if (row % 2 == 0 && row < 3) {
                    if (column % 2 != 0) {
                        gameBoard[row][column] = redPiece;
                    } else gameBoard[row][column] = null;
                }
                if (row > 4) {
                    if (column % 2 == 0) {
                        gameBoard[row][column] = blackPiece;
                    } else gameBoard[row][column] = null;
                }
            }
        }
    }

    //Instantiate one piece for the MVP
    public GameBoard(GamePiece gamePiece){
        GamePiece firstPiece = gameBoard[0][1];
    }

    //Create a method to redraw the board once moves are made
    public void redrawGameBoard(){

    }

}

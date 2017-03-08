package eightbitsakabigbyte.Entity;

import sun.plugin2.message.GetAppletMessage;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GameBoard {

    public GamePiece[][] gameBoard = new GamePiece[8][8];

    GamePiece redPiece = new GamePiece("red");
    GamePiece blackPiece = new GamePiece("black");
    GamePiece emptyPiece = new GamePiece("empty");

    //Instantiate a starting board
    public GameBoard() {
        for(int row = 0; row < 3; row++){
            for(int column=0; column<gameBoard.length; column++){
                if(column % 2 != 0 && row %2 == 0){
                    gameBoard[row][column] = redPiece;
                } if(row == 1 && column %2 == 0){
                    gameBoard[row][column] = redPiece;
                }
            }
        }

        for(int row = 5; row < gameBoard.length; row++){
            for(int column=0; column<gameBoard.length; column++){
                if(column % 2 == 0 && row %2 != 0){
                    gameBoard[row][column] = blackPiece;
                } if(row == 6 && column %2 !=0){
                    gameBoard[row][column] = blackPiece;
                }
            }
        }

        for(int row = 0; row < gameBoard.length; row++){
           for(int column = 0; column < gameBoard.length; column++){
               if(gameBoard[row][column] == null){
                   gameBoard[row][column] = emptyPiece;
               }
           }
        }
    }

    //Instantiate one piece for the MVP
    public GameBoard(GamePiece gamePiece){
        for (int row = 0; row < gameBoard.length; row++ ) {
            for (int column = 0; column < gameBoard.length; column++) {
                gameBoard[row][column] = emptyPiece;
            }
        }
        gameBoard[0][1] = blackPiece;
    }

    //Create a method to redraw the board once moves are made
    public GameBoard redrawGameBoard(){
        return null;
    }

}


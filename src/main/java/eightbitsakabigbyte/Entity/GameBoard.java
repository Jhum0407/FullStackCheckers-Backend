package eightbitsakabigbyte.Entity;

import sun.plugin2.message.GetAppletMessage;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GameBoard {

    public GamePiece[][] gameBoard = new GamePiece[8][8];

    GamePiece redPiece;
    GamePiece blackPiece = new GamePiece("black");
    GamePiece emptyPiece = new GamePiece("empty");
    int counter = 1;

    //Instantiate a starting board
    public GameBoard() {
        for(int row = 0; row < 3; row++){
            for(int column=0; column<gameBoard.length; column++){
                if(column % 2 != 0 && row %2 == 0){
                    gameBoard[row][column] = new GamePiece("red");
                    gameBoard[row][column].setIdentifier(counter);
                    counter++;
                } if(row == 1 && column %2 == 0){
                    gameBoard[row][column] = new GamePiece("red");
                    gameBoard[row][column].setIdentifier(counter);
                    counter++;
                }
            }
        }

        for(int row = 5; row < gameBoard.length; row++){
            for(int column=0; column<gameBoard.length; column++){
                if(column % 2 == 0 && row %2 != 0){
                    gameBoard[row][column] = new GamePiece("black");
                    gameBoard[row][column].setIdentifier(counter);
                    counter++;
                } if(row == 6 && column %2 !=0){
                    gameBoard[row][column] = new GamePiece("black");
                    gameBoard[row][column].setIdentifier(counter);
                    counter++;
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

}


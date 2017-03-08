package eightbitsakabigbyte.Entity;

public class GameBoard {

    private int id;
    private String player;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    private GamePiece[][] gameBoard = new GamePiece[8][8];

    GamePiece emptyPiece = new GamePiece("empty");
    {
        emptyPiece.setIdentifier(-1);
    }
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


    public GamePiece[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GamePiece[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String toString() {
        String visualize = "";
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                visualize += gameBoard[i][j].getColor() + "  " +  gameBoard[i][j].getIdentifier() + "  " + gameBoard[i][j].getIsKing() + "\n";
            }
        }
        return visualize;
    }

}


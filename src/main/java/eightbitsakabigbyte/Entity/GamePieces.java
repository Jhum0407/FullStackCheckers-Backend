package eightbitsakabigbyte.Entity;

import java.util.ArrayList;

public class GamePieces {
    private ArrayList<GamePiece> currentPieces = new ArrayList<GamePiece>();
    private int pieceCounter = 1;

    public GamePieces(){
        createGamePieces();
    }

    private void createGamePieces() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 8; column++) {
                if (column % 2 != 0 && row % 2 == 0) {
                    GamePiece piece = new GamePiece(false, pieceCounter,row,column);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
                if (row == 1 && column % 2 == 0) {
                    GamePiece piece = new GamePiece(false, pieceCounter,row,column);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
            }
        }
        for (int row = 5; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (column % 2 == 0 && row % 2 != 0) {
                    GamePiece piece = new GamePiece(false, pieceCounter,row,column);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
                if (row == 6 && column % 2 != 0) {
                    GamePiece piece = new GamePiece(false, pieceCounter,row,column);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < currentPieces.size(); i++) {
            sb.append(currentPieces.get(i).getIdentifier() + " " +  currentPieces.get(i).getRow() + " "
                    + currentPieces.get(i).getColumn() + " " + currentPieces.get(i).getIsKing() + "\n");
        }
        return sb.toString();
    }
}

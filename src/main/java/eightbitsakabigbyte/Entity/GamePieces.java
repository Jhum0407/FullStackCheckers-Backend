package eightbitsakabigbyte.Entity;

import java.util.ArrayList;

/**
 * Created by anthonypajerowski on 3/10/17.
 */
public class GamePieces {
    private ArrayList<GamePiece> currentPieces = new ArrayList<GamePiece>();
    private int pieceCounter = 1;
    private int rowSize = 8;
    private int columnSize = 8;

    GamePiece gamePiece = new GamePiece();

    GamePieces() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < columnSize; column++) {
                if (column % 2 != 0 && row % 2 == 0) {
                    GamePiece piece = new GamePiece();
                    piece.setColumn(column);
                    piece.setRow(row);
                    piece.setIdentifier(pieceCounter);
                    piece.setIsKing(false);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
                if (row == 1 && column % 2 == 0) {
                    GamePiece piece = new GamePiece();
                    piece.setColumn(column);
                    piece.setRow(row);
                    piece.setIdentifier(pieceCounter);
                    piece.setIsKing(false);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
            }
        }
        for (int row = 5; row < 8; row++) {
            for (int column = 0; column < columnSize; column++) {
                if (column % 2 == 0 && row % 2 != 0) {
                    GamePiece piece = new GamePiece();
                    piece.setColumn(column);
                    piece.setRow(row);
                    piece.setIdentifier(pieceCounter);
                    piece.setIsKing(false);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
                if (row == 6 && column % 2 != 0) {
                    GamePiece piece = new GamePiece();
                    piece.setColumn(column);
                    piece.setRow(row);
                    piece.setIdentifier(pieceCounter);
                    piece.setIsKing(false);
                    currentPieces.add(piece);
                    pieceCounter++;
                }
            }
        }
    }
}

package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GamePiece;

import java.util.ArrayList;

import static eightbitsakabigbyte.AILogic.Pieces.EMPTY;

public class AIController {

    public byte highestCounter;
    public ArrayList<GamePiece> bestMovePiece = new ArrayList<>();
    public ArrayList<Integer> bestMoveRow = new ArrayList<>();
    public ArrayList<Integer> bestMoveColumn = new ArrayList<>();

    PieceMovement pm = new PieceMovement();

    public ArrayList<GamePiece> decideMove(ArrayList<GamePiece> gameBoard){
        for(int i = 0; i < gameBoard.size(); i++){
            if(gameBoard.get(i).getIdentifier() < 13){
                if(pm.checkAvailableJump(gameBoard.get(i))){
                    return gameBoard;
                }
                checkForMoves(gameBoard.get(i));
            }
        }
        makeMove(bestMovePiece.get(0), bestMoveRow.get(0), bestMoveColumn.get(0));
        return gameBoard;
    }

    public void checkForMoves(GamePiece piece){
        if(pm.checkLowerLeft(piece) == EMPTY) {
            byte value =  pm.determineValueOfMove(piece, piece.getRow() + 1, piece.getColumn() - 1);
            assignMove(piece, piece.getRow() + 1, piece.getColumn() - 1, value);
        }
        if(pm.checkLowerRight(piece) == EMPTY) {
            byte value = pm.determineValueOfMove(piece, piece.getRow() + 1, piece.getColumn() + 1);
            assignMove(piece, piece.getRow() + 1, piece.getColumn() + 1, value);
        }
        if(piece.getIsKing() == true && pm.checkUpperLeft(piece) == EMPTY){
            byte value =  pm.determineValueOfMove(piece, piece.getRow() - 1, piece.getColumn() - 1);
            assignMove(piece, piece.getRow() - 1, piece.getColumn() - 1, value);
        }
        if(piece.getIsKing() == true && pm.checkUpperRight(piece) == EMPTY){
            byte value =  pm.determineValueOfMove(piece, piece.getRow() - 1, piece.getColumn() + 1);
            assignMove(piece, piece.getRow() - 1, piece.getColumn() + 1, value);
        }
    }

    public void assignMove(GamePiece piece, int row, int column, byte moveValue){
        if(moveValue > highestCounter){
            highestCounter = moveValue;
            bestMovePiece = new ArrayList<>();
            bestMovePiece.add(piece);
            bestMoveColumn = new ArrayList<>();
            bestMoveColumn.add(column);
            bestMoveRow = new ArrayList<>();
            bestMoveRow.add(row);
        }
        if(moveValue == highestCounter){
            bestMovePiece.add(piece);
            bestMoveColumn.add(column);
            bestMoveRow.add(row);
        }
    }

    public void makeMove(GamePiece piece, int row, int column){
        if(piece.getIdentifier() > 0 && piece.getIdentifier() < 13) {
            piece.setRow(row);
            piece.setColumn(column);
        }
    }

}

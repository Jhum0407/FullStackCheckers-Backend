package eightbitsakabigbyte.Entity;


import eightbitsakabigbyte.AILogic.PieceMovement;

import static eightbitsakabigbyte.AILogic.Pieces.EMPTY;
import static eightbitsakabigbyte.AILogic.Pieces.ENEMY;
import static eightbitsakabigbyte.AILogic.Pieces.ENEMY_KING;

/**
 * Created by jeriahhumphrey on 3/8/17.
 */
public class GameLogic {
    private int changeIndex;
    PieceMovement move;

//
//    public boolean isLegalMove(GameBoard board, MoveRequest request) {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if ((board.getGameBoard()[i][j].getIdentifier() == request.getId())
//                        && (board.getGameBoard()[request.getRow()][request.getColumn()].getIdentifier() < 0)
//                        && (i - request.getRow() == 1 && (j - request.getColumn() == 1 || j - request.getColumn() == -1))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    //Get the board with the requested move and compare to the current board
    //If there is a change, return true
    public boolean comparePiecesOnBoard(GamePieces currentGamePieces, GamePieces changedGamePieces){
        int i;
        for( i =12; i<24;i++){
            if(!(currentGamePieces.getPiece(i).getColumn()==changedGamePieces.getPiece(i).getColumn())){
                changeIndex=i;
                return true;
            }
        } return false;

    }

    public boolean isOccupiedSpace( GamePieces currentPieces, GamePieces changedGamePieces){
       if(comparePiecesOnBoard(currentPieces, changedGamePieces)) {

           for (int i = 0; i < 24; i++) {
               if (currentPieces.getPiece(i).getRow() == changedGamePieces.getPiece(changeIndex).getRow() &&
                       currentPieces.getPiece(i).getColumn() == changedGamePieces.getPiece(changeIndex).getColumn()) {

                   return true;
               }
           }
       }
        return false;
    }

    public boolean isLegalMovePawn(GamePieces currentGamePieces, GamePieces changedGamePieces){
        if(!(isOccupiedSpace(currentGamePieces, changedGamePieces))) {

            if (comparePiecesOnBoard(currentGamePieces, changedGamePieces)) {

                if ((currentGamePieces.getPiece(changeIndex).getRow() - changedGamePieces.getPiece(changeIndex).getRow() == 1) &&
                        Math.abs(currentGamePieces.getPiece(changeIndex).getColumn() - changedGamePieces.getPiece(changeIndex).getColumn()) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isLegalMoveKing(GamePieces currentGamePieces, GamePieces changedGamePieces){
        if(!(isOccupiedSpace(currentGamePieces, changedGamePieces))) {

            if (comparePiecesOnBoard(currentGamePieces, changedGamePieces)) {


                if (Math.abs(currentGamePieces.getPiece(changeIndex).getRow() - changedGamePieces.getPiece(changeIndex).getRow()) == 1 &&
                        Math.abs(currentGamePieces.getPiece(changeIndex).getColumn() - changedGamePieces.getPiece(changeIndex).getColumn()) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAvailableJumpUpperLeft(GamePiece piece){
        if(move.checkUpperLeft(piece).equals(ENEMY)||move.checkUpperLeft(piece).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()-1);
            piece.setColumn(piece.getColumn()-1);
            if(move.checkUpperLeft(piece).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

    public boolean isAvailableJumpUpperRight(GamePiece piece){
        if(move.checkUpperRight(piece).equals(ENEMY)||move.checkUpperRight(piece).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()-1);
            piece.setColumn(piece.getColumn()+1);
            if(move.checkUpperRight(piece).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

    public boolean isAvailableJumpLowerLeft(GamePiece piece){
        if(move.checkLowerLeft(piece).equals(ENEMY)||move.checkLowerLeft(piece).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()+1);
            piece.setColumn(piece.getColumn()-1);
            if(move.checkLowerLeft(piece).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

    public boolean isAvailableJumpLowerRight(GamePiece piece){
        if(move.checkLowerRight(piece).equals(ENEMY)||move.checkLowerRight(piece).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()+1);
            piece.setColumn(piece.getColumn()+1);
            if(move.checkLowerRight(piece).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }






    public GamePieces returnedBoard(){
        //Get the board after the AILogic made its move.
        GamePieces gamePieces = new GamePieces();
        //Create a piece that represents a changed board
        GamePiece gamePiece = new GamePiece(true, 3, 2, 5);
        gamePieces.createGamePieces();
        //place a piece as the nth item in the Json
        gamePieces.add(1,gamePiece);
        return gamePieces;
    }

    public int getChangeIndex(){
        return changeIndex;
    }

}
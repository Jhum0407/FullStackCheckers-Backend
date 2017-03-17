package eightbitsakabigbyte.Entity;


import eightbitsakabigbyte.AILogic.PieceMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static eightbitsakabigbyte.AILogic.Pieces.*;

/**
 * Created by jeriahhumphrey on 3/8/17.
 */

@Component
public class GameLogic {

    private GamePieces gamePieces= new GamePieces();
    ArrayList <Integer> jumps = new ArrayList();

    private int changeIndex;
    PieceMovement move= new PieceMovement();

    public GamePieces getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(GamePieces gamePieces) {
        this.gamePieces = gamePieces;
    }



    {

        gamePieces.createGamePieces();
    }

    //Get the board with the requested move and compare to the current board
    //If there is a change, return true
    public boolean comparePiecesOnBoard(GamePieces currentGamePieces, GamePieces changedGamePieces){
        int i;
        for( i =12; i<currentGamePieces.size();i++){
            if(!(currentGamePieces.getPiece(i).getColumn()==changedGamePieces.getPiece(i).getColumn())){
                changeIndex=i;
                return true;
            }
        } return false;

    }

    public boolean isOccupiedSpace( GamePieces currentPieces, GamePieces changedGamePieces){
       if(comparePiecesOnBoard(currentPieces, changedGamePieces)) {

           for (int i = 0; i < currentPieces.size(); i++) {
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

    public boolean isLegalMove(GamePieces currentGamePieces, GamePieces changedGamePieces) {
            comparePiecesOnBoard(currentGamePieces, changedGamePieces);
            if (currentGamePieces.getPiece(changeIndex).getIsKing()) {
                return isLegalMoveKing(currentGamePieces, changedGamePieces);
            }
            return isLegalMovePawn(currentGamePieces, changedGamePieces);
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

    public boolean isAvailableJumpUpperLeft(GamePiece piece, GamePieces board){


        if(move.checkUpperLeft(piece,board).equals(FRIENDLY)||move.checkUpperLeft(piece, board).equals(FRIENDLY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()-1);
            piece.setColumn(piece.getColumn()-1);
            if(move.checkUpperLeft(piece,board).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

    public boolean isAvailableJumpUpperRight(GamePiece piece,GamePieces board){
        if(move.checkLowerLeft(piece,board).equals(FRIENDLY)||move.checkLowerLeft(piece,board).equals(FRIENDLY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()+1);
            piece.setColumn(piece.getColumn()-1);
            if(move.checkLowerLeft(piece,board).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

    public boolean isAvailableJumpLowerLeft(GamePiece piece, GamePieces board){
        if(move.checkLowerLeft(piece,board).equals(ENEMY)||move.checkLowerLeft(piece,board).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()+1);
            piece.setColumn(piece.getColumn()-1);
            if(move.checkLowerLeft(piece,board).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }



    public boolean isAvailableJumpLowerRight(GamePiece piece, GamePieces board){
        if(move.checkLowerRight(piece,board).equals(ENEMY)||move.checkLowerRight(piece,board).equals(ENEMY_KING)){
            int holdRow=piece.getRow();
            int holdColumn=piece.getColumn();
            piece.setRow(piece.getRow()+1);
            piece.setColumn(piece.getColumn()+1);
            if(move.checkLowerRight(piece,board).equals(EMPTY)){
                piece.setRow(holdRow);
                piece.setColumn(holdColumn);
                return true;
            }
            piece.setRow(holdRow);
            piece.setColumn(holdColumn);

        }
        return false;
    }

//    public boolean isAvailableJump(GamePiece piece, GamePieces board, GamePieces compare) {
//        if (piece.getIsKing() == false) {
//            if (isAvailableJumpUpperLeft(piece, board)) {
//                comparePiecesOnBoard(board,compare){
//
//                }
//
//            }
//
//
//        }
//    }

    public int getChangeIndex(){
        return changeIndex;
    }

}
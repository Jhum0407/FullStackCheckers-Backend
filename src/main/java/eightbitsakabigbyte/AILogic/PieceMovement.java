package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;

import java.util.ArrayList;

import static eightbitsakabigbyte.AILogic.Pieces.*;

public class PieceMovement {
    public GameService gameService = new GameService();
    public byte highestCounter;
    public ArrayList<GamePiece> bestMoveStart = new ArrayList<>();
    public ArrayList<GamePiece> bestMoveEnd = new ArrayList<>();
    public ArrayList<GamePiece> board = new ArrayList<>();

    protected final byte multiJump = 4;
    protected final byte singleJump = 3;
    protected final byte defendFromImmediateJump = 2;
    protected final byte avoidImmediateJump = 2;
    protected final byte movingBackRow = -1;
    protected final byte movingIntoSpaceWillBeJumped = -2;
    protected final byte avoidExistingMultiJump = 2;
    protected final byte movingIntoSpaceWillBeMultiJumped = 2;
    protected final byte leavingOthersToBeJumped = -2;
    protected final byte settingUpOwnJump = 1;
    protected final byte gettingAKing = 5;
    protected final byte blockOwnJump = -2;
    protected final byte leavingKingToBeJumped = -1;
    protected final byte twoInARow = 1;
    protected final byte normalPieceBonus = 2;


    public GamePiece moveChoice(){
        return null;
    }

    public void makeMove(GamePiece piece, int row, int column){
        if(piece.getIdentifier() > 0 && piece.getIdentifier() < 13) {
            piece.setRow(row);
            piece.setColumn(column);
        }
    }


    public void removePiece(GamePiece piece){
        for(int i = 0; i < board.size(); i++) {
            if(board.get(i).getIdentifier() == piece.getIdentifier()) {
                board.remove(i);
            }
        }

    }

    public Pieces checkSpace(GamePiece space){
        if(space.getIdentifier() > 12){
            if(space.getIsKing() == true){
                return ENEMY_KING;
            }
            return ENEMY;
        } else if(space.getIdentifier() > 0){
            if(space.getIsKing() == true){
                return FRIENDLY_KING;
            }
            return FRIENDLY;
        } else {
            return EMPTY;
        }
    }


    public Pieces checkUpperLeft(GamePiece piece){
        if(piece.getRow() != 0 && piece.getColumn() != 0) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == piece.getRow() - 1 && temp.getColumn() == piece.getColumn() - 1){
                    return checkSpace(temp);
                }
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }

    public Pieces checkUpperRight(GamePiece piece){
        if(piece.getRow() != 0 && piece.getColumn() != 7) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == piece.getRow() - 1 && temp.getColumn() == piece.getColumn() + 1){
                    return checkSpace(temp);
                }
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }

    public Pieces checkLowerLeft(GamePiece piece){
        if(piece.getRow() != 7 && piece.getColumn() != 0) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (piece.getRow() + 1) && temp.getColumn() == (piece.getColumn() - 1)){
                    return checkSpace(temp);
                }
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }

    public Pieces checkLowerRight(GamePiece piece){
        if(piece.getRow() != 7 && piece.getColumn() != 7) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (piece.getRow() + 1) && temp.getColumn() == (piece.getColumn() + 1)){
                    return checkSpace(temp);
                }
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }


    public void checkAvailableJump(GamePiece piece){
        if(checkLowerRight(piece) == ENEMY || checkLowerLeft(piece) == ENEMY
                || checkLowerRight(piece) == ENEMY_KING || checkLowerLeft(piece) == ENEMY_KING){
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (piece.getRow() + 1)
                        && temp.getColumn() == (piece.getColumn() - 1)
                        && checkLowerLeft(temp) == EMPTY){
                    makeMove(piece, piece.getRow() + 2, piece.getColumn() - 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                }
                if (temp.getRow() == piece.getRow() + 1
                        && temp.getColumn() == piece.getColumn() + 1
                        && checkLowerRight(temp) == EMPTY) {
                    makeMove(piece, piece.getRow() + 2, piece.getColumn() + 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                }
            }
        }
    }

    public void checkForMoves(GamePiece piece){
        if(checkLowerLeft(piece) == EMPTY) {
            determineValueOfMove(piece, piece.getRow() + 1, piece.getColumn() - 1);
        } else if(checkLowerRight(piece) == EMPTY) {
            determineValueOfMove(piece, piece.getRow() + 1, piece.getColumn() + 1);
        } else {

        }
    }

    public byte determineValueOfMove(GamePiece piece, int row, int column){
        byte moveCounter = 0;
        if(isAvoidJump(piece)){moveCounter += avoidImmediateJump;}
        if(isMovingIntoJumpOnNextTurn(piece, row, column)){
            moveCounter += movingIntoSpaceWillBeJumped;
            if(isMovingIntoMultiJumpOnNextTurn(piece, row, column)){
                moveCounter += movingIntoSpaceWillBeMultiJumped;
            }
        }



    }

    public boolean isAvoidJump(GamePiece piece){
        if((checkLowerLeft(piece) == ENEMY || checkLowerLeft(piece) == ENEMY_KING) &&  checkUpperRight(piece) == EMPTY){
            return true;
        }
        if((checkLowerRight(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) &&  checkUpperLeft(piece) == EMPTY) {
            return true;
        }
        if(checkUpperLeft(piece) == ENEMY_KING && checkLowerRight(piece) == EMPTY){
            return true;
        }
        if(checkUpperRight(piece) == ENEMY_KING && checkLowerLeft(piece) == EMPTY){
            return true;
        }
        return false;
    }

    public boolean isMovingIntoJumpOnNextTurn(GamePiece piece, int row, int column){
        int originalRow = piece.getRow();
        int originalColumn = piece.getColumn();
        makeMove(piece, row, column);
        if(isAvoidJump(piece)){
            makeMove(piece, originalRow, originalColumn);
            return true;
        }
        makeMove(piece, originalRow, originalColumn);
        return false;
    }

    public boolean isMovingIntoMultiJumpOnNextTurn(GamePiece piece, int row, int column){
        
    }


    public void isTwoInARow(GamePiece piece, int row, int column){}

    public void isMovingBackRow(GamePiece piece){}

    public void isDefendFromImmediateJump(GamePiece piece, int row, int column){}

    public void isLeavingOthersForJump(GamePiece piece, int row, int column){}

    public void isSettingUpOwnJump(GamePiece piece, int row, int column){}

    public void isGettingKing(GamePiece piece, int row, int column){}

    public void isBlockingOwnJump(GamePiece piece, int row, int column){}


}


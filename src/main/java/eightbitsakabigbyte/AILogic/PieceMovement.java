package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;

import java.util.ArrayList;

import static eightbitsakabigbyte.AILogic.Pieces.*;

public class PieceMovement {
    public GameService gameService = new GameService();
    public byte moveCounter;
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
    protected final byte avoidMovingIntoMultiJump = 2;
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

    protected boolean checkForMoves(GamePiece piece){
        if(checkLowerLeft(piece) == EMPTY || checkLowerRight(piece) == EMPTY){
            return true;
        } else {
            return false;
        }
    }

    protected void determineValueOfMove(GamePiece piece, int moveRow, int moveColumn){}

//not right, need to see too in morning
    protected void isAvoidJump(GamePiece piece, int row, int column){
        if (checkLowerLeft(piece) == ENEMY){
            moveCounter += avoidImmediateJump;
        } else if(checkLowerRight(piece) == ENEMY) {
            moveCounter += avoidImmediateJump;
        } else if(checkUpperLeft(piece) == ENEMY_KING) {
            if(checkLowerLeft(piece) == EMPTY || checkLowerRight(piece) == EMPTY){
                moveCounter += avoidImmediateJump;
            }
        }else if(checkUpperRight(piece) == ENEMY_KING){
            if(checkLowerLeft(piece) == EMPTY || checkLowerRight(piece) == EMPTY){
                moveCounter += avoidImmediateJump;
            }
        }
    }

    protected void isMultiJumpOnNextTurn(GamePiece piece, int row, int column){

    }

    public GamePiece makeMove(GamePiece piece, GamePiece space, int row, int column){

        return null;
    }

    protected void isJumpOnNextTurn(GamePiece piece, int row, int column){

    }

    protected void isTwoInARow(GamePiece piece, GamePiece move){}

    protected void isMovingBackRow(GamePiece piece, GamePiece move){}

    protected void isDefendFromImmediateJump(GamePiece piece, GamePiece move){}

    protected void isLeavingOthersForJump(GamePiece piece, GamePiece move){}

    protected void isSettingUpOwnJump(GamePiece piece, GamePiece move){}

    protected void isGettingKing(GamePiece piece, GamePiece move){}

    protected void isBlockingOwnJump(GamePiece piece, GamePiece move){}


}


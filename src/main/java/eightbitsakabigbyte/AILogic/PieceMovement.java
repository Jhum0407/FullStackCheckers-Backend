package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GamePiece;

import java.util.ArrayList;

import static eightbitsakabigbyte.AILogic.Pieces.*;

public class PieceMovement {
    AIController aiController = new AIController();
    //public GameService gameService = new GameService();
    //will be instance of GamePieces
    public ArrayList<GamePiece> board = new ArrayList<>();

    protected final byte multiJump = 4;
    protected final byte singleJump = 3;
    protected final byte defendFromImmediateJump = 2;
    protected final byte avoidImmediateJump = 2;
    protected final byte movingBackRow = -1;
    protected final byte movingIntoSpaceWillBeJumped = -2;
    protected final byte movingIntoSpaceWillBeMultiJumped = 2;
    protected final byte leavingOthersToBeJumped = -2;
    protected final byte settingUpOwnJump = 1;
    protected final byte gettingAKing = 5;
    protected final byte blockOwnJump = -2;
    protected final byte twoInARow = 1;
    protected final byte normalPieceBonus = 2;


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
    public GamePiece findPiece(int row, int column){
        for(int i = 0; i < board.size(); i++){
            if(board.get(i).getRow() == row && board.get(i).getColumn() == column){
                return board.get(i);
            }
        }
        return null;
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
    public Pieces checkUpperLeft(int row, int column){
        if(row != 0 && column != 0) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == row - 1 && temp.getColumn() == column - 1){
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
    public Pieces checkUpperRight(int row, int column){
        if(row != 0 && column != 7) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == row - 1 && temp.getColumn() == column + 1){
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
    public Pieces checkLowerLeft(int row, int column){
        if(row != 7 && column != 0) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (row + 1) && temp.getColumn() == (column - 1)){
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
    public Pieces checkLowerRight(int row, int column){
        if(row != 7 && column != 7) {
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (row + 1) && temp.getColumn() == (column + 1)){
                    return checkSpace(temp);
                }
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }

//    public Pieces checkPieceInSpace(GamePiece piece){
//        for(int i = 0; i < board.size(); i++) {
//            GamePiece temp = board.get(i);
//            if (temp.getRow() == (piece.getRow()) && temp.getColumn() == (piece.getColumn())) {
//                return checkSpace(temp);
//            }
//        }
//            return EMPTY;
//    }
//    public Pieces checkPieceInSpace(int row, int column){
//        for(int i = 0; i < board.size(); i++) {
//            GamePiece temp = board.get(i);
//            if (temp.getRow() == row && temp.getColumn() == column) {
//                return checkSpace(temp);
//            }
//        }
//        return EMPTY;
//    }

    public boolean checkAvailableJump(GamePiece piece){
        if(checkLowerRight(piece) == ENEMY || checkLowerLeft(piece) == ENEMY
                || checkLowerRight(piece) == ENEMY_KING || checkLowerLeft(piece) == ENEMY_KING){
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (piece.getRow() + 1)
                        && temp.getColumn() == (piece.getColumn() - 1)
                        && checkLowerLeft(temp) == EMPTY){
                    aiController.makeMove(piece, piece.getRow() + 2, piece.getColumn() - 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                    return true;
                }
                if (temp.getRow() == piece.getRow() + 1
                        && temp.getColumn() == piece.getColumn() + 1
                        && checkLowerRight(temp) == EMPTY) {
                    aiController.makeMove(piece, piece.getRow() + 2, piece.getColumn() + 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                    return true;
                }
            }
        }
        if(piece.getIsKing() == true && checkUpperRight(piece) == ENEMY || checkUpperLeft(piece) == ENEMY
                || checkUpperRight(piece) == ENEMY_KING || checkUpperLeft(piece) == ENEMY_KING){
            for(int i = 0; i < board.size(); i++){
                GamePiece temp = board.get(i);
                if(temp.getRow() == (piece.getRow() - 1)
                        && temp.getColumn() == (piece.getColumn() - 1)
                        && checkUpperLeft(temp) == EMPTY){
                    aiController.makeMove(piece, piece.getRow() - 2, piece.getColumn() - 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                    return true;
                }
                if (temp.getRow() == piece.getRow() - 1
                        && temp.getColumn() == piece.getColumn() + 1
                        && checkUpperRight(temp) == EMPTY) {
                    aiController.makeMove(piece, piece.getRow() - 2, piece.getColumn() + 2);
                    removePiece(temp);
                    checkAvailableJump(piece);
                    return true;
                }
            }
        }
        return false;
    }

    public byte determineValueOfMove(GamePiece piece, int row, int column){
        byte moveCounter = 0;
        if(isAvoidJump(piece)){moveCounter += avoidImmediateJump;}
        if(isMovingBackRow(piece)){moveCounter += movingBackRow;}
        if (isLeavingOthersForJump(piece)) {moveCounter += leavingOthersToBeJumped;}
        int originalRow = piece.getRow();
        int originalColumn = piece.getColumn();
        aiController.makeMove(piece, row, column);
        if(isGettingKing(piece)){moveCounter += gettingAKing;}
        if(isMovingIntoJumpOnNextTurn(piece)){
            moveCounter += movingIntoSpaceWillBeJumped;
            if(isMovingIntoMultiJumpOnNextTurn(piece)){
                moveCounter += movingIntoSpaceWillBeMultiJumped;
            }
        }
        if(isTwoInARow(piece)){
            moveCounter += twoInARow;
            if(isDefendFromImmediateJump(piece)){
                moveCounter += defendFromImmediateJump;
            }
        }
        if(isSettingUpOwnJump(piece)){moveCounter += settingUpOwnJump;}
        if(isBlockingOwnJump(piece)){moveCounter += blockOwnJump;}
        if(piece.getIsKing() == false){moveCounter += normalPieceBonus;}

        aiController.makeMove(piece, originalRow, originalColumn);
        return moveCounter;

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

    public boolean isMovingBackRow(GamePiece piece){
        return piece.getRow() == 0;
    }

    public boolean isLeavingOthersForJump(GamePiece piece){
        if(isTwoInARow(piece)) {
            if (checkLowerRight(piece) == FRIENDLY_KING || checkLowerRight(piece) == FRIENDLY) {
                if (isAvoidJump(findPiece(piece.getRow() + 1, piece.getColumn() + 1))) {
                    return true;
                }
                if (checkLowerLeft(piece) == FRIENDLY_KING || checkLowerLeft(piece) == FRIENDLY) {
                    if (isAvoidJump(findPiece(piece.getRow() + 1, piece.getColumn() - 1))) {
                        return true;
                    }
                }
                if (checkUpperLeft(piece) == FRIENDLY_KING || checkUpperLeft(piece) == FRIENDLY) {
                    if (isAvoidJump(findPiece(piece.getRow() - 1, piece.getColumn() - 1))) {
                        return true;
                    }
                }
                if (checkUpperRight(piece) == FRIENDLY_KING || checkUpperRight(piece) == FRIENDLY) {
                    if (isAvoidJump(findPiece(piece.getRow() - 1, piece.getColumn() + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public boolean isMovingIntoJumpOnNextTurn(GamePiece piece){
        if(isAvoidJump(piece)){
            return true;
        }
        return false;
    }

    public boolean isMovingIntoMultiJumpOnNextTurn(GamePiece piece){
        if((checkLowerLeft(piece) == ENEMY || checkLowerLeft(piece) == ENEMY_KING) && checkUpperRight(piece) == EMPTY){
            if((checkUpperRight(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                    checkUpperRight(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY) &&
                    checkUpperRight(piece.getRow() - 2, piece.getColumn() + 2) == EMPTY){
                return true;
            }
            if((checkUpperLeft(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                    checkUpperLeft(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY) &&
                    checkUpperLeft(piece.getRow() - 3, piece.getColumn() - 1) == EMPTY){
                return true;
            }
            if(checkLowerLeft(piece) == ENEMY_KING &&
                    (checkLowerRight(piece.getRow(), piece.getColumn() + 2) == FRIENDLY_KING ||
                    checkLowerRight(piece.getRow(), piece.getColumn() + 2) == FRIENDLY) &&
                    checkLowerRight(piece.getRow() + 1, piece.getColumn() + 3) == EMPTY){
                return true;
            }
        }
        if((checkLowerRight(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) && checkUpperLeft(piece) == EMPTY){
            if((checkUpperRight(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkUpperRight(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkUpperRight(piece.getRow() - 3, piece.getColumn() + 1) == EMPTY){
                return true;
            }
            if((checkUpperLeft(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkUpperLeft(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkUpperLeft(piece.getRow() - 3, piece.getColumn() - 3) == EMPTY){
                return true;
            }
            if(checkLowerRight(piece) == ENEMY_KING &&
                    (checkLowerRight(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkLowerRight(piece.getRow() - 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkLowerRight(piece.getRow(), piece.getColumn() - 2) == EMPTY){
                return true;
            }
        }
        if(checkUpperLeft(piece) == ENEMY_KING && checkLowerRight(piece) == EMPTY){
            if((checkUpperRight(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                    checkUpperRight(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY) &&
                    checkUpperRight(piece.getRow(), piece.getColumn() + 2) == EMPTY){
                return true;
            }
            if((checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                    checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY) &&
                    checkLowerRight(piece.getRow() + 2, piece.getColumn() + 2) == EMPTY){
                return true;
            }
            if((checkLowerLeft(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                    checkLowerLeft(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY) &&
                    checkLowerLeft(piece.getRow() + 2, piece.getColumn()) == EMPTY){
                return true;
            }
        }
        if(checkUpperRight(piece) == ENEMY_KING && checkLowerLeft(piece) == EMPTY){
            if((checkUpperLeft(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkUpperLeft(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkUpperLeft(piece.getRow(), piece.getColumn() - 2) == EMPTY){
                return true;
            }
            if((checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkLowerLeft(piece.getRow() - 2, piece.getColumn() - 2) == EMPTY){
                return true;
            }
            if((checkLowerRight(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY_KING ||
                    checkLowerRight(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY) &&
                    checkLowerRight(piece.getRow() + 2, piece.getColumn()) == EMPTY){
                return true;
            }
        }
        return false;
    }


    public boolean isTwoInARow(GamePiece piece){
        if(checkLowerLeft(piece) == FRIENDLY || checkLowerLeft(piece) == FRIENDLY_KING ||
                checkLowerRight(piece) == FRIENDLY || checkLowerRight(piece) == FRIENDLY_KING ||
                checkUpperLeft(piece) == FRIENDLY || checkUpperLeft(piece) == FRIENDLY_KING ||
                checkUpperRight(piece) == FRIENDLY || checkUpperRight(piece) == FRIENDLY_KING){
            return true;
        }
        return false;
    }

    public boolean isDefendFromImmediateJump(GamePiece piece){
        if((checkLowerLeft(piece) == FRIENDLY_KING || checkLowerLeft(piece) == FRIENDLY) &&
                (checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == ENEMY_KING ||
                checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == ENEMY)){
            return true;
        }
        if((checkLowerRight(piece) == FRIENDLY_KING || checkLowerRight(piece) == FRIENDLY) &&
                (checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == ENEMY_KING ||
                checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == ENEMY)){
            return true;
        }
        if((checkUpperLeft(piece) == FRIENDLY_KING || checkUpperLeft(piece) == FRIENDLY) &&
                (checkUpperLeft(piece.getRow() - 1, piece.getColumn() - 1) == ENEMY_KING ||
                checkUpperLeft(piece.getRow() - 1, piece.getColumn() - 1) == ENEMY)){
            return true;
        }
        if((checkUpperRight(piece) == FRIENDLY_KING || checkUpperRight(piece) == FRIENDLY) &&
                (checkUpperRight(piece.getRow() - 1, piece.getColumn() + 1) == ENEMY_KING ||
                checkUpperRight(piece.getRow() - 1, piece.getColumn() + 1) == ENEMY)){
            return true;
        }
        return false;
    }



    public boolean isSettingUpOwnJump(GamePiece piece){
        if(checkUpperRight(piece) == FRIENDLY || checkUpperRight(piece) == FRIENDLY_KING){
            if((checkLowerLeft(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) && isAJump(piece)){
                return true;
            }
        }
        if(checkUpperLeft(piece) == FRIENDLY || checkUpperLeft(piece) == FRIENDLY_KING){
            if((checkLowerRight(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) && isAJump(piece)){
                return true;
            }
        }
        if(piece.getIsKing() == true && (checkLowerLeft(piece) == FRIENDLY || checkLowerLeft(piece) == FRIENDLY_KING)){
            if((checkUpperRight(piece) == ENEMY || checkUpperRight(piece) == ENEMY_KING) && isAJump(piece)){
                return true;
            }
        }
        if(piece.getIsKing() == true && (checkLowerRight(piece) == FRIENDLY || checkLowerRight(piece) == FRIENDLY_KING)){
            if((checkUpperLeft(piece) == ENEMY || checkUpperLeft(piece) == ENEMY_KING) && isAJump(piece)){
                return true;
            }
        }
        return false;
    }

    public boolean isGettingKing(GamePiece piece){
        return piece.getRow() == 7;
    }

    public boolean isBlockingOwnJump(GamePiece piece){
        if((checkUpperLeft(piece) == ENEMY || checkUpperLeft(piece) == ENEMY_KING) &&
                (checkUpperLeft(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                checkUpperLeft(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY)){
            return true;
        }
        if((checkUpperRight(piece) == ENEMY || checkUpperRight(piece) == ENEMY_KING) &&
                (checkUpperRight(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY_KING ||
                checkUpperLeft(piece.getRow() - 1, piece.getColumn() + 1) == FRIENDLY)){
            return true;
        }
        if((checkLowerLeft(piece) == ENEMY || checkLowerLeft(piece) == ENEMY_KING) &&
                checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == FRIENDLY_KING){
            return true;
        }
        if((checkLowerRight(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) &&
                checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == FRIENDLY_KING){
            return true;
        }
        return false;
    }

    public boolean isAJump(GamePiece piece){
        if((checkLowerLeft(piece) == ENEMY || checkLowerLeft(piece) == ENEMY_KING) &&
                checkLowerLeft(piece.getRow() + 1, piece.getColumn() - 1) == EMPTY){
            return true;
        }
        if((checkLowerRight(piece) == ENEMY || checkLowerRight(piece) == ENEMY_KING) &&
                checkLowerRight(piece.getRow() + 1, piece.getColumn() + 1) == EMPTY){
            return true;
        }
        if(piece.getIsKing() == true && (checkUpperLeft(piece) == ENEMY || checkUpperLeft(piece) == ENEMY_KING) &&
                checkUpperLeft(piece.getRow() - 1, piece.getColumn() - 1) == EMPTY){
            return true;
        }
        if(piece.getIsKing() == true && (checkUpperRight(piece) == ENEMY || checkUpperRight(piece) == ENEMY_KING) &&
                checkLowerRight(piece.getRow() - 1, piece.getColumn() + 1) == EMPTY){
            return true;
        }
        return false;
    }


}


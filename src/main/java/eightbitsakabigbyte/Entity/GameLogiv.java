package eightbitsakabigbyte.Entity;

import eightbitsakabigbyte.AILogic.PieceMovement;

import static eightbitsakabigbyte.AILogic.Pieces.*;


public class GameLogiv {

    private GamePieces gamePieces = new GamePieces();
    private PieceMovement move = new PieceMovement();

    {
        gamePieces.createGamePieces();
    }

    public GamePieces getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(GamePieces board) {
        this.gamePieces = board;
    }

    public boolean isLegalMove(GamePieces currentBoard, GamePieces changedBoard){
        GamePiece changedPiece = findChangedPiece(currentBoard, changedBoard);
        GamePiece originalLocation = getOriginalPiece(changedPiece, currentBoard);

        if(jumpAvailable(currentBoard) == true){
            if(!isJump(changedPiece, originalLocation)){
                return false;
            }
        }

        if(!isMove(changedPiece, originalLocation)){
            return false;
        }

        if(spaceOccupied(currentBoard, changedPiece)){
           return false;
        }
        return true;
    }

    public boolean isMove(GamePiece changedPiece, GamePiece originalLocation){
        if((originalLocation.getRow() + 1 == changedPiece.getRow()) &&
                (originalLocation.getColumn() + 1 == changedPiece.getColumn() ||
                        originalLocation.getColumn() - 1 == changedPiece.getColumn())){
            return true;
        }
        if(originalLocation.getIsKing() == true && ((originalLocation.getRow() + 1 == changedPiece.getRow() ||
                originalLocation.getRow() - 1 == changedPiece.getRow()) &&
                (originalLocation.getColumn() + 1 == changedPiece.getColumn() ||
                        originalLocation.getColumn() - 1 == changedPiece.getColumn()))){
            return true;
        }
        return false;
    }

    public boolean isJump(GamePiece changedPiece, GamePiece originalLocation){
        if((originalLocation.getRow() + 2 == changedPiece.getRow()) &&
                (originalLocation.getColumn() + 2 == changedPiece.getColumn() ||
                        originalLocation.getColumn() - 2 == changedPiece.getColumn())){
            return true;
        }
        if(originalLocation.getIsKing() == true && ((originalLocation.getRow() + 2 == changedPiece.getRow() ||
                originalLocation.getRow() - 2 == changedPiece.getRow()) &&
                (originalLocation.getColumn() + 2 == changedPiece.getColumn() ||
                        originalLocation.getColumn() - 2 == changedPiece.getColumn()))){
            return true;
        }
        return false;
    }

    public GamePiece findChangedPiece(GamePieces currentBoard, GamePieces changedBoard) {
        if (currentBoard.size() == changedBoard.size()) {
            for (int k = 0; k < currentBoard.size(); k++) {
                if (currentBoard.get(k).getIdentifier() == changedBoard.get(k).getIdentifier() && (
                        currentBoard.get(k).getRow() != changedBoard.get(k).getRow() ||
                                currentBoard.get(k).getColumn() != changedBoard.get(k).getColumn())) {
                    return changedBoard.get(k);
                }
            }
        } else {
            for (int i = 0; i < currentBoard.size(); i++) {
                for (int j = 0; j < changedBoard.size(); j++) {
                    if (currentBoard.get(i).getIdentifier() == changedBoard.get(j).getIdentifier()) {
                        if (currentBoard.get(i).getIdentifier() == changedBoard.get(j).getIdentifier() && (
                                currentBoard.get(i).getRow() != changedBoard.get(j).getRow() ||
                                        currentBoard.get(i).getColumn() != changedBoard.get(j).getColumn())) {
                            return changedBoard.get(j);
                        }
                    }
                }
            }
        }
        return null;
    }

    public GamePiece getOriginalPiece(GamePiece changedPiece, GamePieces currentBoard){
        for(int i = 0; i < currentBoard.size(); i++){
            if(changedPiece.getIdentifier() == currentBoard.get(i).getIdentifier()){
                return currentBoard.get(i);
            }
        }
        return null;
    }

    public boolean jumpAvailable(GamePieces currentBoard){
        for(int i = 0; i < currentBoard.size(); i++){
            if(currentBoard.get(i).getIdentifier() > 12){
                GamePiece temp = currentBoard.get(i);
                if((move.checkLowerLeft(temp, currentBoard) == FRIENDLY || move.checkLowerLeft(temp, currentBoard) == ENEMY_KING) &&
                        move.checkLowerLeft(temp.getRow() + 1, temp.getColumn() - 1, currentBoard) == EMPTY){
                    return true;
                }
                if((move.checkLowerRight(temp, currentBoard) == ENEMY || move.checkLowerRight(temp, currentBoard) == ENEMY_KING) &&
                        move.checkLowerRight(temp.getRow() + 1, temp.getColumn() + 1, currentBoard) == EMPTY){
                    return true;
                }
                if(temp.getIsKing() == true && (move.checkUpperLeft(temp, currentBoard) == ENEMY || move.checkUpperLeft(temp, currentBoard) == ENEMY_KING) &&
                        move.checkUpperLeft(temp.getRow() - 1, temp.getColumn() - 1, currentBoard) == EMPTY){
                    return true;
                }
                if(temp.getIsKing() == true && (move.checkUpperRight(temp, currentBoard) == ENEMY || move.checkUpperRight(temp, currentBoard) == ENEMY_KING) &&
                        move.checkLowerRight(temp.getRow() - 1, temp.getColumn() + 1, currentBoard) == EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean spaceOccupied(GamePieces currentBoard, GamePiece changedPiece){
        for(int i = 0; i < currentBoard.size(); i++){
            if(changedPiece.getRow() == currentBoard.get(i).getRow() &&
                    changedPiece.getColumn() == currentBoard.get(i).getColumn()){
                return true;
            }
        }
        return false;
    }
}



package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;

import java.util.ArrayList;

public class PieceMovement {
    //public GameService gameService = new GameService();
    public byte moveCounter;
    public byte highestCounter;
    public ArrayList<GamePiece> bestMoveStart = new ArrayList<>();
    public ArrayList<GamePiece> bestMoveEnd = new ArrayList<>();
    public GameBoard board = new GameBoard();

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

    public void makeMove(GamePiece piece, GamePiece space){
        if(space.getIdentifier() == 0 && piece.getIdentifier() > 0 && piece.getIdentifier() < 13){
            space = piece;
            piece = new GamePiece("");
        }
    }

    public void removePiece(GamePiece piece){
        piece = new GamePiece("");
    }

    protected int checkSpace(GamePiece space){
        if(space.getIdentifier() > 12){
            return 2;
        } else if(space.getIdentifier() > 0){
            return 1;
        } else {
            return 0;
        }
    }

    //returning 1 for friendly, 0 for nothing, 2 for enemy, -1 does not exist
    //refactor to one method using new parameter direction
    protected int checkUpperLeft(GamePiece piece){
        if(piece.getRow() != 0 && piece.getColumn() != 0) {
            GamePiece space = board.getGamePieceFromBoard(piece.getRow() - 1, piece.getColumn() - 1);
            return checkSpace(space);
        } else {
            return -1;
        }
    }

    protected int checkUpperRight(GamePiece piece){
        if(piece.getRow() != 0 && piece.getColumn() != 7){
            GamePiece space = board.getGamePieceFromBoard(piece.getRow() - 1, piece.getColumn() + 1);
            return checkSpace(space);
        } else {
            return -1;
        }
    }

    protected int checkLowerLeft(GamePiece piece){
        if(piece.getRow() != 7 && piece.getColumn() != 0){
            GamePiece space = board.getGamePieceFromBoard(piece.getRow() + 1, piece.getColumn() - 1);
            return checkSpace(space);
        } else {
            return -1;
        }
    }

    protected int checkLowerRight(GamePiece piece){
        if(piece.getRow() != 7 && piece.getColumn() != 7){
            GamePiece space = board.getGamePieceFromBoard(piece.getRow() + 1, piece.getColumn() + 1);
            return checkSpace(space);
        } else {
            return -1;
        }
    }


    protected void checkAvailableJump(GamePiece piece){
        if(checkLowerRight(piece) == 2){
            if(checkLowerRight(board.getGamePieceFromBoard((piece.getRow() + 1), (piece.getColumn() + 1))) == 0){
                makeMove(piece, board.getGamePieceFromBoard((piece.getRow() + 2), (piece.getColumn() + 2)));
                removePiece(board.getGamePieceFromBoard((piece.getRow() + 1), (piece.getColumn() + 1)));
            }
        }
        if (checkLowerLeft(piece) == 2) {
            if(checkLowerLeft(board.getGamePieceFromBoard((piece.getRow() + 1), (piece.getColumn() - 1))) == 0){
                makeMove(piece, board.getGamePieceFromBoard((piece.getRow() + 2), (piece.getColumn() - 2)));
                removePiece(board.getGamePieceFromBoard((piece.getRow() + 1), (piece.getColumn() - 1)));
            }
        }
    }

    protected boolean checkForMoves(GamePiece piece){
        if(checkLowerLeft(piece) == 0 || checkLowerRight(piece) == 0){
            return true;
        } else {
            return false;
        }
    }

    protected void determineValueOfMove(GamePiece piece, GamePiece move){}


    protected void isAvoidJump(GamePiece piece, GamePiece move){}

    protected void isMultiJumpOnNextTurn(GamePiece piece, GamePiece move){}

    protected void isJumpOnNextTurn(GamePiece piece, GamePiece move){}

    protected void isTwoInARow(GamePiece piece, GamePiece move){}

    protected void isMovingBackRow(GamePiece piece, GamePiece move){}

    protected void isDefendFromImmediateJump(GamePiece piece, GamePiece move){}

    protected void isLeavingOthersForJump(GamePiece piece, GamePiece move){}

    protected void isSettingUpOwnJump(GamePiece piece, GamePiece move){}

    protected void isGettingKing(GamePiece piece, GamePiece move){}

    protected void isBlockingOwnJump(GamePiece piece, GamePiece move){}

}

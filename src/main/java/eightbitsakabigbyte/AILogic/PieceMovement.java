package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GameBoard;
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
    public ArrayList<GamePiece> gameBoard = new ArrayList<>();


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
    // method that calls move has to know where it is moving.

    public GamePiece makeMove(GamePiece piece, GamePiece space, int row, int column){

        return null;
    }

//    public void removePiece(GamePiece piece){
//
//    }
//
//    protected Pieces checkSpace(GamePiece space){
//
//    }
//
//    //returning 1 for friendly, 0 for nothing, 2 for enemy, -1 does not exist, 3 for enemy King
//    //refactor to one method using new parameter direction
//    protected Pieces checkUpperLeft(GamePiece piece){
//
//        }
//    }
//
//    protected Pieces checkUpperRight(GamePiece piece){
//
//
//    }
//
//    protected Pieces checkLowerLeft(GamePiece piece){
//
//    }
//
//    protected Pieces checkLowerRight(GamePiece piece){
//
//    }
//
//
//    protected void checkAvailableJump(GamePiece piece){
//
//    }
//
//    protected boolean checkForMoves(GamePiece piece){
//
//    }
//
//    protected void determineValueOfMove(GamePiece piece, GamePiece move){}
//
//
//    protected void isAvoidJump(GamePiece piece, GamePiece move){
//       }

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

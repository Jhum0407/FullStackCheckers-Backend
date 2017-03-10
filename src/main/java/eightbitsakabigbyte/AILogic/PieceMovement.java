package eightbitsakabigbyte.AILogic;

import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Service.GameService;

import java.util.ArrayList;

public class PieceMovement {
    public GameService gameService = new GameService();
    public byte moveCounter;
    public byte highestCounter;
    public ArrayList<GamePiece> bestMoveStart = new ArrayList<>();
    public ArrayList<GamePiece> bestMoveEnd = new ArrayList<>();
    public GameBoard board = gameService.getBoard();

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

    }


    protected boolean checkUpperLeft(GamePiece piece){
        if(piece != )
    }

    protected boolean checkUpperRight(GamePiece piece){return false;}

    protected boolean checkLowerLeft(GamePiece piece){return false;}

    protected boolean checkLowerRight(GamePiece piece){return false;}


    protected boolean checkAvailableJump(GamePiece piece){return false;}

    protected boolean checkForMoves(GamePiece piece){return false;}

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

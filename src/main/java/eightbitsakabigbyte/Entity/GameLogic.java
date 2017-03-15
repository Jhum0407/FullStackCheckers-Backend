package eightbitsakabigbyte.Entity;


/**
 * Created by jeriahhumphrey on 3/8/17.
 */
public class GameLogic {

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

    public boolean isLegalMove(MoveRequest request){
        //if legal, send pieces to AILogic for AI's move.
        GamePieces gamePieces = new GamePieces();
        gamePieces.createGamePieces();
        return(request.getRow()==1);
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
}
package eightbitsakabigbyte.Entity;


/**
 * Created by jeriahhumphrey on 3/8/17.
 */
public class GameLogic {
    int changeIndex;

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
                        (currentGamePieces.getPiece(changeIndex).getColumn() - changedGamePieces.getPiece(changeIndex).getColumn() == 1 ||
                                currentGamePieces.getPiece(changeIndex).getColumn() - changedGamePieces.getPiece(changeIndex).getColumn() == -1)) {
                    return true;
                }
            }
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
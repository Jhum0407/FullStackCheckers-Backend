package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GamePiece;
import eightbitsakabigbyte.Entity.GamePieces;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
    public class GameService {
        public GamePieces gamePieces = new GamePieces();
        {
            gamePieces.createGamePieces();
        }

        public boolean getAllPieces(ArrayList<GamePieces> gamePieces){

            return false;
        }


        /*@Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for ( int i = 0; i < gamePieces.size(); i++) {
                sb.append(gamePieces.get(i).getIdentifier() + " " +  gamePieces.get(i).getRow() + " "
                        + gamePieces.get(i).getColumn() + " " + gamePieces.get(i).getIsKing() + "\n");
            }
            return sb.toString();
        }
    }*/
}

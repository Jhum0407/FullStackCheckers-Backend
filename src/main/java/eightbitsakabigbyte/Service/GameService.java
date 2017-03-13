package eightbitsakabigbyte.Service;

import eightbitsakabigbyte.Entity.GamePieces;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GamePieces getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(GamePieces gamePieces) {
        this.gamePieces = gamePieces;
    }

    private GamePieces gamePieces = new GamePieces();
    {
        gamePieces.createGamePieces();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < gamePieces.size(); i++) {
            sb.append(gamePieces.get(i).getIdentifier() + " " +  gamePieces.get(i).getRow() + " "
                    + gamePieces.get(i).getColumn() + " " + gamePieces.get(i).getIsKing() + "\n");
        }
        return sb.toString();
    }
}
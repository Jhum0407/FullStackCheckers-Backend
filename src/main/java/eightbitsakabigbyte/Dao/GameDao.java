package eightbitsakabigbyte.Dao;

import eightbitsakabigbyte.Entity.GameBoard;
import org.springframework.stereotype.Repository;
import java.util.Collection;

public interface GameDao{

    GameBoard getGameBoardById(int id);

    void removeGameBoardById(int id);

    void updateGameBoard(GameBoard gameBoard);

    void insertGameBoardToDb(GameBoard gameBoard);
}

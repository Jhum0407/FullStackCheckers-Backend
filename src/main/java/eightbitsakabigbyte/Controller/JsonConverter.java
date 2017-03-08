package eightbitsakabigbyte.Controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eightbitsakabigbyte.Entity.GameBoard;
import eightbitsakabigbyte.Entity.GamePiece;

import java.io.IOException;

/**
 * Created by gillianreynolds-titko on 3/8/17.
 */
public class JsonConverter {
    //Use this class to convert states of the game board from a Java object to a Json object

    ObjectMapper mapper = new ObjectMapper();
    GameBoard board = new GameBoard();
    String jsonInString = "";

    public String convertBoardToJson(GameBoard board){
        try {
            jsonInString = mapper.writeValueAsString(board);
            System.out.println(jsonInString);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {

        } catch (IOException e) {

        }
        return jsonInString;
    }
}

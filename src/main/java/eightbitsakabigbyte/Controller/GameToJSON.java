package eightbitsakabigbyte.Controller;

//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//
//public class GameToJSON {
//
//    ObjectMapper mapper = new ObjectMapper();
//    GameBoard board = new GameBoard();
//
//    String jsonInString = "";
//
//
//    public String convertBoardToJson(GameBoard board){
//
//        try {
//            jsonInString = mapper.writeValueAsString(board);
//            System.out.println(jsonInString);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonGenerationException e) {
//
//        } catch (IOException e) {
//
//        }
//        return jsonInString;
//    }
//}

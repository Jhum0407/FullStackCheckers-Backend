package eightbitsakabigbyte;

import eightbitsakabigbyte.Controller.JsonConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersappApplication {

	public static void main(String[] args) {
		//JsonConverter jsonConverter = new JsonConverter();
		SpringApplication.run(CheckersappApplication.class, args);
		//jsonConverter.convertBoardToJson();
	}
}

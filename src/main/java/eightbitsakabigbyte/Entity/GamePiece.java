package eightbitsakabigbyte.Entity;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GamePiece {

    private String color = "";
    private boolean isKing = false;
    private int identifier = 0;

    public GamePiece(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
}

package eightbitsakabigbyte.Entity;

/**
 * Created by gillianreynolds-titko on 3/7/17.
 */
public class GamePiece {

    private String color = "";
    private boolean isKing = false;
    private int identifier = 0;
    private int row = -1;
    private int column = -1;

    public GamePiece(boolean isKing, int identifier, int row, int column) {
        this.isKing = isKing;
        this.identifier = identifier;
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public GamePiece(String color){
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public boolean getIsKing() {

        return isKing;
    }

    public void setIsKing(boolean king) {

        isKing = king;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {

        this.identifier = identifier;
    }
}

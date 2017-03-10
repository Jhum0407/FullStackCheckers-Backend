package eightbitsakabigbyte.Entity;

public class GamePiece {

    private boolean isKing = false;
    private int identifier;
    private int row;
    private int column;

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

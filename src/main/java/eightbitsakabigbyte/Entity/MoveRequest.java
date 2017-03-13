package eightbitsakabigbyte.Entity;

public class MoveRequest {

    private static int id;
    private static int row;
    private static int column;
    private static boolean isKing;

    public static boolean isIsKing() {
        return isKing;
    }

    public static void setIsKing(boolean isKing) {
        MoveRequest.isKing = isKing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String toString() {
        return id + " " + column + " " + row;
    }
}

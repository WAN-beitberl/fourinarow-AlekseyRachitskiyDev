public class Piece {
    private CellState color;
    private int row;
    private int column;

    public Piece(CellState colorCode, int row, int column) {
        this.color = colorCode;
        this.row = row;
        this.column = column;
    }

    public CellState getColor() {
        return color;
    }
}

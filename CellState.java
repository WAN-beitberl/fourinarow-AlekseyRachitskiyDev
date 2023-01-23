public enum CellState {
    Empty(0), Yellow(1), Red(2);
    private int colorCode;
    CellState(int colorCode) {
        this.colorCode = colorCode;
    }
}

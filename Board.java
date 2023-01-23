public class Board {

    private Piece[][] pieces;
    private int currPlayer;

    Board(int currPlayer, GameStatus gameStatus) {
        this.pieces = new Piece[6][7];
        this.currPlayer = currPlayer;
    }

    public void placePiece(int row, int column, Piece piece) {
        pieces[row][column] = piece;

    }


    public void displayBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Piece piece = pieces[i][j];
                if (piece == null) {
                    System.out.print((char) 27 + "[37m" +" O ");
                } else {
                    if (piece.getColor().equals(CellState.Red)) {
                        System.out.print((char) 27 + "[31m" + " O ");
                    } else if (piece.getColor().equals(CellState.Yellow)) {
                        System.out.print((char) 27 + "[33m" + " O ");
                    }
                }
            }
            System.out.println();
        }
    }


    public boolean checkWin(int row, int column) {
        Piece piece = pieces[row][column];
        if (checkHorizontal(row, piece) || checkVertical(column, piece) || checkDiagonal(row, column, piece)) {
            return true;
        }
        return false;
    }

    public void clearBoard() {

    }

    public Piece getPiece(int row, int column) {
        return pieces[row][column];
    }

    public boolean isBoardFull() {
        int count = 0;
        for (int j = 0; j < 7; j++) {
            if (pieces[0][j] != null) {
                count++;
            }
        }
        if (count == 7) return true;
        else return false;
    }

    public boolean checkHorizontal(int row, Piece piece) {
        int count = 0;
        for (int j = 0; j < 7; j++) {
            if (pieces[row][j] != null && pieces[row][j].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            }
        }
        return false;
    }

    public boolean checkVertical(int column, Piece piece) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (pieces[i][column] != null && pieces[i][column].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(int row, int column, Piece piece) {
        if (checkDiagonalLeft(row, column, piece) || checkDiagonalRight(row, column, piece)) return true;
        return false;
    }

    public boolean checkDiagonalLeft(int row, int column, Piece piece) {
        int count = 0;
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (pieces[i][j] != null && pieces[i][j].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            } else count = 0;
        }

        for (int i = row + 1, j = column + 1; i < 6 && j < 7; i++, j++) {
            if (pieces[i][j] != null && pieces[i][j].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            } else count = 0;
        }
        return false;
    }

    public boolean checkDiagonalRight(int row, int column, Piece piece) {
        int count = 0;
        for (int i = row, j = column; i >= 0 && j < 7; i--, j++) {
            if (pieces[i][j] != null && pieces[i][j].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            } else count = 0;
        }
        for (int i = row + 1, j = column - 1; i < 6 && j >= 0; i++, j--) {
            if (pieces[i][j] != null && pieces[i][j].getColor() == piece.getColor()) {
                count++;
                if (count == 4) return true;
            } else count = 0;
        }
        return false;
    }

    public int getEmptyPiece(int column) {
        for (int i = 6 - 1; i >= 0; i++) {
            if (pieces[i][column] == null) {
                return i;
            }
        }
        return -1;//No empty row in column
    }
}

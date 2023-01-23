import java.util.Scanner;

public class Game {
    private Board board;
    Player[] players;
    private int currPlayer;
    private GameStatus gameStatus;


    public void startGame() {
        String username;
        Scanner scanner = new Scanner(System.in);
        board = new Board(1, GameStatus.InProgress);
        players = new Player[2];
        System.out.println("Player1, enter your username:");
        username = scanner.nextLine();
        players[0] = new Player(username);
        System.out.println("Player2, enter your username:");
        username = scanner.nextLine();
        players[1] = new Player(username);
        currPlayer = 1;
        gameStatus = GameStatus.InProgress;
        board.displayBoard();
        play(board);
        board.displayBoard();
    }

    public void endGame(Player winner) {
        if (winner != null) {
            gameStatus = GameStatus.Win;
            System.out.println("Player " + winner.getUsername() + " wins!");
        } else {
            gameStatus = GameStatus.Draw;
            System.out.println("Game is draw!");
        }
    }

    public void nextPlayer() {
        if (currPlayer == 1) currPlayer = 2;
        else currPlayer = 1;
    }

    public void play(Board board) {
        CellState cellState;
        System.out.println("Player"+currPlayer+", enter column index:");
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        if (column >= 0 && column <= 7) {
            int row = board.getEmptyPiece(column);//получаем строку со свободной ячейкой.
            if (row >= 0) {
                if (currPlayer == 1) cellState = CellState.Yellow;
                else cellState = CellState.Red;
                board.placePiece(row, column, new Piece(cellState, row, column));
                if (board.checkWin(row, column)) {
                    endGame(players[currPlayer - 1]);
                } else if (board.isBoardFull()) {
                    endGame(players[currPlayer - 1]);
                } else nextPlayer();
            } else System.out.println("Column is full, please choose another column");
        }
    }
}

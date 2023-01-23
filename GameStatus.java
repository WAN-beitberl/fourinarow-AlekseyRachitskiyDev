public enum GameStatus {
    InProgress(0), Win(1), Draw(2);//0 - игра в прогрессе, 1 - один из игроков выйграл, 2 - ничья, не осталось свободных мест
    private int gameStatusCode;

    GameStatus(int gameStatusCode) {
        this.gameStatusCode = gameStatusCode;
    }

    public int getColorCode() {
        return gameStatusCode;
    }
}

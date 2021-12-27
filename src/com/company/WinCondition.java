package com.company;

public class WinCondition {
    private final int COLS = 3;
    private final int ROWS = 3;
    private Board board;
    private int[][] table = new int[COLS][ROWS];;
    private int winner;

    public WinCondition(Board board) {
        this.board = board;
    }

    void convertToTable() {
        int index = 0;
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                table[i][j] = board.getButtonOwner(index);
                index++;
            }
        }
    }

    public int checkWin() {
        convertToTable();
        // Diagonal
        if((table[0][0] == table[1][1]) && (table[1][1] == table[2][2]) && table[2][2] != 0) {
            winner = (table[2][2]);
            return 1;
        }
        if((table[2][0] == table[1][1]) && (table[1][1] == table[0][2]) && table[0][2] != 0) {
            winner = (table[0][2]);
            return 1;
        }
        // Vertical
        if((table[0][0] == table[0][1]) && (table[0][1] == table[0][2]) && table[0][2] != 0) {
            winner = (table[0][2]);
            return 1;
        }
        if((table[1][0] == table[1][1]) && (table[1][1] == table[1][2]) && table[1][2] != 0) {
            winner = (table[1][2]);
            return 1;
        }
        if((table[2][0] == table[2][1]) && (table[2][1] == table[2][2]) && table[2][2] != 0) {
            winner = (table[2][2]);
            return 1;
        }
        // Horizontal
        if((table[0][0] == table[1][0]) && (table[1][0] == table[2][0]) && table[2][0] != 0) {
            winner = (table[2][0]);
            return 1;
        }
        if((table[0][1] == table[1][1]) && (table[1][1] == table[2][1]) && table[2][1] != 0) {
            winner = (table[2][1]);
            return 1;
        }
        if((table[0][2] == table[1][2]) && (table[1][2] == table[2][2]) && table[2][2] != 0) {
            winner = (table[2][2]);
            return 1;
        }
        return 0;
    }

    public int showWinner() {
        return winner;
    }
}

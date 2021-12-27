package com.company;

public class GameState {
    private int nextTurn;
    private int turnNumber;
    private boolean gameIsFinished;

    public GameState(int nextTurn) {
        this.nextTurn = nextTurn;
    }

    public int getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(int nextTurn) {
        this.nextTurn = nextTurn;
    }

    public void increaseTurnNumber() {
        this.turnNumber = turnNumber + 1;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public boolean getGameIsFinished() {
        return gameIsFinished;
    }

    public void setGameIsFinished(boolean gameIsFinished) {
        this.gameIsFinished = gameIsFinished;
    }
}

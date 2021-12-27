package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int cols;
    private int rows;
    private Window window;
    private List<Button> buttons = new ArrayList<>();
    private GameState gameState;
    private WinCondition winCondition;
    private NewGame newGame;
    Random random = new Random();

    public Board(int cols, int rows, Window window, NewGame newGame) {
        this.cols = cols;
        this.rows = rows;
        this.window = window;
        this.newGame = newGame;
        this.gameState = new GameState(random.nextInt(2));
        this.winCondition = new WinCondition(this);
    }

    public void drawNewBoard() {
        int posX = 0;
        int posY = 0;
        int locationX = 0;
        int locationY = 0;
        int boardSize = 0;
        for(int i = 0; i < cols; i++) {
            buttons.add(new Button(200, 190, posX, posY, "", gameState, winCondition, newGame));
            window.add(buttons.get(boardSize).getButton());
            for(int j = 0; j < rows - 1; j++) {
                posY += 190;
                locationY += 1;
                boardSize += 1;
                buttons.add(new Button(200, 190, posX, posY, "", gameState, winCondition, newGame));
                window.add(buttons.get(boardSize).getButton());
            }
            posX += 200;
            locationX += 1;
            posY = 0;
            locationY = 0;
            boardSize += 1;
        }
        Text gameTitle = new Text(595, 50, 200, 50, "Kółko i Krzyżyk", 24);
        Text gameAuthor = new Text(595, 100, 200, 50, "By FunkyJimm", 16);
        window.add(gameTitle.getText());
        window.add(gameAuthor.getText());
    }

    public int getButtonOwner(int index) {
        return buttons.get(index).getButtonOwner();
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JFrame implements ActionListener {
    private String text;
    private GameState gameState;
    private WinCondition winCondition;
    private NewGame newGame;
    private JButton button;
    private boolean isClickable = true;
    private int buttonOwner;

    public Button(int width, int height, int posX, int posY, String text,
                  GameState gameState, WinCondition winCondition, NewGame newGame) {
        this.gameState = gameState;
        this.winCondition = winCondition;
        this.newGame = newGame;
        button = new JButton(text);
        button.setBounds(posX, posY, width, height);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 128));
        button.setForeground(Color.white);
        button.setBackground(new Color(20, 10, 30));
        button.addActionListener(this);
    }

    public JButton getButton() {
        return button;
    }


    public int getButtonOwner() {
        return buttonOwner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameState.getGameIsFinished()) {
            if(isClickable) {
                isClickable = false;
                if(gameState.getNextTurn() == 1) {
                    buttonOwner = 1;
                    button.setText("X");
                    button.setBackground(Color.BLUE);
                    gameState.setNextTurn(2);
                } else {
                    buttonOwner = 2;
                    button.setText("O");
                    button.setBackground(Color.RED);
                    gameState.setNextTurn(1);
                }
                if(gameState.getTurnNumber() > 7) {
                    gameState.setGameIsFinished(true);
                    newGame.endGame(3);
                    return;
                } else {
                    if(winCondition.checkWin() == 1) {
                        gameState.setGameIsFinished(true);
                        newGame.endGame(winCondition.showWinner());
                        return;
                    }
                    if(winCondition.checkWin() == 2) {
                        gameState.setGameIsFinished(true);
                        newGame.endGame(winCondition.showWinner());
                        return;
                    }
                }
                gameState.setGameIsFinished(false);
                gameState.increaseTurnNumber();
            }
        }
    }
}

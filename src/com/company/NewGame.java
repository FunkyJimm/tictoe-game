package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JButton implements ActionListener {
    private Window window;
    private Board board;
    private Text text;
    private Text text2;
    private JButton restart;
    private JButton exit;

    public NewGame(Window window) {
        this.window = window;
        drawNewBoard();
    }

    public void drawNewBoard() {
        board = new Board(3, 3, window, this);
        board.drawNewBoard();
        window.repaint();
    }

    public void endGame(int whoWin) {
        String playerColor = "";
        if(whoWin == 3) {
            text = new Text(595, 225, 200, 50, "Mamy", 24);
            text2 = new Text(595, 275, 200, 50, "Remis!", 36);
        } else {
            if(whoWin == 1) playerColor = "Niebieski";
            else if(whoWin == 2) playerColor = "Czerwony";
            text = new Text(595, 225, 200, 50, "Wygrał gracz:", 24);
            text2 = new Text(595, 275, 200, 50, playerColor, 36);
        }
        restart = new JButton("RESTART");
        restart.setBounds(620, 350, 150, 50);
        restart.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        restart.addActionListener(this);

        exit = new JButton("ZAMKNIJ");
        exit.setBounds(620, 400, 150, 50);
        exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        exit.addActionListener(this);

        window.add(text.getText());
        window.add(text2.getText());
        window.add(restart);
        window.add(exit);
        window.repaint();
        return;
    }

    public void restartGame() {
        text.changeText("");
        text2.changeText("");

        window.getContentPane().removeAll();
        window.repaint();
        drawNewBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == restart) {
            restartGame();
        }
        if(e.getSource() == exit) {
            System.exit(0);
        }
    }
}

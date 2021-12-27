package com.company;

import javax.swing.*;
import java.awt.*;

public class Text extends JFrame {
    private JLabel jLabel;

    public Text(int posX, int posY, int width, int height, String text, int fontSize) {
        jLabel = new JLabel(text, SwingConstants.CENTER);
        jLabel.setBounds(posX, posY, width, height);
        jLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        jLabel.setForeground(Color.white);
    }

    public JLabel getText() {
        return jLabel;
    }

    public void changeText(String text) {
        jLabel.setText(text);
    }
}

package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    private final int WINDOWS_POS_X = dimension.width / 2;
    private final int WINDOWS_POS_Y = dimension.height / 2;
    private JFrame window;

    public Window(int width, int height, String title) {
        window = new JFrame();
        setSize(width, height);
        setLocation(WINDOWS_POS_X - width / 2, WINDOWS_POS_Y - height / 2);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        BufferedImage bg = null;
        try {
            bg = ImageIO.read(new File("res//background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(bg);
        setContentPane(new JLabel(imageIcon));

        setLayout(null);
        setVisible(true);
    }
}

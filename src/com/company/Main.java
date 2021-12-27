package com.company;

public class Main {

    public static void main(String[] args) {
        Window window = new Window(800, 600, "Kółko i Krzyżyk v1.0");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NewGame(window);
            }
        });
    }
}

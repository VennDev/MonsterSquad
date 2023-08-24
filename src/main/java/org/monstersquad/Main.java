package org.monstersquad;

import org.monstersquad.game.GamePanel;

import javax.swing.JFrame;

public class Main {

    private final static String TITLE = "Monster Squad";

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        JFrame window = new JFrame(TITLE);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle(TITLE);
        window.add(gamePanel);
        window.pack();

        gamePanel.startGameThread();
    }

}
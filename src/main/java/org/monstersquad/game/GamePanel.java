package org.monstersquad.game;

import org.monstersquad.entity.entities.Player;
import org.monstersquad.handler.KeyHandler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();

    Player player = new Player(this, keyHandler);

    final int FPS = 60;

    final int originalTileSize = 25;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int maxScreenWidth = maxScreenColumns * tileSize;
    final int maxScreenHeight = maxScreenRows * tileSize;

    public GamePanel() {
        this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
    }

    public void startGameThread() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        g2d.dispose();
    }

    @Override
    public void run() {
        double delta = 0;
        double drawInterval = 1000000000.0 / FPS;
        long lastDrawTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int frames = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastDrawTime) / drawInterval;
            timer += currentTime - lastDrawTime;
            lastDrawTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                frames++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }
        }
    }

}

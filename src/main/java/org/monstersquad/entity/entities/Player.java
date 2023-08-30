package org.monstersquad.entity.entities;

import org.monstersquad.entity.Entity;
import org.monstersquad.game.GamePanel;
import org.monstersquad.handler.KeyHandler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.sizeX = 25;
        this.sizeY = 25;
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.directoryResource = "/images/characters/player";

        defaultValue();
        getCharacterImage();
    }

    public void update() {
        if (keyHandler.up) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.down) {
            direction = "down";
            y += speed;
        } else if (keyHandler.left) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.right) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;

        switch (direction) {
            case "down", "right" -> {
                updateSprite(10, 6);
                image = runsRight[spriteNumber];
            }
            case "up", "left" -> {
                updateSprite(10, 6);
                image = runsLeft[spriteNumber];
            }
            case "idle" -> {
                updateSprite(10, 8);
                image = idle[spriteNumber];
            }
        }

        if (image != null) {
            g2d.drawImage(image, x, y, gamePanel.tileSize + sizeX, gamePanel.tileSize + sizeY, gamePanel);
        }

        direction = "idle";
    }

    @Override
    public void defaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

}

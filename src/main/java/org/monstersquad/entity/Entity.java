package org.monstersquad.entity;

import org.monstersquad.utils.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public int sizeX, sizeY;

    public int spriteCounter = 0;
    public int spriteNumber = 0;

    public String direction;
    public String directoryResource;

    public BufferedImage[] runsRight = new BufferedImage[6];
    public BufferedImage[] runsLeft = new BufferedImage[6];
    public BufferedImage[] idle = new BufferedImage[8];

    /***
     * This method is used to set the default values of the entity.
     * It will be called when the entity is created.
     */
    public void defaultValue() {
        // Do nothing
    }

    public void updateSprite(int maxCounter, int maxNumber) {
        spriteCounter++;

        if (spriteCounter >= maxCounter) {
            spriteNumber++;
            spriteCounter = 0;
        }

        if (spriteNumber >= maxNumber) {
            spriteNumber = 0;
        }
    }

    public void getCharacterImage() {
        try {
            runsRight[0] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-00.png"));
            runsRight[1] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-01.png"));
            runsRight[2] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-02.png"));
            runsRight[3] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-03.png"));
            runsRight[4] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-04.png"));
            runsRight[5] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-05.png"));

            runsLeft[0] = ImageUtil.flipImageHorizontally(runsRight[0]);
            runsLeft[1] = ImageUtil.flipImageHorizontally(runsRight[1]);
            runsLeft[2] = ImageUtil.flipImageHorizontally(runsRight[2]);
            runsLeft[3] = ImageUtil.flipImageHorizontally(runsRight[3]);
            runsLeft[4] = ImageUtil.flipImageHorizontally(runsRight[4]);
            runsLeft[5] = ImageUtil.flipImageHorizontally(runsRight[5]);

            idle[0] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-00.png"));
            idle[1] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-01.png"));
            idle[2] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-02.png"));
            idle[3] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-03.png"));
            idle[4] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-04.png"));
            idle[5] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-05.png"));
            idle[6] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-06.png"));
            idle[7] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/idle-07.png"));
        } catch (Exception e) {
            System.out.println("Error loading character images.");
        }
    }

}

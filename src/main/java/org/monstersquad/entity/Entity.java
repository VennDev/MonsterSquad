package org.monstersquad.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public int sizeX, sizeY;

    public String direction;
    public String directoryResource;
    public BufferedImage[] runs = new BufferedImage[6];

    /***
     * This method is used to set the default values of the entity.
     * It will be called when the entity is created.
     */
    public void defaultValue() {
        // Do nothing
    }

    public void getCharacterImage() {
        try {
            runs[0] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-00.png"));
            runs[1] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-01.png"));
            runs[2] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-02.png"));
            runs[3] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-03.png"));
            runs[4] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-04.png"));
            runs[5] = ImageIO.read(getClass().getResourceAsStream(directoryResource + "/run-05.png"));
        } catch (Exception e) {
            System.out.println("Error loading character images.");
        }
    }

}

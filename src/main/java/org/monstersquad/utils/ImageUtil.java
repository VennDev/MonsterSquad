package org.monstersquad.utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static BufferedImage rotateImage(BufferedImage image, double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sin = Math.abs(Math.sin(angleInRadians));
        double cos = Math.abs(Math.cos(angleInRadians));

        int width = image.getWidth();
        int height = image.getHeight();

        int newWidth = (int) Math.floor(width * cos + height * sin);
        int newHeight = (int) Math.floor(height * cos + width * sin);

        BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, image.getType());

        AffineTransform at = new AffineTransform();
        at.translate(newWidth / 2, newHeight / 2);
        at.rotate(angleInRadians, 0, 0);
        at.translate(-width / 2, -height / 2);

        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        op.filter(image, rotatedImage);

        return rotatedImage;
    }

    public static BufferedImage flipImageHorizontally(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage flippedImage = op.filter(image, null);

        return flippedImage;
    }

}

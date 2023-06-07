package de.baromeus.dueldemo.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    private static final String IMAGE_PATH = "src/de/baromeus/dueldemo/images/";
    public static final String IMAGE_TOWN = "town.png";
    public static final String IMAGE_BLACKSMITH= "blacksmith.png";
    public static final String IMAGE_ARMORY = "armory.png";
    public static final String IMAGE_CROCER = "crocer.png";
    public static final String IMAGE_TAVERN = "tavern.png";
    public static final String IMAGE_WILDNESS = "wildness.png";
    public static final String IMAGE_ARENA = "arena.png";
    public static final String IMAGE_TITLE_L = "title-left.png";
    public static final  String IMAGE_TITLE_C = "title-center.png";
    public static final String IMAGE_TITLE_R = "title-right.png";
    public static final String IMAGE_SIDE = "sides.png";
    public static final String IMAGE_MALE ="male.png";
    public static final String IMAGE_FEMALE = "female.png";



    public static Image getImage(String file) {
        BufferedImage image = null;
        try {
            File png = new File(IMAGE_PATH + file);
            image = ImageIO.read(png);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return image;
    }

    public static ImageIcon getImageIcon(String file) {
        ImageIcon image = null;
        try {
            image = new ImageIcon(IMAGE_PATH + file);
        } finally {

        }
        return image;
    }
}

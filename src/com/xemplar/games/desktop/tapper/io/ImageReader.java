package com.xemplar.games.desktop.tapper.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by roxas on 10/8/16.
 */
public class ImageReader {
    public static BufferedImage getImage(String path){ try {
        return ImageIO.read(new File(path));
    } catch(Exception e){ return null; }}
}

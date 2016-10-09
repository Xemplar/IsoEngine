package com.xemplar.games.desktop.tapper.graphics;

import com.xemplar.games.desktop.tapper.io.ImageReader;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.xemplar.games.desktop.tapper.tile.Tile.TILE_SIZE;

/**
 * Created by roxas on 10/8/16.
 */
public class SpriteSheet {
    public BufferedImage img;

    public SpriteSheet(String path){
        this.img = ImageReader.getImage(path);
    }

    public Sprite getSprite(int x, int y){
        return new Sprite(this, x, y, 1, 1);
    }

    public Sprite getSprite(int x, int y, int width, int height){
        return new Sprite(this, x, y, width, height);
    }

    public void render(int dx, int dy, int sy, int sx, int swidth, int sheight, Graphics2D g){
        Rectangle s = g.getClipBounds();
        g.drawImage(img, dx, dy, dx + TILE_SIZE, dy + TILE_SIZE, sx, sy, sx + swidth, sy + sheight, null);
    }
}

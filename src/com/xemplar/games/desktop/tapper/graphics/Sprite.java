package com.xemplar.games.desktop.tapper.graphics;

import com.xemplar.games.desktop.tapper.tile.Tile;

import java.awt.*;

/**
 * Created by roxas on 10/8/16.
 */
public class Sprite {
    private SpriteSheet sheet;
    private int offX, offY, width, height;

    Sprite(SpriteSheet sheet, int xp, int yp, int width, int height){
        this.sheet = sheet;
        this.offX = yp * Tile.TEX_SIZE;
        this.offY = xp * Tile.TEX_SIZE;
        this.width = width * Tile.TEX_SIZE;
        this.height = height * Tile.TEX_SIZE;
    }

    public void render(Tile t, Graphics2D g){
        Shape s = g.getClip();
        g.setClip(t.getMaster());
        sheet.render(t.getClipX(), t.getClipY(), offX, offY, width, height, g);
        g.setClip(s);
    }
}

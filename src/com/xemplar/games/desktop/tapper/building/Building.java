package com.xemplar.games.desktop.tapper.building;

import com.xemplar.games.desktop.tapper.graphics.SpriteSheet;
import com.xemplar.games.desktop.tapper.tile.Tile;

import java.awt.*;

/**
 * Created by roxas on 10/8/16.
 */
public abstract class Building {
    protected SpriteSheet sheet;
    protected int x, y, draw;
    protected Tile[] tiles;

    public Building(SpriteSheet sheet, int x, int y){
        this.sheet = sheet;
        this.x = x;
        this.y = y;

        draw = setupTiles();
    }

    protected abstract int setupTiles();

    public void render(Graphics2D g){
        for(int i = 0; i < draw; i++){
            tiles[i].render(g);
        }
    }
}

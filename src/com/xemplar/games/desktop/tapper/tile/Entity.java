package com.xemplar.games.desktop.tapper.tile;

import com.xemplar.games.desktop.tapper.graphics.Sprite;

/**
 * Created by roxas on 10/8/16.
 */
public class Entity extends Tile {
    public Entity(Sprite s, int startX, int startY){
        super(s, startX, startY);
    }

    public void addX(int x){
        this.x += x;
        setupBounds();
    }

    public void addY(int y){
        this.z += y;
        setupBounds();
    }
}

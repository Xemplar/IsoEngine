package com.xemplar.games.desktop.tapper.building;

import com.xemplar.games.desktop.tapper.graphics.Sprite;
import com.xemplar.games.desktop.tapper.graphics.SpriteSheet;
import com.xemplar.games.desktop.tapper.tile.Tile;

/**
 * Created by roxas on 10/8/16.
 */
public class Church extends Building {
    public Church(SpriteSheet sheet, int x, int y){
        super(sheet, x, y);
    }

    protected int setupTiles() {
        tiles = new Tile[8];

        tiles[0] = new Tile(sheet.getSprite(9, 7), x + 2, y + 1);
        tiles[1] = new Tile(sheet.getSprite(9, 7), x + 2, y + 2);

        tiles[2] = new Tile(sheet.getSprite(0, 5), x, y);
        tiles[3] = new Tile(sheet.getSprite(0, 5), x, y + 1);
        tiles[4] = new Tile(sheet.getSprite(0, 5), x + 1, y);
        tiles[5] = new Tile(sheet.getSprite(0, 5), x + 1, y + 1);

        tiles[6] = new Tile(sheet.getSprite(1, 1), x + 1, y + 3);
        tiles[7] = new Tile(sheet.getSprite(1, 1), x + 2, y + 3);

        return 8;
    }
}

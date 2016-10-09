package com.xemplar.games.desktop.tapper.tile;

import com.xemplar.games.desktop.tapper.graphics.Sprite;
import com.xemplar.games.desktop.tapper.math.Vector;

import java.awt.*;

public class Tile{
    public static final int TILE_SIZE = 64;
    public static final int HALF_SIZE = TILE_SIZE / 2;
    public static final int QUAR_SIZE = TILE_SIZE / 4;
    
    public static final int TEX_SIZE = 64;
    public static final Vector px = new Vector(HALF_SIZE, QUAR_SIZE);
    public static final Vector py = new Vector(0, HALF_SIZE);
    public static final Vector pz = new Vector(-(HALF_SIZE), QUAR_SIZE);

    private Polygon master;
    private int clipX, clipY;

    protected int x, z, width, depth, height;
    protected Color color;
    protected Sprite s;

    public Tile(int color, int x, int z){
        this.x = x;
        this.z = z;

        this.width = 1;
        this.depth = 1;
        this.height = 0;

        this.color = new Color(color);
        setupBounds();
    }

    public Tile(Sprite s, int x, int z){
        this.x = x;
        this.z = z;

        this.width = 1;
        this.depth = 1;

        this.s = s;
        setupBounds();
    }

    public Tile(int color, int x, int z, int width, int height, int depth){
        this.x = x;
        this.z = z;

        this.width = width;
        this.depth = depth;
        this.height = height;

        this.color = new Color(color);
        setupBounds();
    }

    public Tile(Sprite s, int x, int z, int width, int height, int depth){
        this.x = x;
        this.z = z;

        this.width = width;
        this.depth = depth;
        this.height = height;

        this.s = s;
        setupBounds();
    }

    protected final void setupBounds(){
        long before = System.nanoTime();

        int[] xc_m = new int[6];
        int[] yc_m = new int[6];

        Vector u1v1w1 = new Vector((HALF_SIZE), 0);
        Vector u2v1w1 = u1v1w1.cpy().add(px);
        Vector u1v2w1 = u1v1w1.cpy().add(pz);
        Vector u2v2w1 = u2v1w1.cpy().add(u1v2w1).add(-u1v1w1.x, 0);

        Vector u2v1w2 = u2v1w1.cpy().add(py);
        Vector u1v2w2 = u1v2w1.cpy().add(py);
        Vector u2v2w2 = u2v2w1.cpy().add(py);
        
        // Master
        xc_m[0] = x * TILE_SIZE + Math.round(u1v1w1.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);
        xc_m[1] = x * TILE_SIZE + Math.round(u2v1w1.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);
        xc_m[2] = x * TILE_SIZE + Math.round(u2v1w2.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);
        xc_m[3] = x * TILE_SIZE + Math.round(u2v2w2.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);
        xc_m[4] = x * TILE_SIZE + Math.round(u1v2w2.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);
        xc_m[5] = clipX = x * TILE_SIZE + Math.round(u1v2w1.x - (x * HALF_SIZE) - (z * HALF_SIZE) - HALF_SIZE);

        yc_m[0] = clipY = z * TILE_SIZE + Math.round(u1v1w1.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));
        yc_m[1] = z * TILE_SIZE + Math.round(u2v1w1.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));
        yc_m[2] = z * TILE_SIZE + Math.round(u2v1w2.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));
        yc_m[3] = z * TILE_SIZE + Math.round(u2v2w2.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));
        yc_m[4] = z * TILE_SIZE + Math.round(u1v2w2.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));
        yc_m[5] = z * TILE_SIZE + Math.round(u1v2w1.y + (x * QUAR_SIZE) - (z * TILE_SIZE * 0.75F));

        master = new Polygon(xc_m, yc_m, 6);

        long after = System.nanoTime();
        System.out.println(after - before);
    }

    public void render(Graphics2D g){
        if(color != null) {
            g.setColor(color);
            g.fillPolygon(master);
        } else {
            s.render(this, g);
        }
    }

    public Shape getMaster(){
        return master;
    }

    public int getClipX(){
        return clipX;
    }

    public int getClipY(){
        return clipY;
    }

    public Tile clone(int x, int y){
        return new Tile(this.s, x, y);
    }
}

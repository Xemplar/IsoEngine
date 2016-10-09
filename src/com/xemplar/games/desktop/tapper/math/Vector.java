package com.xemplar.games.desktop.tapper.math;

/**
 * Created by roxas on 10/7/16.
 */
public class Vector {
    public float x, y;

    public Vector(){
        this.x = 0;
        this.y = 0;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(float x, float y){
        this.x += x;
        this.y += y;

        return this;
    }

    public Vector add(Vector v2){
        this.x += v2.x;
        this.y += v2.y;

        return this;
    }

    public float getMagnitude(){
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public float getDegrees(){
        return (float) Math.toDegrees(Math.atan((double)y / (double)x));
    }

    public Vector cpy(){
        return new Vector(x, y);
    }
}

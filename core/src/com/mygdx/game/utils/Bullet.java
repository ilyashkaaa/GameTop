package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {
    Sprite texture;
    double damage, distance, bulletSpeed;

    public Bullet(Sprite texture, double damage, double distance, double bulletSpeed) {
        this.texture = texture;
        this.damage = damage;
        this.distance = distance;
        this.bulletSpeed = bulletSpeed;
    }
    public void move(float x0, float y0, double sinus, double cosinus) {
        // TODO math
    }
}

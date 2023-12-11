package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;
import java.util.List;

public class BulletStorage {
    public static List<Bullet> bullets = new LinkedList<>();

    public static void draw(SpriteBatch batch) {
        for (Bullet bullet :  bullets) {
            if (!bullet.isAlive()) {
                bullets.remove(bullet);
                break;
            }
        }
        for (Bullet bullet : bullets) {
            bullet.move();
            bullet.draw(batch);
        }
    }
}

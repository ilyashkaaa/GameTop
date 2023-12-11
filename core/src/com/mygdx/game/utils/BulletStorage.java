package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;
import java.util.List;

public class BulletStorage {
    public static List<Bullet> bullets = new LinkedList<>();

    public static void draw(SpriteBatch batch) {
        for (Bullet bullet :  bullets) {
            boolean isAlive = bullet.move();
            if (!isAlive) {
                bullets.remove(bullet);
                continue;
            }
            bullet.draw(batch);
        }
    }
}

package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.enemies.EnemiesStorage;
import com.mygdx.game.enemies.Enemy;
import com.mygdx.game.items.weapon.Gun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BulletStorage {
    public static List<Bullet> bullets = new LinkedList<>();
    static long lastDamageTime;
    static int count = 0;
    public int hp;
    public static List<Bullet> toDelete = new ArrayList<>();

    public static void draw(SpriteBatch batch) {
//        toDelete.clear();
        for (Bullet bullet : bullets) {
            if (!bullet.isAlive()) {
                bullets.remove(bullet);
                break;
            }
        }
            for (Enemy enemy : EnemiesStorage.enemyList) {
                for (Bullet bullet : BulletStorage.bullets) {
                if (bullet.x + 8 * MyGdxGame.scaleBullet >= enemy.x0 && bullet.x + 8 * MyGdxGame.scaleBullet <= enemy.x0 + enemy.width * MyGdxGame.scale
                        && bullet.y + 8 * MyGdxGame.scaleBullet >= enemy.y0 && bullet.y + 8 * MyGdxGame.scaleBullet <= enemy.y0 + enemy.height * MyGdxGame.scale) {
                    enemy.hp-= bullet.damage;
                    bullets.remove(bullet);
                   break;
                }
            }
        }
        for (Bullet bullet : BulletStorage.bullets) {
            bullet.move();
            bullet.draw(batch);
        }
    }
}

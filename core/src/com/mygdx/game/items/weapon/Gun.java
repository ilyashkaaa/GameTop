package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;


public class Gun extends Weapon {
    Sprite bulletTexture;
    double bulletSpeed;
    // урон
    double damage;
    //время перезарядки в сек
    double reload;
    //расстояние стрельбы
    double distance;
    //объем обоймы
    int clip;
    int currentClip;
    double shotDelay;


    long lastBulletTime = 0L;
    long reloadStarted = 0L;


    public void shoot(float x, float y, double sinus, double cosinus) {
        long currentTime = System.currentTimeMillis();
        if (currentClip == 0) {
            if (((double) currentTime - reloadStarted) / 1000 >= reload) {
                currentClip = clip;
            } else {
                return;
            }
        }
        if (((double) currentTime - lastBulletTime) / 1000 >= shotDelay) {
            lastBulletTime = currentTime;
            currentClip--;
            if (currentClip == 0) {
                reloadStarted = currentTime;
            }
            BulletStorage.bullets.add(new Bullet(bulletTexture, damage, distance, bulletSpeed, x, y, sinus, cosinus));
        }
    }
}


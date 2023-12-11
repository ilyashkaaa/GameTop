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


    long lastBulletTime = 0L;


    public void shoot(float x, float y, double sinus, double cosinus) {
        long currentTime = System.currentTimeMillis();
        if (((double)currentTime - lastBulletTime) / 1000 >= reload) {
            lastBulletTime = currentTime;
            BulletStorage.bullets.add(new Bullet(bulletTexture, damage, distance, bulletSpeed, x, y, sinus, cosinus));
        }
    }
}

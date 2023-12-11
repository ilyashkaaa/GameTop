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

    public void shoot(float x, float y, double cosinus, double sinus) {
        BulletStorage.bullets.add(new Bullet(bulletTexture, damage, distance, bulletSpeed, x, y, cosinus, sinus));
    }
}

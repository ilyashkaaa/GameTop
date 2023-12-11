package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;

public class Gun extends Weapon {
    Sprite bulletTexture;
    Sprite weaponTexture;
    //Sprite weaponTexture = new Sprite()
    double bulletSpeed = 5;
    // урон
    double damage = 5;
    //время перезарядки в сек
    double reload = 2;
    //расстояние стрельбы
    double distance = 100;
    //объем обоймы
    int clip = 10;
    int currentClip;
    double shotDelay = 0.25;
    long lastBulletTime = 0L;
    long reloadStarted = 0L;
    int extraRotate = 0;
    boolean wasFliped;

    public void init(int originX, int orinigY, int scale){
        weaponTexture.setOrigin(originX, orinigY);
        weaponTexture.scale(scale);
    }
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
    public void draw(SpriteBatch batch, float x, float y, float angel){
        weaponTexture.setPosition(x, y);
        weaponTexture.setRotation(angel - extraRotate);
        if((extraRotate > 180 && wasFliped) && (extraRotate < 180 && !wasFliped)) weaponTexture.flip(false, true);
        weaponTexture.draw(batch);
    }
}

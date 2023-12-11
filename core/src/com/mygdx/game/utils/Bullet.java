package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.awt.ScrollPane;

public class Bullet {
    Sprite sprite;
    double damage, distance, bulletSpeed;
    double sinus, cosinus;
    float x, y;
    float x0, y0;
    double moveAngle;

    public Bullet(Sprite texture, double damage, double distance, double bulletSpeed, float x, float y, double cosinus, double sinus) {
        this.sprite = texture;
        this.damage = damage;
        this.distance = distance;
        this.bulletSpeed = bulletSpeed;
        sprite = new Sprite(texture);
        sprite.setOrigin(8, 8);
        sprite.scale(MyGdxGame.scaleBullet * 2);
        this.x = x;
        this.y = y;
        x0 = x;
        y0 = y;
        this.cosinus = cosinus;
        this.sinus = sinus;
        if (sinus > 0) this.moveAngle = Math.toDegrees(Math.acos(cosinus));
        else this.moveAngle = 360 - Math.toDegrees(Math.acos(cosinus));

    }
    //float x0, float y0, double sinus, double cosinus

    //float x, float y, float moveAngle
    public void move() {
        x += bulletSpeed * cosinus;
        y += bulletSpeed * sinus;
    }
    public boolean isAlive(){
        return ((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y) <= distance * distance);

    }

    public void draw(SpriteBatch batch) {
        sprite.setPosition(x, y);
        sprite.draw(batch);
        sprite.setRotation((float) moveAngle);

    }

}

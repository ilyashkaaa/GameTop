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
    double moveAngle;

    public Bullet(Sprite texture, double damage, double distance, double bulletSpeed, float x, float y, double sinus, double cosinus) {
        this.sprite = texture;
        this.damage = damage;
        this.distance = distance;
        this.bulletSpeed = bulletSpeed;
        sprite = new Sprite(texture);
        sprite.setOrigin(8, 8);
        sprite.scale(MyGdxGame.scale);
        this.x = x;
        this.y = y;
        this.cosinus = cosinus;
        this.sinus = sinus;
        this.moveAngle = Math.toDegrees(Math.acos(cosinus));

    }
    //float x0, float y0, double sinus, double cosinus

    //float x, float y, float moveAngle
    public boolean move() {
        x+=bulletSpeed*sinus;
        y+=bulletSpeed*cosinus;
        return true;
    }

    public void draw(SpriteBatch batch) {
        sprite.setPosition(x, y);
        sprite.draw(batch);
        sprite.setRotation((float) moveAngle - 90);
        move();

    }

}

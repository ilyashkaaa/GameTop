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

    public Bullet(Sprite texture, double damage, double distance, double bulletSpeed) {
        this.sprite = texture;
        this.damage = damage;
        this.distance = distance;
        this.bulletSpeed = bulletSpeed;
        sprite = new Sprite(texture);
        sprite.setOrigin(8,8);
        sprite.scale(MyGdxGame.scale);
    }
    public void move(float x0, float y0, double sinus, double cosinus) {
        // TODO math
    }
    public void draw(SpriteBatch batch, float x, float y){
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }
    public void rotate(int moveAngel){
        sprite.setRotation(moveAngel);
    }
}

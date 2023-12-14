package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.Bullet;

import java.util.LinkedList;
import java.util.List;

public class EnemiesBullets {
    float distance = 500;
    float x0, y0;
    Sprite sprite;
    double hypo, cosinus, sinus;
    float speed = 10;
    double moveAngle;
    float damage = 5;
    long lastDamageTime;

    public static List<EnemiesBullets> bullets = new LinkedList<>();
    public EnemiesBullets(float x0, float y0, double cosinus, double sinus) {
        this.x0 = x0;
        this.y0 = y0;
        this.cosinus = cosinus;
        this.sinus = sinus;
        sprite = new Sprite(new Texture("textures/enemies/enemy_bullet.png"));
        sprite.scale(MyGdxGame.scaleBullet * 2);
    }

    public static void draw(SpriteBatch batch) {
        for (EnemiesBullets bullet : bullets) {
            if (!bullet.isAlive(bullet.x0, bullet.y0)) {
                bullets.remove(bullet);
                break;
            }
        }
        for (EnemiesBullets bullet : bullets) {
            bullet.move();
            bullet.sprite.setPosition(bullet.x0, bullet.y0);
            bullet.sprite.draw(batch);
            bullet.sprite.setRotation((float) bullet.moveAngle);
            if (Math.abs(bullet.x0 - Hero.x) < 100 && Math.abs(bullet.y0 - Hero.y) < 100 && (System.currentTimeMillis() - bullet.lastDamageTime)/1000 > 1) {
                Hero.hp -= bullet.damage;
                bullet.lastDamageTime = System.currentTimeMillis();
            }
        }
    }

    private boolean isAlive(float x0, float y0) {
        return ((x0 - Hero.x) * (x0 - Hero.x) + (y0 - Hero.y) * (y0 - Hero.y) <= distance * distance);
    }

    public void move() {
        x0 -= speed * cosinus;
        y0 -= speed * sinus;
        if (sinus > 0) {
            moveAngle = Math.toDegrees(Math.acos(cosinus));
        } else {
            moveAngle = 360 - Math.toDegrees(Math.acos(cosinus));
            sprite.setRotation((float) moveAngle);
        }
    }

}

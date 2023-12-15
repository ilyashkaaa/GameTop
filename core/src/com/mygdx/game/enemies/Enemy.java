package com.mygdx.game.enemies;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Enemy {
    protected String title;
    protected String description;
    Sprite[] walking;
    Sprite sprite;
    Sprite boom;
    public double hp = 10;
    double damage;
    public double speed = 3;
    double distanceHero = 8 * MyGdxGame.scale;
    public float x0;
    public float y0;
    boolean[] wasTurned = new boolean[10];
    double hypo;
    double sinus, cosinus;
    public int width = 16, height = 16;
    boolean melee = false;
    boolean small = false;
    long lastDamageTime;
    long lastDamageTimeSmall;
    int counter = 0;
    double moveAngle;

    double heh4 = new Random().nextDouble();



    //Sprite texture, double damage, double hp, double speed, float x0, float y0
    public Enemy(float x, float y) {
        x0 = x;
        y0 = y;
        boom = new Sprite(new Texture("textures/enemies/boom.png"));
        walking = new Sprite[]{
                new Sprite(new Texture("textures/enemies/bubble_city_0.png")),
                new Sprite(new Texture("textures/enemies/bubble_city_1.png")),
        };
        sprite = new Sprite(new Texture("textures/weapons/bullets/radiation.png"));
        for (int i = 0; i < 2; i++) {
            walking[i].setPosition(x, y);
        }
        this.hp = 5;
        this.damage = 10;
        this.speed = 3;
    }

    public void draw(SpriteBatch batch, int frameCount) {

        for (int i = 0; i < walking.length; i++) {
            walking[i].setPosition(x0, y0);
            walking[i].setOrigin(8, 8);
            if (frameCount % 14 >= 0 && frameCount % 14 < 7)
                batch.draw(walking[0], x0, y0, width * MyGdxGame.scale, height * MyGdxGame.scale);
            if (frameCount % 14 >= 7 && frameCount % 14 < 14)
                batch.draw(walking[1], x0, y0, width * MyGdxGame.scale, height * MyGdxGame.scale);
            if (x0 - Hero.x > 0 && !wasTurned[i] || x0 - Hero.x < 0 && wasTurned[i]) {
                walking[i].flip(true, false);
                wasTurned[i] = !wasTurned[i];
            }
        }
        move(batch);
    }

    public void move(SpriteBatch batch) {
        float x = Hero.x - width / 2 * MyGdxGame.scale;
        float y = Hero.y - height / 4 * 3 * MyGdxGame.scale;
        hypo = Math.pow((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y), 0.5);
        cosinus = (x0 - x) / hypo;
        sinus = (y0 - y) / hypo;
        if (hypo >= distanceHero) {
            if (!isEnemyOnTheWay(x0 - speed * cosinus - heh4, y0 - speed * sinus - heh4, this)) {
                x0 -= speed * cosinus - heh4;
                y0 -= speed * sinus - heh4;
            }
        } else {
            attack(x, y);
        }
    }


    public void attack(float x, float y) {

        if (melee && (System.currentTimeMillis() - lastDamageTime) / 1000 >= 1) {
            Hero.hp -= damage;
            counter++;
            lastDamageTime = System.currentTimeMillis();
        }
        if ((System.currentTimeMillis() - lastDamageTime) / 1000 >= 1) {
            hypo = Math.pow((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y), 0.5);
            cosinus = (x0 - x) / hypo;
            sinus = (y0 - y) / hypo;
            EnemiesBullets.bullets.add(new EnemiesBullets(x0 + width / 2 * MyGdxGame.scale, y0 + height / 4 * 3 * MyGdxGame.scale, cosinus, sinus));
            lastDamageTime = System.currentTimeMillis();
            if (sinus > 0) {
                moveAngle = Math.toDegrees(Math.acos(cosinus));
            } else {
                moveAngle = 360 - Math.toDegrees(Math.acos(cosinus));
                sprite.setRotation((float) moveAngle);
            }
        }
    }

    public boolean isEnemyOnTheWay(double x, double y, Enemy enemies) {
        double minC = Double.MAX_VALUE;
        for (Enemy enemy : EnemiesStorage.enemyList) {
            if (enemy == enemies) {
                continue;
            }
            double a = enemy.x0 - x;
            double b = enemy.y0 - y;
            double c = Math.sqrt(a * a + b * b);
            if (c < minC) {
                minC = c;
            }
        }

        return minC < enemies.width * 1.5;
    }
}


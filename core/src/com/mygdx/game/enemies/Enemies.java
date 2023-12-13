package com.mygdx.game.enemies;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Enemies {
    protected String title;
    protected String description;
    Sprite[] walking;
    double hp, damage, speed = 3, distanceHero = 16 * MyGdxGame.scale;
    float x0, y0;
    Basic basic;
    boolean[] wasTurned = new boolean[10];
    double hypo;
    double sinus, cosinus;
    int frameCounter;
    int width = 16, height = 16;


    //Sprite texture, double damage, double hp, double speed, float x0, float y0
public Enemies(float x, float y) {
    x0 = x;
    y0 = y;
    walking = new Sprite[]{
            new Sprite(new Texture("textures/enemies/bubble_city_0.png")),
            new Sprite(new Texture("textures/enemies/bubble_city_1.png")),
    };
    for(int i = 0; i < 2; i++){
        walking[i].setPosition(x, y);
    }
    this.hp = 5;
    this.damage = 10;
    this.speed = 3;
}
    public void draw(SpriteBatch batch, int frameCount) {
        for(int i = 0; i < walking.length; i ++){
            walking[i].setPosition(x0,y0);
            walking[i].setOrigin(8, 8);
            if(frameCount % 14 >= 0 && frameCount % 14 < 7) batch.draw(walking[0], x0, y0, width*MyGdxGame.scale, height*MyGdxGame.scale);
            if(frameCount % 14 >= 7 && frameCount % 14 < 14) batch.draw(walking[1], x0, y0, width*MyGdxGame.scale, height*MyGdxGame.scale);
            if (x0 - Hero.x > 0 && !wasTurned[i] || x0 - Hero.x < 0 && wasTurned[i]) {
                walking[i].flip(true, false);
                wasTurned[i] = !wasTurned[i];
            }
        }
//        EnemiesStorage.draw(batch);
        move();
    }

    public void move() {
        float x = Hero.x;
        float y = Hero.y;
        hypo = Math.pow((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y), 0.5);
        cosinus = (x0 - x) / hypo;
        sinus = (y0 - y) / hypo;
        if (hypo >= distanceHero) {
            x0 -= speed * cosinus;
            y0 -= speed * sinus;
        }
    }
    public boolean isAlive() {
        return true;
    }
    public void spawn(float x, float y) {
        EnemiesStorage.enemiesList.add(new Enemies(x, y));
    }
    public void setPosition(float x, float y){
        x0 = x;
        y0 = y;
    }
}


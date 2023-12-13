package com.mygdx.game.enemies;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;

import java.util.LinkedList;
import java.util.List;

public class Enemies {
    protected String title;
    protected String description;
    Sprite sprite;
    double hp;
    double damage;
    double speed;
    float x0 = 100, y0 = 100;
    float x, y;
    boolean wasTurned;
    double hypo;
    double sinus, cosinus;
    public static List<Enemies> enemiesList = new LinkedList<>();

    //Sprite texture, double damage, double hp, double speed, float x0, float y0
    public Enemies() {
        sprite = new Sprite(new Texture("textures/enemies/bubble_city_0.png"));
        sprite.setOrigin(8, 8);
        sprite.scale(MyGdxGame.scale);
        this.hp = 5;
        this.damage = 10;
        this.speed = 3;

    }

    public void draw(SpriteBatch batch) {
        sprite.setPosition(x0, y0);
        sprite.draw(batch);
        move();
        for (Enemies enemies1 : enemiesList) {
            if (!isAlive()) {
                enemiesList.remove(enemies1);
                break;
            }
        }
    }

    public void move() {
        x = Hero.x;
        y = Hero.y;
        if (x0 - x > 0 && wasTurned == false || x0 - x < 0 && wasTurned == true) {
            sprite.flip(true, false);
            wasTurned = !wasTurned;
        }
        hypo = Math.pow((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y), 0.5);
        cosinus = (x0 - x) / hypo;
        sinus = (y0 - y) / hypo;
        if(hypo >= 16 * MyGdxGame.scale) {
            x0 -= speed * cosinus;
            y0 -= speed * sinus;
        }
    }

    public boolean isAlive() {
        return true;
    }
}



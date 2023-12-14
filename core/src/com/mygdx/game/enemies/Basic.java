package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

public class Basic extends Enemies {
    public Basic(float x0, float y0) {
        super(x0, y0);
        title = "Обычный пузырь";
        description = "Средняя скорость, среднее хп, средний урон. Просто идет в рукопашку.";
        melee = true;
        distanceHero = 8*MyGdxGame.scale;
        walking = new Sprite[]{
                new Sprite(new Texture("textures/enemies/melee_city_0.png")),
                new Sprite(new Texture("textures/enemies/melee_city_1.png")),
        };
    }
}


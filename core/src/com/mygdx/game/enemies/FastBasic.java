package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

public class FastBasic extends Enemies {
    public FastBasic(float x0, float y0) {
        super(x0, y0);
        walking = new Sprite[]{
                new Sprite(new Texture("textures/enemies/sprinter_city_0.png")),
                new Sprite(new Texture("textures/enemies/sprinter_city_1.png")),
        };
        speed = 5;
        melee = true;
        distanceHero = 4* MyGdxGame.scale;
        title = "Быстрый пузырь";
        description = "Аналог обычного, но быстрее по скорости и слабее по хп и урону";
    }
}

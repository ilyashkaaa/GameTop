package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

public class TallBasic extends Enemies{
    public TallBasic(float x0, float y0) {
         super(x0, y0);
//        sprite = new Sprite(new Texture("textures/enemies/melee_city.png"));
        title = "Высокий пузырь";
        description = "Аналог обычного, только держится на расстоянии и стреляет";
        distanceHero = 64 * MyGdxGame.scale;
        melee = false;
        walking = new Sprite[]{
                new Sprite(new Texture("textures/enemies/melee_city_0.png")),
                new Sprite(new Texture("textures/enemies/melee_city_1.png")),
        };
    }

}

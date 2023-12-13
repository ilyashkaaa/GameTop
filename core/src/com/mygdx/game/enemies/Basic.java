package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

public class Basic extends Enemies {
    public Basic()  {
        super(MyGdxGame.SCR_WIDTH / 2,100);
        title = "Обычный пузырь";
        description = "Средняя скорость, среднее хп, средний урон. Просто идет в рукопашку.";
        walking = new Sprite[]{
                new Sprite(new Texture("textures/enemies/bubble_city_0.png")),
                new Sprite(new Texture("textures/enemies/bubble_city_1.png")),
        };
        for (int i = 0; i < walking.length; i++) {
            walking[i].setOrigin(8, 8);
            walking[i].scale(MyGdxGame.scale);
        }
    }
}

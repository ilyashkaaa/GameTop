package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Basic extends Enemies {
    public Basic() {
        title = "Обычный пузырь";
        description = "Средняя скорость, среднее хп, средний урон. Просто идет в рукопашку.";
        sprite = new Sprite(new Texture("textures/enemies/melee_city.png"));
    }

}

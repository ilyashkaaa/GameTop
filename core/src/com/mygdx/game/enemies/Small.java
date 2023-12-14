package com.mygdx.game.enemies;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utils.Bullet;

import java.util.LinkedList;
import java.util.List;

public class Small extends Enemies {

    public Small(float x0, float y0) {
        super(x0, y0);
        melee = true;
        title = "Мелкий пузырь";
        description = "Очень быстрая скорость, очень мало хп, средний урон. Пытается влететь в игрока и взорваться";
//        sprite = new Sprite(new Texture("textures/enemies/bubble_city.png"));
    }
}


package com.mygdx.game.enemies;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utils.Bullet;

import java.util.LinkedList;
import java.util.List;

public class Small extends Enemies {

    public Small() {
        title = "Мелкий пузырь";
        description = "Очень быстрая скорость, очень мало хп, средний урон. Пытается влететь в игрока и взорваться";
    }

}


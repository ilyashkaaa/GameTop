package com.mygdx.game.enemies;


public class Small extends Enemy {

    public Small(float x0, float y0) {
        super(x0, y0);
        melee = true;
        title = "Мелкий пузырь";
        description = "Очень быстрая скорость, очень мало хп, средний урон. Пытается влететь в игрока и взорваться";
//        sprite = new Sprite(new Texture("textures/enemies/bubble_city.png"));
    }
}


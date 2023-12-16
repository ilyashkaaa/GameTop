package com.mygdx.game.enemies;


import java.util.Random;

public class Small extends Enemy {
    Random random = new Random();

    public Small(float x0, float y0) {
        super(x0, y0);
        melee = true;
        small = true;
        damage = random.nextInt(6)+10;
        speed = 5;
        width = 16;
        height = 16;
        title = "Мелкий пузырь";
        description = "Очень быстрая скорость, очень мало хп, средний урон. Пытается влететь в игрока и взорваться";
//        sprite = new Sprite(new Texture("textures/enemies/bubble_city.png"));
    }
}


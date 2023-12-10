package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;

public class BasicBody extends Body{
    public BasicBody() {
        title = "Базовое тело";
        description = "Базовые характеристики";
        characteristics = "9оз ,100%урон ,10скорость";
        hp =9;
        damageMultiplier =1;
        speed=10;
        texture = new Texture("textures/player/body/body_blue.png");
    }
}

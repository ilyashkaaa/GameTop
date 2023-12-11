package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

public class BasicBody extends Body {
    public BasicBody() {
        title = "Базовое тело";
        description = "Базовые характеристики";
        characteristics = "9оз ,100% урон ,10 скорость";
        hp = 9;
        damageMultiplier = 1.0;
        speed = 10;
        rest = new Sprite(new Texture("textures/player/body/body_blue_0.png"));
        walking = new Sprite[]{
                new Sprite(new Texture("textures/player/body/body_blue_1.png")),
                new Sprite(new Texture("textures/player/body/body_blue_2.png"))
        };
        rest.setOrigin(8, 8);
        rest.scale(MyGdxGame.scale);
        for(int i = 0; i < walking.length; i ++){
            walking[i].setOrigin(8, 8);
            walking[i].scale(MyGdxGame.scale);
        }
    }
}

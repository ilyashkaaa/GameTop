package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Hero {
    Texture head;
    int speed = 5;
    float x = MyGdxGame.SCR_WIDTH / 2, y = MyGdxGame.SCR_HEIGHT / 2;

    public Hero() {
        head = new Texture("textures/player/head/head_blue.png");
    }

    public void draw(SpriteBatch batch) {
        batch.draw(head, x, y, 120, 120);
    }

    public void move(double deltaX, double deltaY) {
        x += deltaX * speed;
        y += deltaY * speed;
    }
}

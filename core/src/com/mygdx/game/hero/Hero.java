package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Hero {
    Head head;
    Body body;
    int speed = 5;
    float x = (float) MyGdxGame.SCR_WIDTH / 2;
    float y = (float) MyGdxGame.SCR_HEIGHT / 2;

    public Hero(){
        head = new Head();
        body = new BasicBody();
    }
    public void draw(SpriteBatch batch, int frameCount){
        body.draw(batch, x, y);
        head.draw(batch, x, y + 10 * MyGdxGame.scale + 0.5f * MyGdxGame.scale * (frameCount % 80 / 40));
    }
    public void move(double deltaX, double deltaY){
        x += deltaX * speed;
        y += deltaY * speed;
    }
}

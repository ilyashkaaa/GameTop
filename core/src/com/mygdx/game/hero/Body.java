package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Body {
    protected String title;
    protected String description;
    protected String characteristics;
    int speed;
    double damageMultiplier;
    int hp;
    Sprite rest;
    Sprite[] walking;
    public void draw(SpriteBatch batch, float x, float y, int frameCount, boolean isMoving){
        if(!isMoving) batch.draw(rest, x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale);
        else {
            if (frameCount % 30 >= 0 && frameCount % 30 < 7) batch.draw(walking[0], x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale);
            else if((frameCount % 30 >= 7 && frameCount % 30 < 15) || (frameCount % 30 >= 22 && frameCount % 30 < 30)) batch.draw(rest, x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale);
            else if(frameCount % 30 >= 15 && frameCount % 30 < 22) batch.draw(walking[1], x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale);
        }
    }
    public void flip(){
        rest.flip(true,false);
        for(int i = 0; i < walking.length; i++) walking[i].flip(true, false);
    }
}

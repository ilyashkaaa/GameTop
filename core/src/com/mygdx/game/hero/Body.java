package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.Weapon;

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
        rest.setPosition(x, y);
        for(int i = 0; i < walking.length; i ++){
            walking[i].setPosition(x,y);
        }
        if(!isMoving) rest.draw(batch);
        else {
            if (frameCount % 30 >= 0 && frameCount % 30 < 7) walking[0].draw(batch);
            else if((frameCount % 30 >= 7 && frameCount % 30 < 15) || (frameCount % 30 >= 22 && frameCount % 30 < 30)) rest.draw(batch);
            else if(frameCount % 30 >= 15 && frameCount % 30 < 22) walking[1].draw(batch);
        }
    }
    public void flip(){
        rest.flip(true,false);
        for(int i = 0; i < walking.length; i++) {
            walking[i].flip(true, false);
        }
    }
}

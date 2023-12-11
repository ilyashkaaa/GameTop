package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Head {
    Sprite head;
    Head(){
        head = new Sprite(new Texture("textures/player/head/head_blue_0.png"));
        head.setOrigin(8, 8);
        head.scale(MyGdxGame.scale);
    }
    public void draw(SpriteBatch batch, float x, float y){
        head.setPosition(x, y);
        head.draw(batch);
    }
    public void flip(){
        head.flip(true,false);
    }
}

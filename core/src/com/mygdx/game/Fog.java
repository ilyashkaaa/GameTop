package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.TextArea;
import java.time.temporal.Temporal;

public class Fog {
    int fogSpeed = 1;
    int x;
    Sprite fogTexture;
    Fog(){
        fogTexture = new Sprite( new Texture("textures/locations/1_city/fog.png"));
        fogTexture.scale(1);
        fogTexture.setColor(1, 1,1, 0.5f);
    }
    public void draw(SpriteBatch batch, float cx, float cy){
        fogTexture.setPosition(x + cx, cy);
        fogTexture.draw(batch);
        fogTexture.flip(true, false);
        fogTexture.setPosition(x + fogTexture.getWidth() * 2 + cx, cy);
        fogTexture.draw(batch);
        fogTexture.flip(true, false);
    }
    public void move(){
        x -= fogSpeed;
        if(x <= -MyGdxGame.SCR_WIDTH) x = 0;
    }
}

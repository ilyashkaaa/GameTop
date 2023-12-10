package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Head {
    Texture head;
    Head(){
        head = new Texture("textures/player/head/head_blue.png");
    }
    public void draw(SpriteBatch batch, float x, float y){
        batch.draw(head, x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale);
    }
}

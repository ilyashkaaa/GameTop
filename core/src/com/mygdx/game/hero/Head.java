package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Head {
    Sprite head0;
    Sprite head1;
    Sprite head2;
    Head(){
        head0 = new Sprite(new Texture("textures/player/head/head_blue_0.png"));
        head0.setOrigin(8, 8);
        head0.scale(MyGdxGame.scale);
        head1 = new Sprite(new Texture("textures/player/head/head_blue_1.png"));
        head1.setOrigin(8, 8);
        head1.scale(MyGdxGame.scale);
        head2 = new Sprite(new Texture("textures/player/head/head_blue_2.png"));
        head2.setOrigin(8, 8);
        head2.scale(MyGdxGame.scale);
    }
    public void draw(SpriteBatch batch, float x, float y, int frameCount){
        if(frameCount % 100 >= 0 && frameCount % 100 <= 5){
            head2.setPosition(x, y + 12 * MyGdxGame.scale + 0.5f * MyGdxGame.scale * (frameCount % 80 / 40));
            head2.draw(batch);
        }
        else if((frameCount / 8) % 2 == 0) {
            head0.setPosition(x, y + 12 * MyGdxGame.scale + 0.5f * MyGdxGame.scale * (frameCount % 80 / 40));
            head0.draw(batch);
        }
        else{
            head1.setPosition(x, y + 12 * MyGdxGame.scale + 0.5f * MyGdxGame.scale * (frameCount % 80 / 40));
            head1.draw(batch);
        }
    }
    public void flip(){
        head0.flip(true,false);
        head1.flip(true,false);
        head2.flip(true,false);
    }
}

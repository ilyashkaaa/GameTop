package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.TextArea;
import java.time.temporal.Temporal;

public class Fog {
    int fogSpeed = 2;
    int x;
    Sprite fogTexture;

    Fog() {
        fogTexture = new Sprite(new Texture("textures/locations/1_city/fog.png"));
        fogTexture.scale(1);
        fogTexture.setColor(1, 1, 1, 0.5f);
    }

    public void draw(SpriteBatch batch, float cx, float cy) {
        fogTexture.setPosition(x + cx + fogTexture.getWidth() / 2 - MyGdxGame.SCR_WIDTH / 2, cy - fogTexture.getHeight() / 2);
        fogTexture.draw(batch);
        fogTexture.flip(true, false);
        fogTexture.setPosition(x + cx + fogTexture.getWidth() * 1.5f - MyGdxGame.SCR_WIDTH / 2, cy - fogTexture.getHeight() / 2);
        fogTexture.draw(batch);
        fogTexture.flip(true, false);
    }

    public void move(float cx) {
        x -= fogSpeed;
        if (x <= 0 - fogTexture.getWidth() * 1f) {
            x = 0;
//            fogTexture.flip(true, false);
        }
    }
}

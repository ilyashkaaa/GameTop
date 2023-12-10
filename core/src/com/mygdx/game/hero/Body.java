package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Body {
    protected String title;
    protected String description;
    protected String characteristics;
    int speed;
    double damageMultiplier;
    int hp;
    Texture texture;
    public void draw(SpriteBatch batch, float x, float y){
        batch.draw(texture, x, y, 16 * MyGdxGame.scale, 16 * MyGdxGame.scale, (int) x, (int) y, (int) (16 * MyGdxGame.scale), (int) (16 * MyGdxGame.scale), true, false);
    }
}

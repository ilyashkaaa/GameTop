package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Joystick {
    Texture texture;
    int width = 500, height = 500;
    int x = (MyGdxGame.SCR_WIDTH - width) / 2, y = (MyGdxGame.SCR_HEIGHT - height) / 2;

    Joystick() {
        texture = new Texture("joystik/circle.png");
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }
    private double calculateHypotinase(int tapX, int tapY){
        return Math.pow((Math.pow(tapX - MyGdxGame.SCR_WIDTH / 2, 2) + Math.pow(tapY - MyGdxGame.SCR_HEIGHT / 2, 2)), 0.5);
    }
    public double getX(){
        int tapX = Gdx.input.getX();
        int tapY = Gdx.input.getY();
        return (tapX - MyGdxGame.SCR_WIDTH / 2) / calculateHypotinase(tapX, tapY);
    }
    public double getY(){
        int tapX = Gdx.input.getX();
        int tapY = Gdx.input.getY();
        return (tapY - MyGdxGame.SCR_HEIGHT / 2) / calculateHypotinase(tapX, tapY);
    }
}

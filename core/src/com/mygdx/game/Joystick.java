package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Joystick {
    Texture texture;
    int width = 500, height = 500;
    int x = MyGdxGame.SCR_WIDTH / 2, y = MyGdxGame.SCR_HEIGHT / 2;

    Joystick() {
        texture = new Texture("joystik/circle.png");
    }
    public void changeXY(int jx, int jy){
        x = jx;
        y = jy;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - width / 2, y - height / 2, width, height);
    }
    private double calculateHypotinase(int tapX, int tapY){
        return Math.pow((Math.pow(tapX - x, 2) + Math.pow(tapY - y, 2)), 0.5) + 1;
    }
    public double getX(){
        int tapX = Gdx.input.getX();
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY();
        return (tapX - x) / calculateHypotinase(tapX, tapY);
    }
    public double getY(){
        int tapX = Gdx.input.getX();
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY();
        return (tapY - y) / calculateHypotinase(tapX, tapY);
    }
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Joystick {
    Texture circle;
    Texture filledCircle;
    int width = 500, height = 500;
    int x = MyGdxGame.SCR_WIDTH / 2, y = MyGdxGame.SCR_HEIGHT / 2;

    Joystick() {
        circle = new Texture("joystik/circle.png");
        filledCircle = new Texture("joystik/filled_circle.png");
    }
    public void changeXY(int jx, int jy){
        x = jx;
        y = jy;
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
    public void draw(SpriteBatch batch) {
        batch.draw(circle, x - width / 2, y - height / 2, width, height);
        int tapX = Gdx.input.getX();
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY();
        if (calculateHypotinase(tapX, tapY) <= 250 - width / 6)
            batch.draw(filledCircle, Gdx.input.getX() - width / 8, MyGdxGame.SCR_HEIGHT - Gdx.input.getY() - height / 8, width / 4, height / 4);
        else batch.draw(filledCircle, (float)getX() * width / 2 + x - width / 8 - width / 6 * (float)getX(), (float)getY() * height / 2 + y - height / 8 - height / 6 * (float)getY(), width / 4, height / 4);
    }
}

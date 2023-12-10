package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.hero.Hero;

import java.util.logging.Handler;

public class ScreenGame implements Screen {
    BitmapFont bitmapFont;
    Joystick joystick;
    Hero hero;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);

        joystick = new Joystick();
        hero = new Hero();

        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        frameCount++;
        myGdxGame.camera.update();

        ScreenUtils.clear(0.65f, 0.49f, 0.22f, 0.5f);

        myGdxGame.batch.begin();

        hero.draw(myGdxGame.batch, frameCount);
//        bitmapFont.draw(myGdxGame.batch, " " + joystick.getY(), MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);
        if(Gdx.input.justTouched()){
            joystick.changeXY(Gdx.input.getX(),MyGdxGame.SCR_HEIGHT - Gdx.input.getY());
        }
        else if(Gdx.input.isTouched()){
            if(keepTouching) joystick.draw(myGdxGame.batch) ;
            hero.move(joystick.getX(), joystick.getY());
            keepTouching = true;
        }else keepTouching = false;


        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

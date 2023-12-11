package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;

import java.util.logging.Handler;

public class ScreenGame implements Screen {
    BitmapFont bitmapFont;
    Joystick joystick;
    Hero hero;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
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
        BulletStorage.draw(myGdxGame.batch);

//        bitmapFont.draw(myGdxGame.batch, Gdx.input.getX(indexNotJoystic(countOfTouching())) + " " + lastFinger, MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);

        if (Gdx.input.isTouched(indexJoystick(countOfTouching())) && Gdx.input.getX(indexJoystick(countOfTouching())) <= MyGdxGame.SCR_WIDTH / 2){
            if(keepTouching) joystick.draw(myGdxGame.batch, indexJoystick(countOfTouching()));
            else joystick.changeXY(Gdx.input.getX(indexJoystick(countOfTouching())),MyGdxGame.SCR_HEIGHT - Gdx.input.getY(indexJoystick(countOfTouching())));
            hero.move(joystick.getX(indexJoystick(countOfTouching())), joystick.getY(indexJoystick(countOfTouching())));
            keepTouching = true;
        }else{
            keepTouching = false;
        }
        if (Gdx.input.isTouched(indexNotJoystic(countOfTouching())) && Gdx.input.getX(indexNotJoystic(countOfTouching())) > MyGdxGame.SCR_WIDTH / 2) lastFinger++;
        hero.draw(myGdxGame.batch, frameCount, keepTouching);


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
    private int countOfTouching(){
        int i = 0;
        while (i < Gdx.input.getMaxPointers()){
            i++;
            if(Gdx.input.getPressure(i) == 0) break;
        }
        return i - 1;
    }
    private int indexJoystick(int countOfTouching){
        int returned = 0;
        for (int i = 0; i < countOfTouching + 1; i++){
            if(Gdx.input.getX(i) <= MyGdxGame.SCR_WIDTH / 2){
                returned = i;
                break;
            }
        }
        return returned;
    }
    private int indexNotJoystic(int countOfTouching){
        int returned = 0;
        for (int i = 0; i < countOfTouching + 1; i++){
            if(Gdx.input.getX(i) > MyGdxGame.SCR_WIDTH / 2){
                returned = i;
                break;
            }
        }
        return returned;
    }
}

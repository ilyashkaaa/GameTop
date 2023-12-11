package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;

import control.FireButton;
import control.Joystick;

public class ScreenGame implements Screen {
    BitmapFont bitmapFont;
    Joystick joystick;
    Hero hero;
    FireButton fireButton1;
    FireButton fireButton2;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
    double lastCos, lastSyn;
    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);

        joystick = new Joystick();
        hero = new Hero();
        fireButton1 = new FireButton(MyGdxGame.SCR_WIDTH - FireButton.widht / 2 - 50, MyGdxGame.SCR_HEIGHT / 2);
        fireButton2 = new FireButton(MyGdxGame.SCR_WIDTH - FireButton.widht * 2 + 50, MyGdxGame.SCR_HEIGHT / 3);

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

        if (Gdx.input.isTouched(indexJoystick(countOfTouching())) && Gdx.input.getX(indexJoystick(countOfTouching())) <= MyGdxGame.SCR_WIDTH / 2){
            if(keepTouching) joystick.draw(myGdxGame.batch, indexJoystick(countOfTouching()));
            else joystick.changeXY(Gdx.input.getX(indexJoystick(countOfTouching())),MyGdxGame.SCR_HEIGHT - Gdx.input.getY(indexJoystick(countOfTouching())));
            hero.move(joystick.getX(indexJoystick(countOfTouching())), joystick.getY(indexJoystick(countOfTouching())));
            lastCos = joystick.getX(indexJoystick(countOfTouching()));
            lastSyn = joystick.getY(indexJoystick(countOfTouching()));
            keepTouching = true;
        }else{
            keepTouching = false;
        }
        hero.draw(myGdxGame.batch, frameCount, keepTouching);

        for( int i = 0; i < countOfTouching() + 1; i++){
            if((fireButton1.isTouched(Gdx.input.getX(i),MyGdxGame.SCR_HEIGHT - Gdx.input.getY(i), i) && (Gdx.input.getX(i) > MyGdxGame.SCR_WIDTH / 2) && (lastSyn != 0 || lastCos != 0))) hero.shoot(lastCos, lastSyn);
        }

        bitmapFont.draw(myGdxGame.batch, " " + joystick.getX(indexJoystick(countOfTouching())), MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);

        fireButton1.draw(myGdxGame.batch);
        fireButton2.draw(myGdxGame.batch);
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
//    public void servayButtons(){
//        for (int i = 0; i < countOfTouching + 1; i++){
//            if(Gdx.input.getX(i) > MyGdxGame.SCR_WIDTH / 2){
//                break;
//            }
//    }
}
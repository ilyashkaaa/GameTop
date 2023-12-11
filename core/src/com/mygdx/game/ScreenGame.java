package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.enemies.Enemies;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.BulletStorage;

import control.Button;
import control.Joystick;

public class ScreenGame implements Screen {
    BitmapFont bitmapFont;
    Joystick joystick;
    Enemies enemie;
    Hero hero;
    Button fireButton1;
    Button fireButton2;
    ShapeRenderer shapeRenderer;
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
        enemie = new Enemies();
        shapeRenderer = new ShapeRenderer();
        hero = new Hero();
        fireButton1 = new Button(MyGdxGame.SCR_WIDTH - Button.widht / 2 - 50, MyGdxGame.SCR_HEIGHT / 2);
        fireButton2 = new Button(MyGdxGame.SCR_WIDTH - Button.widht * 2 + 50, MyGdxGame.SCR_HEIGHT / 3);

        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        frameCount++;
        lastFinger+=150;
        myGdxGame.camera.position.set(Hero.x, Hero.y, 0);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
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
        hero.draw(myGdxGame.batch, frameCount, keepTouching, lastCos, lastSyn);
        enemie.draw(myGdxGame.batch);
        if(buttonHandler(fireButton1)) hero.shoot(lastCos, lastSyn, false);
        if(buttonHandler(fireButton2)) hero.shoot(lastCos, lastSyn, true);

//        bitmapFont.draw(myGdxGame.batch, " " + joystick.getX(indexJoystick(countOfTouching())), MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);

        fireButton1.draw(myGdxGame.batch);
        fireButton2.draw(myGdxGame.batch);
        myGdxGame.batch.end();

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.rect(25, 25, 50, 50);
//        shapeRenderer.end();
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
    public boolean buttonHandler(Button button){
        for( int i = 0; i < countOfTouching() + 1; i++){
            if((button.isTouched(Gdx.input.getX(i),MyGdxGame.SCR_HEIGHT - Gdx.input.getY(i), i) && (Gdx.input.getX(i) > MyGdxGame.SCR_WIDTH / 2) && (lastSyn != 0 || lastCos != 0)))    return true;
        }
        return false;
    }
}
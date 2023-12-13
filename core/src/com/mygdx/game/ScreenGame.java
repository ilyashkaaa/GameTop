package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.enemies.Enemies;
import com.mygdx.game.enemies.EnemiesStorage;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.locations.City;
import com.mygdx.game.locations.CityRoom;
import com.mygdx.game.utils.BulletStorage;

import control.Button;
import control.Continue;
import control.Joystick;
import control.Pause;

public class ScreenGame implements Screen {
    BitmapFont bitmapFont;
    Joystick joystick;
    Hero hero;
    Button fireButton1;
    Button fireButton2;
    Pause pausedButton;
    Continue continueButton;
    ShapeRenderer shapeRenderer;
    City city;
    //CityRoom cityRoom;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
    double lastCos, lastSyn;
    boolean paused = false;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);
        joystick = new Joystick();
        shapeRenderer = new ShapeRenderer();
        hero = new Hero();
        fireButton1 = new Button(MyGdxGame.SCR_WIDTH - Button.widht / 2 - 75, MyGdxGame.SCR_HEIGHT / 2 - 25);
        fireButton2 = new Button(MyGdxGame.SCR_WIDTH - Button.widht * 2 + 25, Button.height / 2 + 75);
        pausedButton = new Pause(0, (float) (MyGdxGame.SCR_HEIGHT - Pause.height * 20));
        continueButton = new Continue(MyGdxGame.SCR_WIDTH-Continue.widht*20, (float) (MyGdxGame.SCR_HEIGHT - Continue.height * 20));

        //cityRoom = new CityRoom();
       city = new City();

        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.camera.update();
        for (int i = 0; i < 3; i++){
            EnemiesStorage.enemiesList.add(new Enemies(MyGdxGame.SCR_WIDTH / 4, 100 * i));
        }
    }

    @Override
    public void show() {

    }

    @SuppressWarnings("SuspiciousIndentation")
    @Override
    public void render(float delta) {
        myGdxGame.batch.begin();
        if (paused) {
            ScreenUtils.clear(0.65f, 0.49f, 0.22f, 0.5f);
            continueButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);

            if (continueButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY())) {
                paused = false;
            }
        } else {
            frameCount++;
            ScreenUtils.clear(0.65f, 0.49f, 0.22f, 0.5f);
            city.draw(myGdxGame.batch);
            BulletStorage.draw(myGdxGame.batch);
            moveCamera();
            EnemiesStorage.draw(myGdxGame.batch, frameCount);
            if (Gdx.input.isTouched(indexJoystick(countOfTouching())) && Gdx.input.getX(indexJoystick(countOfTouching())) <= MyGdxGame.SCR_WIDTH / 2) {
                if (keepTouching)
                    joystick.draw(myGdxGame.batch, indexJoystick(countOfTouching()), myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                else
                    joystick.changeXY(Gdx.input.getX(indexJoystick(countOfTouching())), (MyGdxGame.SCR_HEIGHT - Gdx.input.getY(indexJoystick(countOfTouching()))));
                hero.move(joystick.getX(indexJoystick(countOfTouching())), joystick.getY(indexJoystick(countOfTouching())));
                if (joystick.getX(indexJoystick(countOfTouching())) != 0 && joystick.getY(indexJoystick(countOfTouching())) != 0) {
                    lastCos = joystick.getX(indexJoystick(countOfTouching()));
                    lastSyn = joystick.getY(indexJoystick(countOfTouching()));
                }
                keepTouching = true;
            } else keepTouching = false;

//            if (pausedClick()) {
//                paused = true;
//            }

        hero.draw(myGdxGame.batch, frameCount, keepTouching, lastCos, lastSyn);
        //enemy.draw(myGdxGame.batch);
        if (buttonHandler(fireButton1)) hero.shoot(lastCos, lastSyn, false);
        if (buttonHandler(fireButton2)) hero.shoot(lastCos, lastSyn, true);

//        bitmapFont.draw(myGdxGame.batch, " " + joystick.getX(indexJoystick(countOfTouching())), MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);

            fireButton1.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
            fireButton2.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
            pausedButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.rect(25, 25, 50, 50);
//        shapeRenderer.end();
        }
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

    private int countOfTouching() {
        int i = 0;
        while (i < Gdx.input.getMaxPointers()) {
            i++;
            if (Gdx.input.getPressure(i) == 0) break;
        }
        return i - 1;
    }

    private int indexJoystick(int countOfTouching) {
        int returned = 0;
        for (int i = 0; i < countOfTouching + 1; i++) {
            if (Gdx.input.getX(i) <= MyGdxGame.SCR_WIDTH / 2) {
                returned = i;
                break;
            }
        }
        return returned;
    }


    public boolean buttonHandler(Button button) {
        for (int i = 0; i < countOfTouching() + 1; i++) {
            if ((button.isTouched(Gdx.input.getX(i), MyGdxGame.SCR_HEIGHT - Gdx.input.getY(i), i) && (Gdx.input.getX(i) > MyGdxGame.SCR_WIDTH / 2) && (lastSyn != 0 || lastCos != 0)))
                return true;
            if (pausedButton.isTouched(Gdx.input.getX(i), MyGdxGame.SCR_HEIGHT - Gdx.input.getY(i))) {
                paused = true;
            }
            if (continueButton.isTouched(Gdx.input.getX(i), MyGdxGame.SCR_HEIGHT - Gdx.input.getY(i))) {
                paused = false;
            }
        }
        return false;
    }

    public boolean pausedClick() {
        if (pausedButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY())) {
            return true;
        } else {
            return false;
        }
    }
    private void moveCamera(){
        double x = myGdxGame.camera.position.x - (myGdxGame.camera.position.x - Hero.x) / 16;
        double y = myGdxGame.camera.position.y - (myGdxGame.camera.position.y - Hero.y) / 16;
        myGdxGame.camera.position.set((float) x, (float) y, 0);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
    }
}
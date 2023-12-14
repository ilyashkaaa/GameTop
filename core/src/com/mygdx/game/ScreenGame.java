package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.enemies.Basic;
import com.mygdx.game.enemies.EnemiesBullets;
import com.mygdx.game.enemies.EnemiesStorage;
import com.mygdx.game.enemies.FastBasic;
import com.mygdx.game.enemies.Small;
import com.mygdx.game.enemies.TallBasic;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.items.weapon.Gun;
import com.mygdx.game.items.weapon.Weapon;
import com.mygdx.game.locations.City;
import com.mygdx.game.utils.BulletStorage;

import java.util.Random;

import control.Button;
import control.Continue;
import control.Inventory;
import control.Joystick;
import control.Pause;

public class ScreenGame implements Screen {
    Random random;
    BitmapFont bitmapFont;
    Joystick joystick;
    Hero hero;
    Button fireButton1;
    Button fireButton2;
    Pause pausedButton;
    Continue continueButton;
    Inventory inventory;
    ShapeRenderer shapeRenderer;
    City city;
    //CityRoom cityRoom;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
    double lastCos, lastSyn;
    boolean paused = false;
    int numberOfMonsters, maxMonsters = 10, form;
    float x0, y0;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);
        joystick = new Joystick();
        shapeRenderer = new ShapeRenderer();
        hero = new Hero();
        inventory = new Inventory();
        random = new Random();
        fireButton1 = new Button(MyGdxGame.SCR_WIDTH - Button.widht / 2 - 75, MyGdxGame.SCR_HEIGHT / 2 - 25);
        fireButton2 = new Button(MyGdxGame.SCR_WIDTH - Button.widht * 2 + 25, Button.height / 2 + 75);
        pausedButton = new Pause(MyGdxGame.SCR_WIDTH / 2 + myGdxGame.camera.position.x - Pause.widht * 15, MyGdxGame.SCR_HEIGHT / 2 + myGdxGame.camera.position.y - Pause.height * 20);
        continueButton = new Continue();
        //cityRoom = new CityRoom();
        city = new City();

        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.camera.update();
        spawnMonsters();
        //     for (int i = 0; i < 3; i++) {
        //       EnemiesStorage.enemiesList.add(new Enemies(MyGdxGame.SCR_WIDTH / 4, 100 * i));
        // }
    }

    @Override
    public void show() {

    }

    @SuppressWarnings("SuspiciousIndentation")
    @Override
    public void render(float delta) {
        myGdxGame.batch.begin();

        if (paused) {
            ScreenUtils.clear(0.6f, 0.6f, 0.6f, 1);
            continueButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
            inventory.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);


            if (continueButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY())) {
                paused = false;
            }
        } else {
            frameCount++;
            ScreenUtils.clear(0.32f, 0.5f, 0.66f, 0.5f);
            city.draw(myGdxGame.batch);
            BulletStorage.draw(myGdxGame.batch);
            EnemiesBullets.draw(myGdxGame.batch);
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

            bitmapFont.draw(myGdxGame.batch, " " + Hero.hp, MyGdxGame.SCR_WIDTH / 30, MyGdxGame.SCR_HEIGHT / 20 * 19);

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

    private void moveCamera() {
        double x = myGdxGame.camera.position.x - (myGdxGame.camera.position.x - Hero.x) / 16;
        double y = myGdxGame.camera.position.y - (myGdxGame.camera.position.y - Hero.y) / 16;
        myGdxGame.camera.position.set((float) x, (float) y, 0);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
    }

    public void spawnMonsters() {
        numberOfMonsters = random.nextInt(maxMonsters) + 1;
        for (int i = 0; i < numberOfMonsters; i++) {
            form = random.nextInt(4) + 1;
            x0 = random.nextInt(609) + 16 * MyGdxGame.scale;
            y0 = random.nextInt(609) + 16 * MyGdxGame.scale;
            switch (form) {
                case 1:
                    EnemiesStorage.enemiesList.add(new Basic(x0, y0));
                    break;
                case 2:
                    EnemiesStorage.enemiesList.add(new Small(x0, y0));
                    break;
                case 3:
                    EnemiesStorage.enemiesList.add(new FastBasic(x0, y0));
                    break;
                //              case 4:
                //                  EnemiesStorage.enemiesList.add(new Big(x0, y0));
                //                  break;
                            case 4:
                               EnemiesStorage.enemiesList.add(new TallBasic(x0, y0));
                            break;
                default:
                    System.out.println("default");
            }
        }
    }
}
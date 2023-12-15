package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
import com.mygdx.game.locations.City;
import com.mygdx.game.locations.Room;
import com.mygdx.game.utils.Bullet;
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
    Button restartButton;
    Pause pausedButton;
    Continue continueButton;
    Inventory inventory;
    ShapeRenderer shapeRenderer;
    City city;
    Texture startScreen;
    //CityRoom cityRoom;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
    double lastCos, lastSyn;
    boolean paused = false;
    int numberOfMonsters, maxMonsters = 10, form;
    boolean isStarted = false;
    float x0, y0;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        startScreen = new Texture("textures/gui/splash.png");
        bitmapFont = new BitmapFont(Gdx.files.internal("font/font.fnt"));
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);
        joystick = new Joystick();
        shapeRenderer = new ShapeRenderer();
        hero = new Hero();
        inventory = new Inventory();
        random = new Random();
        Hero.gunRandom();
        fireButton1 = new Button(MyGdxGame.SCR_WIDTH - Button.widht / 2 - 75, MyGdxGame.SCR_HEIGHT / 2 - 25);
        fireButton2 = new Button(MyGdxGame.SCR_WIDTH - Button.widht * 2 + 25, Button.height / 2 + 75);
        restartButton = new Button(MyGdxGame.SCR_WIDTH / 2, MyGdxGame.SCR_HEIGHT / 2 - 125);
        pausedButton = new Pause(MyGdxGame.SCR_WIDTH / 2 + myGdxGame.camera.position.x - Pause.widht * 15, MyGdxGame.SCR_HEIGHT / 2 + myGdxGame.camera.position.y - Pause.height * 20);
        continueButton = new Continue();
        //cityRoom = new CityRoom();
        city = new City();

        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.camera.update();


    }

    @Override
    public void show() {

    }

    @SuppressWarnings("SuspiciousIndentation")
    @Override
    public void render(float delta) {
        myGdxGame.batch.begin();
        if(!isStarted){
            myGdxGame.batch.draw(startScreen, 0, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
            if(Gdx.input.justTouched()) isStarted = true;
        }
        else{
            if(Hero.hp <= 0){
                ScreenUtils.clear(0.6f, 0.6f, 0.6f, 1);
                bitmapFont.draw(myGdxGame.batch, "You Lose!" + "\n" + "Loser", myGdxGame.camera.position.x - 250, myGdxGame.camera.position.y + 250, 500, 1, false);
                restartButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y - 125);
                if(restartButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY(), 0)){
                    Hero.hp = 100;
                    hero.changePosition(-Hero.x, -Hero.y);
                    myGdxGame.camera.position.set(0, 0, 0);
                    Room.rooms.clear();
                    city = new City();
                    EnemiesStorage.enemyList.clear();
                    BulletStorage.bullets.clear();
                    EnemiesBullets.bullets.clear();
                }
            }else {
                if (paused) {
                    ScreenUtils.clear(0.6f, 0.6f, 0.6f, 1);
                    continueButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    inventory.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);



                    if (continueButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY())) {
                        paused = false;
                    }
                } else {
                    frameCount++;
                    ScreenUtils.clear(0.40625f, 0.5f, 0.515625f, 0.5f);
                    moveCamera();
                    city.draw(myGdxGame.batch, 0);

                    EnemiesStorage.draw(myGdxGame.batch, frameCount);
                    EnemiesBullets.draw(myGdxGame.batch);
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
                    BulletStorage.draw(myGdxGame.batch);
                    city.draw(myGdxGame.batch, 1);
                    city.checkHeroColision();

                    //enemy.draw(myGdxGame.batch);
                    if (buttonHandler(fireButton1)) hero.shoot(lastCos, lastSyn, false);
                    if (buttonHandler(fireButton2)) hero.shoot(lastCos, lastSyn, true);

//            bitmapFont.draw(myGdxGame.batch, " " + EnemiesStorage.enemyList.size(), myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    if (city.isActivate()) {
                        spawnMonsters(Room.rooms.get(City.lastRoom).x, Room.rooms.get(City.lastRoom).y);
                    }

                    fireButton1.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    fireButton2.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    pausedButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.rect(25, 25, 50, 50);
//        shapeRenderer.end();
                }
            }
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

    public void spawnMonsters(float roomX, float roomY) {
        //numberOfMonsters = random.nextInt(maxMonsters) + 1;
        numberOfMonsters = 30;
        for (int i = 0; i < numberOfMonsters; i++) {
            form = random.nextInt(4) + 1;
            x0 = random.nextInt(600 * 4) + 16 * MyGdxGame.scale + roomX;
            y0 = random.nextInt(600 * 4) + 16 * MyGdxGame.scale + roomY;
            switch (form) {
                case 1:
                    EnemiesStorage.enemyList.add(new Basic(x0, y0));
                    break;
                case 2:
                    EnemiesStorage.enemyList.add(new Small(x0, y0));
                    break;
                case 3:
                    EnemiesStorage.enemyList.add(new FastBasic(x0, y0));
                    break;
                case 4:
                    EnemiesStorage.enemyList.add(new TallBasic(x0, y0));
                    break;
                default:
                    System.out.println("default");
            }
        }
    }
}
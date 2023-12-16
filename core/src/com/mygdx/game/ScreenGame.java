package com.mygdx.game;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.enemies.Basic;
import com.mygdx.game.enemies.EnemiesBullets;
import com.mygdx.game.enemies.EnemiesStorage;
import com.mygdx.game.enemies.Enemy;
import com.mygdx.game.enemies.FastBasic;
import com.mygdx.game.enemies.Small;
import com.mygdx.game.enemies.TallBasic;
import com.mygdx.game.hero.Hero;
import com.mygdx.game.items.artefacts.Artefacts;
import com.mygdx.game.items.artefacts.Brush;
import com.mygdx.game.items.artefacts.Crane;
import com.mygdx.game.items.artefacts.DemonHorn;
import com.mygdx.game.items.artefacts.Dice;
import com.mygdx.game.items.artefacts.ElectromagneticCoil;
import com.mygdx.game.items.artefacts.Glitch;
import com.mygdx.game.items.artefacts.NitrogenCylinder;
import com.mygdx.game.items.artefacts.Scaner3D;
//import com.mygdx.game.items.artefacts.portableNuclearReactor;
import com.mygdx.game.items.weapon.BasicLaser;
import com.mygdx.game.items.weapon.CyberBow;
import com.mygdx.game.items.weapon.DoomShotgun;
import com.mygdx.game.items.weapon.GasRifle;
import com.mygdx.game.items.weapon.Gun;
import com.mygdx.game.items.weapon.Ledashnikov;
import com.mygdx.game.items.weapon.RailGun;
import com.mygdx.game.items.weapon.StarRifle;
import com.mygdx.game.locations.City;
import com.mygdx.game.locations.CityRoom;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.locations.Room;
import com.mygdx.game.utils.Bullet;
import com.mygdx.game.utils.BulletStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import control.Button;
import control.Continue;
import control.Inventory;
import control.Joystick;
import control.Pause;

public class ScreenGame implements Screen {
    Random random;
    public static int score;
    Artefacts artefact;
    Gun newGun;
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
    Texture heart;
    Texture newGunTexture;
    Texture gameOver;
    Fog fog;
    Audio audio = Gdx.audio;
    Music music = audio.newMusic(Gdx.files.internal("music/defalt.mp3"));
    Music menuMusic = audio.newMusic(Gdx.files.internal("music/menu.mp3"));
    Music deathMusic = audio.newMusic(Gdx.files.internal("music/death.mp3"));
    //CityRoom cityRoom;
    boolean keepTouching;
    private final MyGdxGame myGdxGame;
    int frameCount;
    int lastFinger;
    double lastCos, lastSyn;
    boolean paused = false;
    int numberOfMonsters, maxMonsters = 36, form;
    boolean isStarted = false;
    public static List<Artefacts> artefacts = new LinkedList<>();
    float x0, y0;
    int count = 1;
    boolean drawNewGun = false;
    long time;
    long timeTimer;
    boolean canMinus;
    long restartTimer;
    boolean justOneceGenerate;
    List<Gun> spawnGuns = new ArrayList<>();
    int[] gunRoomIndex = new int[100];

    ScreenGame(MyGdxGame myGdxGame) {
        music.setLooping(true);
        menuMusic.setLooping(true);
        deathMusic.setLooping(true);
        this.myGdxGame = myGdxGame;
        startScreen = new Texture("textures/gui/splash.png");
        heart = new Texture("textures/gui/hp.png");
        gameOver = new Texture("textures/gui/game_over.png");
        bitmapFont = new BitmapFont(Gdx.files.internal("font/font.fnt"));
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);
        joystick = new Joystick();
        shapeRenderer = new ShapeRenderer();
        hero = new Hero();
        inventory = new Inventory();
        random = new Random();
        fog = new Fog();
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
        if (!isStarted) {
            menuMusic.play();
            myGdxGame.batch.draw(startScreen, 0, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
            if(Gdx.input.justTouched()) {
                isStarted = true;
                menuMusic.stop();
            }
        }
        else{
            music.play();

            if(Hero.hp <= 0){
                music.stop();
                deathMusic.play();
                myGdxGame.batch.draw(gameOver, myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH / 2, myGdxGame.camera.position.y - MyGdxGame.SCR_HEIGHT / 2, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
                bitmapFont.draw(myGdxGame.batch, "You Lose!" + "\n" + score, myGdxGame.camera.position.x - 250, myGdxGame.camera.position.y + 350, 500, 1, false);
//                restartButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y - 125, false);
                if(Gdx.input.justTouched()){
                    deathMusic.stop();
                    Hero.hp = 100;
                    score = 0;
                    time = 0;
                    hero.changePosition(-Hero.x, -Hero.y);
                    myGdxGame.camera.position.set(0, 0, 0);
                    Room.rooms.clear();
                    city = new City();
                    EnemiesStorage.enemyList.clear();
                    BulletStorage.bullets.clear();
                    EnemiesBullets.bullets.clear();
                }
            } else {
                if (paused) {
                    ScreenUtils.clear(0.6f, 0.6f, 0.6f, 1);
                    continueButton.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    inventory.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);

                    if (continueButton.isTouched(Gdx.input.getX(), MyGdxGame.SCR_HEIGHT - Gdx.input.getY())) {
                        paused = false;
                    }
                } else {
                    frameCount++;
                    if(timeTimer <= System.currentTimeMillis() / 1000 - 1){
                        ++time;
                        timeTimer = System.currentTimeMillis() / 1000;
                    }
                    if (time % 30 == 0){
                        if(canMinus) {
                            --score;
                            canMinus = false;
                        }
                    }else canMinus = true;
                    ScreenUtils.clear(0.40625f, 0.5f, 0.515625f, 0.5f);
                    moveCamera();
                    city.draw(myGdxGame.batch, 0);
                    int hpScale = 7;

                    hero.draw(myGdxGame.batch, frameCount, keepTouching, lastCos, lastSyn);
                    spawnArtefact();
                    BulletStorage.draw(myGdxGame.batch);
                    city.draw(myGdxGame.batch, 1);
                    city.checkHeroColision();
                    EnemiesStorage.draw(myGdxGame.batch, frameCount);
                    EnemiesBullets.draw(myGdxGame.batch);
                    hero.draw(myGdxGame.batch, frameCount, keepTouching, lastCos, lastSyn);
                    spawnArtefact();
//                    spawnWeapon();
                    BulletStorage.draw(myGdxGame.batch);
                    city.draw(myGdxGame.batch, 1);
                    city.checkHeroColision();
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


                    //enemy.draw(myGdxGame.batch);
                    if (buttonHandler(fireButton1)) hero.shoot(lastCos, lastSyn, false);
                    if (buttonHandler(fireButton2)) hero.shoot(lastCos, lastSyn, true);
                    hero.checkReload();
                    for(int i = 0; i < spawnGuns.size(); i++){
                        spawnGuns.get(i).drawOnFloor(myGdxGame.batch);
                    }
                    System.out.println(spawnGuns.size());

//            bitmapFont.draw(myGdxGame.batch, " " + EnemiesStorage.enemyList.size(), myGdxGame.camera.position.x, myGdxGame.camera.position.y);
                    if (city.isActivate()) {
                        spawnMonsters(Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale, Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale);
                        if (Hero.hp < 90)
                            Hero.hp += 10;
                        else
                            Hero.hp = 100;
                        drawNewGun = false;
                        count = 0;
                    }

//                        if (Math.abs(Hero.x - (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale)) <= 100 && Math.abs(Hero.y - (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale)) <= 100) {
//                            takeGun();
//                        }

//                    fog.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y);
//                    fog.move(myGdxGame.camera.position.x);
                    if(nextFloor()) {
                        bitmapFont.draw(myGdxGame.batch, "Next floor is apcrosing!", myGdxGame.camera.position.x - 500, myGdxGame.camera.position.y + 250, 1000, 1, true);
                        if(!justOneceGenerate){
                            restartTimer = System.currentTimeMillis();
                            justOneceGenerate = true;
                        }
                        if(restartTimer <= System.currentTimeMillis() - 3000){
                            justOneceGenerate = false;
                            Hero.hp = 100;
                            score = 0;
                            hero.changePosition(-Hero.x, -Hero.y);
                            myGdxGame.camera.position.set(0, 0, 0);
                            Room.rooms.clear();
                            city = new City();
                            EnemiesStorage.enemyList.clear();
                            BulletStorage.bullets.clear();
                            EnemiesBullets.bullets.clear();
                        }
                    }
                    myGdxGame.batch.draw(heart, myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH / 2 + 6 * hpScale, MyGdxGame.SCR_HEIGHT / 2 - 16 * hpScale + myGdxGame.camera.position.y, 16 * hpScale, 16 * hpScale);
                    bitmapFont.getData().setScale(5, 5);
                    bitmapFont.draw(myGdxGame.batch, "" + (int) Hero.hp, myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH / 2 + 16 * hpScale * 2f, MyGdxGame.SCR_HEIGHT / 2 + myGdxGame.camera.position.y - 16 * hpScale / 4, 15, 1, false);
                    bitmapFont.draw(myGdxGame.batch, "" + score, myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH/24*13.5f, myGdxGame.camera.position.y + MyGdxGame.SCR_HEIGHT/24*9 , 500, 1, false);
                    if(time % 60 < 10)
                        bitmapFont.draw(myGdxGame.batch, "time " + (int) (time / 60) + ":0" + (time % 60), myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH / 2 + 16 * hpScale * 3f, MyGdxGame.SCR_HEIGHT / 2 - 4 * hpScale + myGdxGame.camera.position.y, 500, 0, false);
                    else
                        bitmapFont.draw(myGdxGame.batch, "time " + (int) (time / 60) + ":" + (time % 60), myGdxGame.camera.position.x - MyGdxGame.SCR_WIDTH/2 + 16 * hpScale * 3f, MyGdxGame.SCR_HEIGHT / 2  - 4 * hpScale + myGdxGame.camera.position.y, 500, 0, false);
                    fireButton1.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y, hero.getReload1());
                    fireButton2.draw(myGdxGame.batch, myGdxGame.camera.position.x, myGdxGame.camera.position.y, hero.getReload2());
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
        numberOfMonsters = random.nextInt(maxMonsters) + 1;
        for (int i = 0; i < numberOfMonsters; i++) {
            form = random.nextInt(4) + 1;
            x0 = random.nextInt(600 * 4) + 16 * MyGdxGame.scale + roomX - 304 * CityRoom.scale;
            y0 = random.nextInt(600 * 4) + 16 * MyGdxGame.scale + roomY - 304 * CityRoom.scale;
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
                //              case 4:
                //                  EnemiesStorage.enemiesList.add(new Big(x0, y0));
                //                  break;
                case 4:
                    EnemiesStorage.enemyList.add(new TallBasic(x0, y0));
                    break;
                default:
                    System.out.println("default");
            }
        }
    }

    public void spawnArtefact() {
        if (EnemiesStorage.enemyList.size() == 0) {
            form = random.nextInt(8) + 1;
            switch (1) {
                case 1:
                    //   Texture brush = new Texture("textures/artifacts/brush.png");
                    //  myGdxGame.batch.draw(brush, (int) Hero.x, (int) Hero.y, 256, 256);
                    artefacts.add(new Brush());
                    break;
                case 2:
                    artefacts.add(new Crane());
                    break;
                case 3:
                    artefacts.add(new DemonHorn());
                    break;
                case 4:
                    artefacts.add(new Dice());
                    break;
                case 5:
                    artefacts.add(new ElectromagneticCoil());
                    break;
                case 6:
                    artefacts.add(new Glitch());
                    break;
                case 7:
                    artefacts.add(new NitrogenCylinder());
                    break;
                case 8:
//                    artefacts.add(new portableNuclearReactor());
                    break;
                case 9:
                    artefacts.add(new Scaner3D());
                    break;
            }
        }
    }

    public void spawnWeapon() {
        if (EnemiesStorage.enemyList.size() == 0 && count == 0) {
            count = 1;
            form = random.nextInt(7) + 1;
            switch (form) {
                case 1:
                    spawnGuns.add(new BasicLaser());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;
                    break;
                case 2:
                    spawnGuns.add(new CyberBow());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

                    break;
                case 3:
                    spawnGuns.add(new DoomShotgun());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

                    break;
                case 4:
                    spawnGuns.add(new GasRifle());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

                    break;
                case 5:
                    spawnGuns.add(new Ledashnikov());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

                    break;
                case 6:
                    spawnGuns.add(new RailGun());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

                    break;
                case 7:
                    spawnGuns.add(new StarRifle());
                    spawnGuns.get(spawnGuns.size() - 1).init(8, 8, 5);
                    spawnGuns.get(spawnGuns.size() - 1).setXYPosition((int) (Room.rooms.get(City.lastRoom).x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale), (int) (Room.rooms.get(City.lastRoom).y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale));
                    gunRoomIndex[City.lastRoom] = spawnGuns.size() - 1;

            }
            drawNewGun = true;

        }
    }
    public boolean nextFloor(){
        if(EnemiesStorage.enemyList.size() == 0) {
            for (int i = 0; i < Room.rooms.size(); i++) {
                if (!Room.rooms.get(i).isActivate && i % 2 == 0) return false;
            }
            return true;
        }
        return  false;
    }
    public void takeGun() {
        System.out.println("take gun");
        if (Hero.wasTurned) {
            spawnGuns.get(gunRoomIndex[City.lastRoom]).flipY();
        }
        Hero.gun1 = spawnGuns.get(gunRoomIndex[City.lastRoom]);
        drawNewGun = false;
    }
}
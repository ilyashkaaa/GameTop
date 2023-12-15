package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.BasicLaser;
import com.mygdx.game.items.weapon.CyberBow;
import com.mygdx.game.items.weapon.DoomShotgun;
import com.mygdx.game.items.weapon.GasRifle;
import com.mygdx.game.items.weapon.Gun;
import com.mygdx.game.items.weapon.Ledashnikov;
import com.mygdx.game.items.weapon.RailGun;
import com.mygdx.game.items.weapon.StarRifle;

import java.util.Objects;
import java.util.Random;

import control.Inventory;

public class Hero {
    Head head;
    Body body;
    static Gun gun1;
    static Gun gun2;
    public static float hp = 100;
    public int speed = 7;
    public static float x = (float) MyGdxGame.SCR_WIDTH / 2;
    public static float y = (float) MyGdxGame.SCR_HEIGHT / 2;
    boolean wasTurned;
    double moveAngle;
    static Random random = new Random();
    static int type1;
    static int type2 = 0;
    float lastHp = hp;
    long hpTimer;
    boolean redHead;

    public Hero() {
        head = new Head();
        body = new BasicBody();
    }

    public void draw(SpriteBatch batch, int frameCount, boolean isMoving, double cosinus, double sinus) {
        if (sinus > 0) moveAngle = Math.toDegrees(Math.acos(cosinus));
        else moveAngle = 360 - Math.toDegrees(Math.acos(cosinus));
        if (wasTurned) gun2.draw(batch, x, y, (float) moveAngle);
        else gun1.draw(batch, x, y, (float) moveAngle + 180);
        body.draw(batch, x, y, frameCount, isMoving);
        head.draw(batch, x, y, frameCount, redHead);
        if (hp < lastHp){
            hpTimer = System.currentTimeMillis();
            lastHp = hp;
            redHead = true;
        }

        if(System.currentTimeMillis() - 333 >= hpTimer) redHead = false;
        if (wasTurned) gun1.draw(batch, x, y, (float) moveAngle + 180);
        else gun2.draw(batch, x, y, (float) moveAngle);
    }

    public void move(double deltaX, double deltaY) {
        x += deltaX * speed;
        y += deltaY * speed;
        if ((deltaX < 0 && !wasTurned) || (deltaX > 0 && wasTurned)) {
            body.flip();
            head.flip();
            gun1.flipY();
            gun2.flipY();
            wasTurned = !wasTurned;
        }
    }
    public boolean getReload1(){
        return gun1.reloadStarted1;
    }
    public boolean getReload2(){
        return gun2.reloadStarted1;
    }
    public void shoot(double cosinus, double sinus, boolean gun) {
        if (!gun) gun1.shoot(x, y, cosinus, sinus);
        else gun2.shoot(x, y, cosinus, sinus);
    }
    public void checkReload(){
        gun1.checkReload();
        gun2.checkReload();
    }
    public void changePosition(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public static void gunRandom() {
        type1 = random.nextInt(6) + 1;
        switch (type1) {
            case 1:
                gun1 = new BasicLaser();
                gun1.init(8, 8, 7);
                break;
            case 2:
                gun1 = new DoomShotgun();
                gun1.init(24, 8, 5);

                break;
            case 3:
                gun1 = new GasRifle();
                gun1.init(24, 8, 5);

                break;
            case 4:
                gun1 = new Ledashnikov();
                gun1.init(24, 8, 5);

                break;
            case 5:
                gun1 = new RailGun();
                gun1.init(24, 8, 5);

                break;
            case 6:
                gun1 = new StarRifle();
                gun1.init(40, 8, 5);
                break;
        }
        type2 = random.nextInt(7) + 1;
        while (type1 == type2) {
            type2 = random.nextInt(7) + 1;
        }
        switch (type2) {
            case 1:
                gun2 = new BasicLaser();
                gun2.init(8, 8, 7);
                break;
            case 2:
                gun2 = new DoomShotgun();
                gun2.init(8, 8, 5);
                break;
            case 3:
                gun2 = new GasRifle();
                gun2.init(8, 8, 5);
                break;
            case 4:
                gun2 = new Ledashnikov();
                gun2.init(8, 8, 5);
                break;
            case 5:
                gun2 = new RailGun();
                gun2.init(8, 8, 5);
                break;
            case 6:
                gun2 = new StarRifle();
                gun2.init(8, 8, 5);
                break;
            case 7:
                gun2 = new CyberBow();
                gun2.init(8, 8, 5);
                break;
        }
        gun1.flipX();
    }
}

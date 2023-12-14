package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.BasicLaser;
import com.mygdx.game.items.weapon.CyberBow;
import com.mygdx.game.items.weapon.Gun;

public class Hero {
    Head head;
    Body body;
    Gun gun1;
    Gun gun2;
    public static float hp = 100;
    public int speed = 20;
    public static float x = (float) MyGdxGame.SCR_WIDTH / 2;
    public static float y = (float) MyGdxGame.SCR_HEIGHT / 2;
    boolean wasTurned;
    double moveAngle;

    public Hero() {
        head = new Head();
        body = new BasicBody();
        gun1 = new CyberBow();
        gun2 = new BasicLaser();
        gun1.init(8, 8, (int) MyGdxGame.scale);
        gun2.init(8, 8, (int) MyGdxGame.scale);
    }

    public void draw(SpriteBatch batch, int frameCount, boolean isMoving, double cosinus, double sinus) {
        if (sinus > 0) moveAngle = Math.toDegrees(Math.acos(cosinus));
        else moveAngle = 360 - Math.toDegrees(Math.acos(cosinus));
        if (wasTurned) gun2.draw(batch, x, y, (float) moveAngle);
        else gun1.draw(batch, x, y, (float) moveAngle);
        body.draw(batch, x, y, frameCount, isMoving);
        head.draw(batch, x, y, frameCount);
        if (wasTurned) gun1.draw(batch, x, y, (float) moveAngle);
        else gun2.draw(batch, x, y, (float) moveAngle);
    }

    public void move(double deltaX, double deltaY) {
        x += deltaX * speed;
        y += deltaY * speed;
        if ((deltaX < 0 && !wasTurned) || (deltaX > 0 && wasTurned)) {
            body.flip();
            head.flip();
            wasTurned = !wasTurned;
        }
    }

    public void shoot(double cosinus, double sinus, boolean gun) {
        if (!gun) gun1.shoot(x, y, cosinus, sinus);
        else gun2.shoot(x, y, cosinus, sinus);
    }
    public void changePosition(float deltaX, float deltaY){
        x += deltaX;
        y += deltaY;
    }
}

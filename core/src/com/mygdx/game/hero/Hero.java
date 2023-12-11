package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.BasicLaser;
import com.mygdx.game.items.weapon.CyberBow;
import com.mygdx.game.items.weapon.Gun;
import com.mygdx.game.items.weapon.Ledashnikov;
import com.mygdx.game.items.weapon.RusRoulette;
import com.mygdx.game.items.weapon.StarRifle;
import com.mygdx.game.items.weapon.Weapon;

public class Hero {
    Head head;
    Body body;
    Gun gun1;
    Gun gun2;
    int speed = 5;
    public static float x = (float) MyGdxGame.SCR_WIDTH / 2;
    public static float y = (float) MyGdxGame.SCR_HEIGHT / 2;
    boolean wasTurned;


    public Hero(){
        head = new Head();
        body = new BasicBody();
        gun1 = new CyberBow();
        gun2 = new BasicLaser();
    }
    public void draw(SpriteBatch batch, int frameCount, boolean isMoving){
        body.draw(batch, x, y, frameCount, isMoving);
        head.draw(batch, x, y + 12 * MyGdxGame.scale + 0.5f * MyGdxGame.scale * (frameCount % 80 / 40));
    }
    public void move(double deltaX, double deltaY){
        x += deltaX * speed;
        y += deltaY * speed;
        if((deltaX < 0 && !wasTurned) || (deltaX > 0 && wasTurned)){
            body.flip();
            head.flip();
            wasTurned = !wasTurned;
        }
    }
    public void shoot(double cosinus, double sinus, boolean gun) {
        if(!gun) gun1.shoot(x, y, cosinus, sinus);
        else gun2.shoot(x, y, cosinus, sinus);
    }

}

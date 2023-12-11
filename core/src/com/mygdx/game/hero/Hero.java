package com.mygdx.game.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.BasicLaser;
import com.mygdx.game.items.weapon.CyberBow;
import com.mygdx.game.items.weapon.DoomShotgun;
import com.mygdx.game.items.weapon.GasRifle;
import com.mygdx.game.items.weapon.Gun;
import com.mygdx.game.items.weapon.Ledashnikov;
import com.mygdx.game.items.weapon.RusRoulette;
import com.mygdx.game.items.weapon.StarRifle;
import com.mygdx.game.items.weapon.Weapon;

public class Hero {
    Head head;
    Body body;
    Gun gun;
    int speed = 5;
    float x = (float) MyGdxGame.SCR_WIDTH / 2;
    float y = (float) MyGdxGame.SCR_HEIGHT / 2;
    boolean wasTurned;


    public Hero(){
        head = new Head();
        body = new BasicBody();
        gun = new StarRifle();
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
    public void shoot(double sinus, double cosinus) {
        gun.shoot(x, y, sinus, cosinus);
    }

}

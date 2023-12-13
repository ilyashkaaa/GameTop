package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Pause {
    public static float height = 12, widht = 15;

    float x, y;
    Texture pauseTexture;

    public Pause(float x, float y) {
        pauseTexture = new Texture("joystik/pause.png");
        this.x = x;
        this.y = y;
    }

    public boolean isTouched(int touchedX, int touchedY) {
        if (x < touchedX && widht * 15 > touchedX && y < touchedY && y+height * 20 > touchedY) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(SpriteBatch batch, float cx, float cy) {
        System.out.println( x + " " + y);
        batch.draw(pauseTexture, cx - 1200,  cy+300, widht * 15, height * 20);
    }
}

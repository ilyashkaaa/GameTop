package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Continue {
    public static float height = 16, widht = 16;
    float x,y;
    Texture continueTexture;

    public Continue(float x, float y) {
        continueTexture = new Texture("joystik/continue.png");
        this.x = x;
        this.y = y;

    }
    public boolean isTouched(int touchedX, int touchedY) {
        if (x < touchedX && x + widht * 15 > touchedX && y < touchedY && y + height * 15 > touchedY) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(SpriteBatch batch, float cx, float cy) {
        batch.draw(continueTexture, cx + 900, cy+300, widht*15, height*15);
    }
}


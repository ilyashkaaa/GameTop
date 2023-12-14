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
        pauseTexture = new Texture("textures/gui/pause_icon.png");
        this.x = x;
        this.y = y;
    }

    public boolean isTouched(int touchedX, int touchedY) {
        if (MyGdxGame.SCR_WIDTH - widht * 15 < touchedX && MyGdxGame.SCR_WIDTH > touchedX && MyGdxGame.SCR_HEIGHT - height * 20 < touchedY && MyGdxGame.SCR_HEIGHT > touchedY) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(SpriteBatch batch, float cx, float cy) {
        batch.draw(pauseTexture, cx + MyGdxGame.SCR_WIDTH / 2 - widht * 15, cy + MyGdxGame.SCR_HEIGHT / 2 - height * 20, widht * 15, height * 20);
    }
}

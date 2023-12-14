package control;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Continue {
    public static float heightContinue = 16, widhtContinue = 16;
    Texture continueTexture;


    public Continue() {
        continueTexture = new Texture("textures/gui/continue_icon.png");
    }
    public boolean isTouched(int touchedX, int touchedY) {
        if (MyGdxGame.SCR_WIDTH/2 - widhtContinue*15/2 < touchedX && MyGdxGame.SCR_WIDTH/2 + widhtContinue * 15/2 > touchedX && 0 < touchedY && heightContinue * 15 > touchedY) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(SpriteBatch batch, float cx, float cy) {
        batch.draw(continueTexture, cx -widhtContinue*15/2, cy-MyGdxGame.SCR_HEIGHT/2, widhtContinue*15, heightContinue *15);
    }
}


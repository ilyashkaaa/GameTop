package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Button {
    Texture filledCircle;
    Texture filledCircleReload;
    public static int widht = 300, height = 300;
    int x, y;
    float par = 0.7f;
    public Button(int x, int y) {
        filledCircle = new Texture("joystik/filled_circle.png");
        filledCircleReload = new Texture("joystik/filled_circle_gray.png");
        this.x = x;
        this.y = y;
    }

    public boolean isTouched(int touchedX, int touchedY, int index) {
        if (Math.pow(Math.pow(x - touchedX, 2) + Math.pow(y - touchedY, 2), 0.5) <= widht / 2 && Gdx.input.getPressure(index) != 0){
         par = 0.5f;
         return true;
        }
        else{
            par = 0.7f;
            return false;
        }
    }
    public void draw(SpriteBatch batch, float cx, float cy, boolean reloadStarted) {
        batch.setColor(1, 1, 1, par);
        if (reloadStarted) {
            batch.draw(filledCircleReload, x - widht / 2 - MyGdxGame.SCR_WIDTH / 2 + cx, y - height / 2 - MyGdxGame.SCR_HEIGHT / 2 + cy, widht, height);
        } else {
            batch.draw(filledCircle, x - widht / 2 - MyGdxGame.SCR_WIDTH / 2 + cx, y - height / 2 - MyGdxGame.SCR_HEIGHT / 2 + cy, widht, height);
        }
        batch.setColor(1, 1, 1, 1);
    }
}

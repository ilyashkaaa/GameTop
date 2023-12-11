package control;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FireButton1 {
    Texture filledCircle;
    public static int widht = 300, height = 300;
    int x, y;
    float par;
    public FireButton1(int x, int y) {
        filledCircle = new Texture("joystik/filled_circle.png");
        this.x = x;
        this.y = y;
    }

    public boolean isTouched(int touchedX, int touchedY) {
        if (Math.pow(Math.pow(x - touchedX, 2) + Math.pow(y - touchedY, 2), 0.5) <= widht / 2){
         par = 0.5f;
         return true;
        }
        else{
            par = 0.7f;
            return false;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.setColor(1, 1, 1, par);
        batch.draw(filledCircle, x - widht / 2, y - height / 2, widht, height);
        batch.setColor(1, 1, 1, 1);
    }
}

package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Joystick {
    Texture circle;
    Texture filledCircle;
    int width = 400, height = 400;
    int x = MyGdxGame.SCR_WIDTH / 2, y = MyGdxGame.SCR_HEIGHT / 2;

    public Joystick() {
        circle = new Texture("joystik/circle.png");
        filledCircle = new Texture("joystik/filled_circle.png");
    }
    public void changeXY(int jx, int jy){
        x = jx;
        y = jy;
    }
    private double calculateHypotinase(int tapX, int tapY){
        if(Math.pow((Math.pow(tapX - x, 2) + Math.pow(tapY - y, 2)), 0.5) != 0) return Math.pow((Math.pow(tapX - x, 2) + Math.pow(tapY - y, 2)), 0.5);
        else return 1;
    }
    public double getX(int index){
        int tapX = Gdx.input.getX(index);
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY(index);
        return (tapX - x) / calculateHypotinase(tapX, tapY);
    }
    public double getY(int index){
        int tapX = Gdx.input.getX(index);
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY(index);
        return (tapY - y) / calculateHypotinase(tapX, tapY);
    }
    public void draw(SpriteBatch batch, int index, float cx, float cy) {
        batch.setColor(1, 1, 1, 0.4f);
        batch.draw(circle, x - MyGdxGame.SCR_WIDTH / 2 + cx - width / 2, y - MyGdxGame.SCR_HEIGHT / 2 + cy - height / 2, width, height);
        int tapX = Gdx.input.getX();
        int tapY = MyGdxGame.SCR_HEIGHT - Gdx.input.getY();
        batch.setColor(1, 1, 1, 0.7f);
        if (calculateHypotinase(tapX, tapY) <= width / 3)
            batch.draw(filledCircle, Gdx.input.getX() - MyGdxGame.SCR_WIDTH / 2 + cx - width / 8, MyGdxGame.SCR_HEIGHT - Gdx.input.getY() - MyGdxGame.SCR_HEIGHT / 2 + cy - height / 8, width / 4, height / 4);
        else batch.draw(filledCircle, (float)getX(index) * width / 3 + x - MyGdxGame.SCR_WIDTH / 2 + cx - width / 8, (float)getY(index) * height / 3 + y - MyGdxGame.SCR_HEIGHT / 2 + cy - height / 8, width / 4, height / 4);
        batch.setColor(1, 1, 1, 1);
    }
}

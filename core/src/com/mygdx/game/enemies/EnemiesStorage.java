package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.utils.Bullet;

import java.util.LinkedList;
import java.util.List;

public class EnemiesStorage {

    public static List<Enemies> enemiesList = new LinkedList<>();

    public static void draw(SpriteBatch batch, int frameCounter) {
        for (Enemies enemy : enemiesList) {
            System.out.println("тест0");
            if (!enemy.isAlive()) {
                enemiesList.remove(enemy);
                break;
            }
        }
        for (Enemies enemy : enemiesList) {
            System.out.println("тест1");
            enemy.draw(batch, frameCounter);
        }
    }
}

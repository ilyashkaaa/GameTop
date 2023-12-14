package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EnemiesStorage {

    public static List<Enemy> enemyList = new LinkedList<>();

    public static void draw(SpriteBatch batch, int frameCounter) {
        for (Enemy enemy : enemyList) {
            if (!enemy.isAlive()) {
                enemyList.remove(enemy);
                break;
            }
        }
        enemyList.sort(((e1, e2) -> (int) (e2.y0 - e1.y0)));
        for (Enemy enemy : enemyList) {
            enemy.draw(batch, frameCounter);
        }
    }
}

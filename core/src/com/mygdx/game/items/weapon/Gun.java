package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Gun extends Weapon {
    Sprite bulletTexture;
    // урон
    double damage;
    //время перезарядки в сек
    double reload;
    //расстояние стрельбы
    double distance;
    //объем обоймы
    int clip;

    public void shoot() {

    }
}

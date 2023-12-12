package com.mygdx.game.items.weapon;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ledashnikov extends Gun {
    public Ledashnikov() {
        title = "Автомат Ледашникова";
        description="Калашников, но с ледяным уроном";
        property = "урон 10, накладывает эффект заморозки, дальность 200м, перезарядка 0.01";
        weaponTexture = new Sprite(new Texture("textures/weapons/ice_rifle.png"));
        damage = 10;
        distance = 1500;
        clip = 30;
        shotDelay=0.2;
        reload = 2;
        bulletSpeed=75;
    }
}

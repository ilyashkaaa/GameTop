package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class DoomShotgun extends Gun {
    int bulletsPerShot;
    public DoomShotgun(){
        weaponTexture = new Sprite(new Texture("textures/weapons/hell_shotgun.png"));
        bulletTexture = new Sprite(new Texture("textures/weapons/bullets/fire_bullet.png"));
        title = "Адский дробовик";
        description="вы слышите мелодию из DOOM и запах ультранасилия";
        property = "урон 6, дальность 10м, перезарядка после 2-ух выстрелов, зона 50 градусов";
        damage = 15;
        bulletSpeed = 20;
        distance = 400;
        clip = 1;
        reload = 1;
        shotDelay=0.1;
    }
}

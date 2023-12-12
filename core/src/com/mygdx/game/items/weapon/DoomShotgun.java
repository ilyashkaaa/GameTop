package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class DoomShotgun extends Gun {
    int bulletsPerShot;
    public DoomShotgun(){
        title = "Адский дробовик";
        description="вы слышите мелодию из DOOM и запах ультранасилия";
        weaponTexture = new Sprite(new Texture("textures/weapons/hell_shotgun.png"));
        property = "урон 6, дальность 10м, перезарядка после 2-ух выстрелов, зона 50 градусов";
        damage = 40;
        distance = 400;
        clip = 2;
        reload = 2;
    }
}

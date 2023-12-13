package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class StarRifle extends Gun{
    public StarRifle() {
        weaponTexture = new Sprite(new Texture("textures/weapons/star_rifle.png"));
        title = "Звёздная винтовка";
        description="Выстрелы в форме звёзд упала вместе с прицелом";
        property = "урон 20 дальность 400 м перезарядка 2 сек";
        damage = 100;
        distance = 6000;
        clip = 5;
        shotDelay=0.4;
        reload = 2;
        bulletSpeed=100;
    }
}

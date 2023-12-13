package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class railgun extends Gun{
    public railgun() {
        weaponTexture = new Sprite(new Texture("textures/weapons/railgun"));
        title = "Рельсотрон";
        description="Причём здесь трон из рельс";
        property ="урон 10, дальность 200м, кд 1 сек";
        damage = 10;
        distance = 2000;
        bulletSpeed=100;
        clip = 1;
        shotDelay=0;
        reload = 0.3;
    }
}

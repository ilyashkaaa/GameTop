package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GasRifle extends Gun{
    public GasRifle() {
        weaponTexture = new Sprite(new Texture("textures/weapons/gas_rifle"));
        bulletTexture = new Sprite(new Texture("textures/weapons/bullet/radiation"));
        title = "Газовая винтовка";
        description="Секретное оружие немцов созданное в 1945г";
        property = "урон 3, в местах попадания появляются облака радиации, дальность 100м, перезарядка 0.5сек";
        damage = 3;
        distance = 1028;
        clip = 10;
        shotDelay=0.1;
        reload = 0.5;
        bulletSpeed=50;
    }
}

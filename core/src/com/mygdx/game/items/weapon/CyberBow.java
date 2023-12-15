package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CyberBow extends Gun {
    public CyberBow() {
        bulletTexture = new Sprite(new Texture("textures/weapons/bullets/arrow.png"));
        weaponTexture = new Sprite(new Texture("textures/weapons/cyber_bow.png"));
        title = "Кибер лук";
        description="Это базовый лук со стократным усилением,";
        property = "10 урона, дальность 200м, перезарядка 0";
        damage = 8;
        distance = 2000;
        clip = 1;
        reload = 1;
        bulletSpeed=20;
        shotDelay = 0.5;
        extraRotate = 45;
    }
}

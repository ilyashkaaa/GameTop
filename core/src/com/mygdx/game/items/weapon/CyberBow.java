package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CyberBow extends Gun {
    public CyberBow() {
        bulletTexture = new Sprite(new Texture("textures/weapons/bullets/arrow.png"));
        title = "Кибер лук";
        description="Это базовый лук со стократным усилением,";
        property = "10 урона, дальность 200м, перезарядка 0";
        damage = 10;
        distance = 200;
        clip = 1;
        reload = 0.1;
        shotDelay = 0.25;
        bulletSpeed = 10;
    }
}

package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class BasicLaser extends Gun {
    public BasicLaser() {
        bulletTexture = new Sprite(new Texture("textures/weapons/bullets/lazer_bullet.png"));
        weaponTexture = new Sprite(new Texture("textures/weapons/basicLazer.png"));
        title = "Базовый лазер";
        description="Простой лазер похож на пистолет,";
        property = "1 урон, дальность 50м, перезарядка 0,25 секунд";
        damage = 2;
        distance = 750;
        clip = 10;
        reload = 2;
        shotDelay = 0.25;
        bulletSpeed = 20;
        extraRotate = 0;
    }
}

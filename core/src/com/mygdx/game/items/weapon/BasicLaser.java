package com.mygdx.game.items.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.utils.Bullet;

public class BasicLaser extends Gun {
    public BasicLaser() {
        bulletTexture = new Sprite(new Texture("textures/weapons/bullets/lazer_bullet.png"));
        title = "Базовый лазер";
        description = "Простой лазер похож на пистолет, 1 урон, дальность 50м, перезарядка 0,25 секунд";
        damage = 1;
        distance = 50;
        clip = 1;
        reload = 0.25;
    }
}

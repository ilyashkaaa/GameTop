package com.mygdx.game.items.weapon;

public class BasicLaser extends Gun {
    public BasicLaser() {
        title = "Базовый лазер";
        description = "Простой лазер похож на пистолет, 1 урон, дальность 50м, перезарядка 0,25 секунд";
        damage = 1;
        distance = 50;
        clip = 1;
        reload = 0.25;
    }
}

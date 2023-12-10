package com.mygdx.game.items.weapon;

public class CyberBow extends Gun {
    public CyberBow() {
        title = "Кибер лук";
        description = "Это базовый лук со стократным усилением, 10 урона, дальность 200м, перезарядка 0";
        damage = 10;
        distance = 200;
        clip = 1;
        reload = 0.1;
    }
}

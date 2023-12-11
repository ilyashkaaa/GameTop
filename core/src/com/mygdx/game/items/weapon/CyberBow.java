package com.mygdx.game.items.weapon;

public class CyberBow extends Gun {
    public CyberBow() {
        title = "Кибер лук";
        description="Это базовый лук со стократным усилением,";
        property = "10 урона, дальность 200м, перезарядка 0";
        damage = 20;
        distance = 5000;
        clip = 1;
        reload = 1;
        bulletSpeed=20;
    }
}

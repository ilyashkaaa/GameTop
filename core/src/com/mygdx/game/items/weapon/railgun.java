package com.mygdx.game.items.weapon;

public class railgun extends Gun{
    public railgun() {
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

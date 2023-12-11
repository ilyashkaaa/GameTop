package com.mygdx.game.items.weapon;



public class Ledashnikov extends Gun {
    public Ledashnikov() {
        title = "Автомат Ледашникова";
        description="Калашников, но с ледяным уроном";
        property = "урон 10, накладывает лёд, дальность 200м, перезарядка 0.01";
        damage = 10;
        distance = 1500;
        clip = 30;
        shotDelay=0.2;
        reload = 2;
        bulletSpeed=75;
    }
}

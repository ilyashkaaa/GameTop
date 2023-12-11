package com.mygdx.game.items.weapon;



public class Ledashnikov extends Gun {
    public Ledashnikov() {
        title = "Автомат Ледашникова";
        description="Калашников, но с ледяным уроном";
        property = "урон 10, накладывает лёд, дальность 200м, перезарядка 0.01";
        damage = 10;
        distance = 200;
        clip = 100;
        reload = 0.01;
    }
}

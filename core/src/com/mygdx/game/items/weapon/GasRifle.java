package com.mygdx.game.items.weapon;

public class GasRifle extends Gun{
    public GasRifle() {
        title = "Газовая винтовка";
        description = "урон 3, в местах попадания появляются облака радиации, дальность 100м, перезарядка 0.5сек";
        damage = 3;
        distance = 100;
        clip = 10;
        reload = 0.5;
    }
}

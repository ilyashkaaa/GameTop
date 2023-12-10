package com.mygdx.game.items.weapon;

public class RusRoulette extends Gun{
    public RusRoulette() {
        title = "Русская рулетка";
        description ="урон 5, дальность 200м, перезарядка после 6 выстрелов, кд 1 сек";
        damage = 5;
        distance = 200;
        clip = 6;
        reload = 1;
    }
}

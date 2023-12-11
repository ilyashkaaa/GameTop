package com.mygdx.game.items.weapon;

public class RusRoulette extends Gun{
    public RusRoulette() {
        title = "Русская рулетка";
        description="Нам не хватило времени";
        property ="урон 5, дальность 200м, перезарядка после 6 выстрелов, кд 1 сек";
        damage = 6;
        distance = 1200;
        bulletSpeed=69;
        clip = 6;
        shotDelay=0.3;
        reload = 1;
    }
}

package com.mygdx.game.items.weapon;

public class StarRifle extends Gun{
    public StarRifle() {
        title = "Звёздная винтовка";
        description="Выстрелы в форме звёзд упала вместе с прицелом";
        property = "урон 20 дальность 400 м перезарядка 2 сек";
        damage = 20;
        distance = 5400;
        clip = 5;
        shotDelay=0.5;
        reload = 2;
        bulletSpeed=100;
    }
}

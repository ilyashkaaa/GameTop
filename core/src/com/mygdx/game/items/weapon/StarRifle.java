package com.mygdx.game.items.weapon;

public class StarRifle extends Gun{
    public StarRifle() {
        title = "Звёздная винтовка";
        description = "Выстрелы в форме звёзд упала вместе с прицелом (урон 20 дальность 400 м перезарядка 2 сек)";
        damage = 20;
        distance = 400;
        clip = 5;
        reload = 2;
    }
}

package com.mygdx.game.items.weapon;

public class DoomShotgun extends Gun {
    int bulletsPerShot;
    public DoomShotgun(){
        title = "Адский дробовик";
        description="вы слышите мелодию из DOOM и запах ультранасилия";
        property = "урон 6, дальность 10м, перезарядка после 2-ух выстрелов, зона 50 градусов";
        damage = 20;
        distance = 400;
        clip = 2;
        reload = 2;
    }
}

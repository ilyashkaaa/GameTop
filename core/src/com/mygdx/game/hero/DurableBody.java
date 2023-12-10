package com.mygdx.game.hero;

public class DurableBody extends Body {
    public DurableBody() {
        title = "Прочное тело";
        description = "Тяжелая броня, много хп, урон маленький";
        characteristics = "20оз ,75%урон ,9скорость";
        hp = 20;
        damageMultiplier = 0.75;
        speed = 9;
    }
}

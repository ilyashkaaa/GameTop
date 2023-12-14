package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class Battery extends PowerSupplies {
    Battery() {
        title = "Батарейка ";
        description = "Вы родились с ней";
        ability = "Вы получаете гипер заряд на 2 секунды. Гипер заряд ускоряет вас на 50% и увеличивает урон на 25%";
        texture = new Texture("texture/senergy_sources/battery.png");
        damageUp=1.25;
        speedUp=1.5;
    }
}
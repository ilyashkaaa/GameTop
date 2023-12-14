package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class UpgradeBattery extends PowerSupplies {
    UpgradeBattery() {
        title = "Улучшенная батарейка";
        description = "Ваша батарейка, но без надписи с Maid in China";
        ability = "Вы получаете гипер заряд на 4 секунды. Гипер заряд ускоряет вас на 50% и увеличивает урон на 30%";
        texture = new Texture("texture/energy_sources/double_battery.png");
        speedUp=0.5;
        damageUp=1.3;
    }
}

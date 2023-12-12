package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class SteelMask extends PowerSupplies {
    SteelMask() {
        title = "Стальная маска";
        description = "Выглядит как шляпа ,но от неё исходит сильная негативная энергия";
        ability = "Появляется незримая защита блокирующая 50% урона работает 4 секунды";
        texture = new Texture("texture/energy_sources/steel_mask.png");
    }
}

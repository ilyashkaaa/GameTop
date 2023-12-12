package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class WhiteMask extends PowerSupplies {
    WhiteMask() {
        title = "Бледная маска";
        description = "Выглядит как шляпа может надеть";
        ability = "Появляется незримая защита блокирующая 25% урона работает 4 секунды";
        texture = new Texture("pale_mask.png");
    }
}

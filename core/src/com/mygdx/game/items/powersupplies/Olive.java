package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class Olive extends PowerSupplies {
    Olive() {
        title = "Оливье";
        description = "кормить врагов звучит как крутая идея";
        ability = "Кормит всех врагов в комнате и накладывает эффект оглушения";
        texture = new Texture("olivie.png");
    }
}

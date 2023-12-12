package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class Orange extends PowerSupplies {
    Orange() {
        title = "Апельсин";
        description = "Кормить врагов звучит как крутая идея";
        ability = "Кормит половину врагов в комнате и накладывает эффект оглушения";
        texture = new Texture("texture/energy_sources/mandarin.png");
    }
}


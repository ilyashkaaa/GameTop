package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class PivaStoun extends PowerSupplies {
    PivaStoun() {
        title = "Пивной камень";
        description = "Вы чуствуете что вы потихоньку превращаетесь в космического дварфа";
        ability = "При активации в ваших руках появляется новейшая дварфская технология: миниган работает 5 секунд";
        texture = new Texture("beer.png");
    }
}


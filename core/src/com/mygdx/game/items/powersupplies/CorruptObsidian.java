package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class CorruptObsidian extends PowerSupplies {
    CorruptObsidian() {
        title = "Чумной кусок обсидиана ";
        description = "Чума окончательно заразила обсидиан";
        ability = "заменяет пули на 5 секунд на заражённый обсидиан при попадание разлетается на осколки которые при попадании во врага наносят урон и накладывуют эффект чумы(чума наносит по 5 урона в секунду эффект длится 3сек";
        texture = new Texture("texture/energy_sources/plague_obsidian.png");
    }
}

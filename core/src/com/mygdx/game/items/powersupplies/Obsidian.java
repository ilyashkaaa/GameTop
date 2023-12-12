package com.mygdx.game.items.powersupplies;

import com.badlogic.gdx.graphics.Texture;

public class Obsidian extends PowerSupplies {
    Obsidian() {
        title = "Кусок обсидиана";
        description = "Вы чуствуете как от него исходит чума ,но прошлый его владелец думал наоборот";
        ability = "заменяет пули на 5 секунд на обсидиан при попадание разлетается на осколки которые при попадании во врага наносят урон";
        texture = new Texture("obsidian.png");
    }
}

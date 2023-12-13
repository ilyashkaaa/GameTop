package com.mygdx.game.items.artefacts;


import com.badlogic.gdx.graphics.Texture;

public class Glitch extends Artefacts {
    public Glitch() {
        title = "Глюк";
        description="напоминает вам о грусной истории";
        power = "При получении урона есть 10% шанс сглючить и не получить урон";
        texture = new Texture("texture/artifacts/glitch.png");
    }
}

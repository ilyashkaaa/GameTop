package com.mygdx.game.items.artefacts;


import com.badlogic.gdx.graphics.Texture;

public class DemonHorn extends Artefacts {
    public DemonHorn() {
        title = "Рог демона";
        description = "Рог демона вырван у начальника ЖЭК";
        power = "Добавляет пулям эффект огня и увеличивает урон";
        damageUP = 2;
        effects = Effects.Fire;
        texture = new Texture("texture/artifacts/demon_horn.png");
    }
}

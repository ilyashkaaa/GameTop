package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class Brush extends Artefacts {
    public Brush() {
        title = "Кисть";
        description = "Вы думаете, что раскрашивать пули неплохая идея";
        power = "Пули на месте попадания в объект оставляют лужу краски";
        effects = Effects.Color;
        damageOst = 1;
        texture = new Texture("textures/artifacts/brush.png");

    }

}

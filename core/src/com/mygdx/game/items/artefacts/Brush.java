package com.mygdx.game.items.artefacts;

public class Brush extends Artefacts {
    public Brush() {
        title = "Кисть";
        description="Вы думаете что раскрашивать пули неплохая идея";
        Power = "На месте попадания в объект оставляют лужу";
        effects = Effects.Color;
        damageOst=1;
    }

}

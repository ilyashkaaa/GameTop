package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class Scaner3D extends Artefacts{
    public Scaner3D() {
        title = "3Д сканер";
        description = "сканирует месность ещё и в 3-ем измерении";
        Power = "Пули теперь проходят через стены";
        texture = new Texture("texture/artifacts/scanner.png");
    }
}

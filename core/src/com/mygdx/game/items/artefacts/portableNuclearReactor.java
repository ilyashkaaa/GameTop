package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class portableNuclearReactor extends Artefacts{
    public portableNuclearReactor(){
        title = "Портативный ядерный реактор";
        description = "Корманный чернобыль";
        power = "Добавляет перемещяющеюся с вами область, которая накладывает эффект радиации";
        effects = Effects.Radiation;
        texture = new Texture("texture/artifacts/portable_nuclear_reactor.png");
    }

}

package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class portableNuclearReactor extends Artefacts{
    public portableNuclearReactor(){
        title = "Портативный ядерный реактор";
        description = "Корманный чернобыль";
        Power = "Добавляет перемещяющеюся с вами область которая накладывает эффект радиации";
        effects = Effects.Radiation;
        texture = new Texture("portable_nuclear_reactor.png");
    }

}

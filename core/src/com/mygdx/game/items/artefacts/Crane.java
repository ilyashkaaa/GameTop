package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class Crane extends Artefacts {
    public Crane() {
        title = "Журавлик";
        description="Cимвол мира";
        Power = "добаляет пулям эффект радиации (радиация при попадании в стену или во врага появляется зона наносящая 2 урона в секунду";
        effects = Effects.Radiation;
        texture = new Texture("texture/artifacts/paper_crane.png");
    }
}

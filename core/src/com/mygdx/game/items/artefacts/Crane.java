package com.mygdx.game.items.artefacts;

public class Crane extends Artefacts {
    public Crane() {
        title = "Журавлик";
        description="Cимвол мира";
        Power = "добаляет пулям эффект радиации (радиация при попадании в стену " + "или во врага появляется зона наносящая 2урона в секунду";
        effect=Effect.Radiation;

    }
}

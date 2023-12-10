package com.mygdx.game.items.artefacts;

public class NitrogenCylinder extends Artefacts {
    public NitrogenCylinder() {
        title = "Баллон азота";
        description="напоминает фильм После завта";
        Power = "пулям добавлен ледяной урон, и их урон увеличен на 2" +
                "(заморозка длиться 2 секунды накладывается при попадании пули с эффектом льда с 25% шансом)";
        damageUP=2;
        effects = Effects.Freeze;
    }
}

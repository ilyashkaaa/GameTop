package com.mygdx.game.items.artefacts;

import com.badlogic.gdx.graphics.Texture;

public class Dice extends Artefacts {
    public Dice() {
        title = "Игральная кость";
        description = "азарт берёт верх";
        power = "при высреле пуля с 10% шансом заменяется на игральную кость при выпадании:" +
                "6. Бессмертие на полсекунды" +
                "5. Бафф к урону на 3 секунды на +1 урон" +
                "4. Бафф хилл на оз" +
                "3. Мини взрыв на кости" +
                "2. Персонаж получает дебафф, из-за которого он наносит на 1 единицу урона меньше, длится 3 секунды," +
                "1. На персонажа накладывается эффект заморозки)";
        texture = new Texture("texture/artifacts/dice.png");
    }
}

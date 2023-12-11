package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TallBasic extends Enemies{
    public TallBasic() {
        sprite = new Sprite(new Texture("textures/enemies/melee_city.png"));
        title = "Высокий пузырь";
        description = "Аналог обычного, только держится на расстоянии и стреляет";
    }

}

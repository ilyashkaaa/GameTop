package com.mygdx.game.enemies;

public class Big extends Enemies {
    public Big(float x0, float y0) {
        super(x0, y0);
        title = "Большой пузырь";
        description = "скорость медленная, хп много, постоянно создает вонючие опасные облака вокруг себя и в сторону игрока на небольшое расстояние." +
                " После смерти взрывается и из его кокона выпрыгивает несколько мелких пузырьков";
    }
}

package com.mygdx.game.items.artefacts;

public class ElectromagneticCoil extends Artefacts {
    public ElectromagneticCoil() {
        title = "Электромагнитная катушка";
        description = "Великий учёный Никола Тесла очень устал призелился в кресло...";
        Power = "ускоряет выстрелы за каждое убийство на 5% до 100% и добавляет электрический урон " + "(электрический урон станит противника на 2 секунды с 30% шансом)";
        speedUP = 100;
        effects = Effects.Electric;
    }
}

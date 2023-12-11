package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class ChervChemist extends BaseNPC {
    int vstrechaCounter = 0;

    ChervChemist() {

        Dialog dialog1 = new Dialog(new ArrayList<Message>() {{
            new Message("Спасибо, что спас! А то я только вылез и уже в клетке.", "Не благодари");

            new Message("Держи, это тебе (даёт бледную маску).", "Спасибо");

            new Message("Пока.", "Пока");
        }});
        Dialog dialog2 = new Dialog(new ArrayList<Message>(){{
            new Message("О, привет! Рад тебя видеть. Я здесь раньше работал.", "Привет");

            new Message("Я могу дать тебе случайный артефакт из своих запасов за 100 слизи, но только один.", "Да", "Пока");
        }});
        Dialog dialog3 = new Dialog(new ArrayList<Message>(){{
            new Message("100 слизи и артефакт твой!", "Давай","Пока");
        }});
    }
}

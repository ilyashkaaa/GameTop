package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class ChervChemist extends BaseNPC {
    int vstrechaCounter = 0;

    ChervChemist() {
        dialog = new Dialog(new ArrayList<Message>() {{
            new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");

            new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");


            new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");

            new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");

        }});
    }

}

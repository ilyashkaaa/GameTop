package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class ChervChemist extends BaseNPC{
    int vstrechaCounter=0;
    ChervChemist() {
        dialog = new Dialog(new ArrayList<>() {{
            if (vstrechaCounter == 0) {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
                    } else {
                        new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
                    }
                }
            }
            else if(vstrechaCounter==1){
                new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
            }
            else{
                new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
            }
        }});
    }

}

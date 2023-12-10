package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class BeeCabbie extends BaseNPC{
    BeeCabbie() {
        dialog = new Dialog(new ArrayList<>() {{
            new Message("Спасибо за то что спас это вся моя заработка за день держи.", "Да", "Нет");
        }});
    }
}

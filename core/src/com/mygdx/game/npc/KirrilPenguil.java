package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class KirrilPenguil extends BaseNPC{
    KirrilPenguil(){
        dialog = new Dialog(new ArrayList<Message>() {{
            new Message("Что ты вылуписля держи ты меня не видел.", "Ок");
        }});
    }
}

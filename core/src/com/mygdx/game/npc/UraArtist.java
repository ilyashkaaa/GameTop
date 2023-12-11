package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class UraArtist extends BaseNPC{
    UraArtist(){
        dialog = new Dialog(new ArrayList<Message>() {{
            new Message("Мне нечем тебя поблагодарить кроме рисунка, вот держи.", "Cgfcb,j");
        }});

    }
}

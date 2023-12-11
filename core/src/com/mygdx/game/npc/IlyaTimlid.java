package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class IlyaTimlid extends BaseNPC{
    IlyaTimlid(){
        dialog = new Dialog(new ArrayList<Message>() {{
            new Message("спасибо не забуду я обязательно что-то подготовлю", "Спасибо");
        }});
    }
}

package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class HornChief extends BaseNPC{
    HornChief(){
        Dialog dialog1 = new Dialog(new ArrayList<Message>() {{
            new Message("Спасибо, месье, что ты спас меня. Я дам тебе этот прекрасный мандарин.", "Спасибо?");

            new Message("Пока.", "Пока?");
        }});
        Dialog dialog2 = new Dialog(new ArrayList<Message>() {{
            new Message("Бонжур, месье-робот.", "Привет?");

            new Message("Я могу тебе дать своё блюдо за 100 слизи.", "Да?", "Пока");
        }});

    }
}

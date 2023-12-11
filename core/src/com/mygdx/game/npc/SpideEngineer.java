package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class SpideEngineer extends BaseNPC{
    SpideEngineer() {

        Dialog dialog1 = new Dialog(new ArrayList<Message>() {{
            new Message("Спасибо, что спас! Держи подарок.", "Спасибо");

            new Message("Пока", "Пока");
        }});
        Dialog dialog2 = new Dialog(new ArrayList<Message>(){{
            new Message("Привет! Надо же какая встреча! Я нашел это место и меня приняли из-за моей квалификации.", "Привет");

            new Message("Я готов тебя улучшить с помощью инопланетной слизи. Посмотри!", "Ок", "Пока");
        }});
        Dialog dialog3 = new Dialog(new ArrayList<Message>(){{
            new Message("Хочешь прокачаться?", "Давай","Пока");
        }});
    }

}

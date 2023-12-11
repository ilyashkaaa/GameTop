package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;


public class CentipideAlchemist extends BaseNPC{

    CentipideAlchemist() {
        Dialog dialog1 = new Dialog(new ArrayList<Message>() {{
                new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
        }});
    }
        Dialog dialog2 = new Dialog(new ArrayList<Message>() {{
        new Message("О привет ты спас меня три раза и я подготовил для тебя подарок ,он конечно готовился моему брату но всё-же держи.", "Спасибо", "Спаааааааааааааааасииииииибоооооооо","С-п-а-с-и-б-о");
        }});
}

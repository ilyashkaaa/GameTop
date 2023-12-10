package com.mygdx.game.npc;

import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;


public class CentipideAlchemist extends BaseNPC{
    int helpCounter=0;
    CentipideAlchemist() {
        dialog = new Dialog(new ArrayList<>() {{
            if(helpCounter<2 || helpCounter>2)  {
                new Message("Спасибо ,что спас я этого не забуду и держи отвар из трав.", "Да", "Нет");
                helpCounter++;
            }
            else{
                new Message("О привет ты спас меня три раза и я подготовил для тебя подарок ,он конечно готовился моему брату но всё-же держи.", "Спасибо", "Спаааааааааааааааасииииииибоооооооо","С-п-а-с-и-б-о");
                helpCounter++;
            }
        }});
    }
}

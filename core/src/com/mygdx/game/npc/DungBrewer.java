package com.mygdx.game.npc;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.npc.utils.Dialog;
import com.mygdx.game.npc.utils.Message;

import java.util.ArrayList;

public class DungBrewer extends BaseNPC{
    DungBrewer() {
        texture=new Texture("dung_beetle.png");
        Dialog dialog1 = new Dialog(new ArrayList<Message>() {{
            new Message("Спасибо, я пришёл в этот город за реликвией нашей семьи - бочонком пива 400-летней давности.", "?");

            new Message("На, держи! Хотел проверить пиво в бочонке, а оно в камень превратилось.", "Спасибо");

            new Message("Не благодари и пока! Будет хорошо, если снова встретимся.", "Пока");
        }});
        Dialog dialog2 = new Dialog(new ArrayList<Message>() {{
            new Message("О привет! Мне нравится это место.", "Мне тоже");

            new Message(": Я готов дать тебе одну пушку из своего подвала за 100 слизи. Первое получишь бесплатно.", "Спасибо", "Пока");
        }});
        Dialog dialog3 = new Dialog(new ArrayList<Message>() {{
            new Message("100 слизи - и пушка у тебя!", "Да", "Нет");
        }});
    }
}

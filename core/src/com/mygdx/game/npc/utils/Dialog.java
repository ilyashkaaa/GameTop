package com.mygdx.game.npc.utils;

import java.util.List;

public class Dialog {
    List<Message> messages;

    int index = 0;

    public Dialog(List<Message> messages) {
        this.messages = messages;
    }

    public Message getNewMessageDialog(){
        return messages.get(index++);
    }

    public void finishDialog() {
        index = 0;
    }
}

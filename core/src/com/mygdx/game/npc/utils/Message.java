package com.mygdx.game.npc.utils;

import java.util.ArrayList;
import java.util.List;

public class Message {
    public Message(String replica, String answer) {
        answers = new ArrayList<>();
        this.replica = replica;
        answers.add(answer);
    }
    public Message(String replica, String answer1, String answer2) {
        answers = new ArrayList<>();
        this.replica = replica;
        answers.add(answer1);
        answers.add(answer2);

    }
    public Message(String replica, String answer1, String answer2, String answer3) {
        answers = new ArrayList<>();
        this.replica = replica;
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

    }
    String replica;
    List<String> answers;
}

package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.List;

public class Room {
    Sprite texture;
    public static List<Room> rooms = new ArrayList<>();

    public float x, y;
    Room(String path, int i, int j){
        texture = new Sprite(new Texture(path));
        texture.scale(CityRoom.scale);
        x = (MyGdxGame.SCR_WIDTH - texture.getWidth() * City.scale / 2) / 2 + (i - 5) * (texture.getWidth() * City.scale + 256 * City.scale * 1.5f - 32 * City.scale * 4);
        y = (MyGdxGame.SCR_HEIGHT - texture.getHeight() * City.scale / 2) / 2 + (j - 5) * (texture.getHeight() * City.scale + 256 * City.scale * 1.5f - 16 * City.scale * 8);
        texture.setPosition(x, y);
        rooms.add(this);
        System.out.println("" + i + " " + j);
    }
   public static void draw(SpriteBatch batch, int fence){
       for(int i = 0; i < rooms.size(); i++){
           if(i % 2 == fence) {
               rooms.get(i).texture.draw(batch);
           }
       }
    }
}

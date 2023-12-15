package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Room {
    Sprite texture;
    List<Sprite> box = new ArrayList<>();
    Random random = new Random();
    public static List<Room> rooms = new ArrayList<>();
    public float x, y;
    public boolean[] direction;
    public boolean isActivate;
    Room(String path, int i, int j, boolean[] direction){
        int ran = random.nextInt(20);
        for(int t = 0; t < ran; t++){
            box.add (new Sprite(new Texture("textures/locations/1_city/box.png")));
        }
        texture = new Sprite(new Texture(path));
        texture.scale(CityRoom.scale);
        this.direction = direction;
        x = (MyGdxGame.SCR_WIDTH - texture.getWidth() * City.scale / 2) / 2 + (i - 5) * (texture.getWidth() * City.scale + 256 * City.scale * 1.5f - 32 * City.scale * 4);
        y = (MyGdxGame.SCR_HEIGHT - texture.getHeight() * City.scale / 2) / 2 + (j - 5) * (texture.getHeight() * City.scale + 256 * City.scale * 1.5f - 16 * City.scale * 8);
        texture.setPosition(x, y);
        for (int t = 0; t < box.size(); t++){
            box.get(t).scale(CityRoom.scale);
            box.get(t).setPosition(x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale - 304 * CityRoom.scale + random.nextInt(600 * 4), y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale - 304 * CityRoom.scale + random.nextInt(600 * 4));
        }
        box.stream().sorted((a, b) -> (int)(a.getY() - b.getY()));
        rooms.add(this);
    }
   public static void draw(SpriteBatch batch, int fence){
       for(int i = 0; i < rooms.size(); i++){
           if(i % 2 == fence) {
               rooms.get(i).texture.draw(batch);
               if (fence == 0) for(int t = 0; t < rooms.get(i).box.size(); t++){
                   rooms.get(i).box.get(t).draw(batch);
               }
           }
       }
    }
}

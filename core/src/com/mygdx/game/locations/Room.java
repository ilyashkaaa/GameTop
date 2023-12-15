package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.List;

public class Room {
    Sprite texture;
    Sprite box;
    public static List<Room> rooms = new ArrayList<>();
    public float x, y;
    public boolean[] direction;
    public boolean isActivate;
    Room(String path, int i, int j, boolean[] direction){
        box = new Sprite(new Texture("textures/locations/1_city/box.png"));
        texture = new Sprite(new Texture(path));
        texture.scale(CityRoom.scale);
        box.scale(CityRoom.scale);
        this.direction = direction;
        x = (MyGdxGame.SCR_WIDTH - texture.getWidth() * City.scale / 2) / 2 + (i - 5) * (texture.getWidth() * City.scale + 256 * City.scale * 1.5f - 32 * City.scale * 4);
        y = (MyGdxGame.SCR_HEIGHT - texture.getHeight() * City.scale / 2) / 2 + (j - 5) * (texture.getHeight() * City.scale + 256 * City.scale * 1.5f - 16 * City.scale * 8);
        texture.setPosition(x, y);
        box.setPosition(x + 8 * CityRoom.scale + 8.1f * 16 * CityRoom.scale, y - 3 * CityRoom.scale + 9 * 16 * CityRoom.scale);
        rooms.add(this);
    }
   public static void draw(SpriteBatch batch, int fence){
       for(int i = 0; i < rooms.size(); i++){
           if(i % 2 == fence) {
               rooms.get(i).texture.draw(batch);
               rooms.get(i).box.draw(batch);
           }
       }
    }
}

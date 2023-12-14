package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;

import java.util.Random;

public class City extends Locations {
    Random random;
    Hero hero;
    public static float scale = 4;
    int countOfRooms = 0;
    int lastRoom;
    boolean[][] matrix = new boolean[12][12];

    public City() {
        title = "Захваченный город";
        description = "В этот город прилетели пришельцы, полностью зачищен от людей. В ценре стоит их замок - космический корабль";
        random = new Random();
        hero = new Hero();


//        fourWaysRoom.setOriginCenter();
        generate();
        createRooms();
        System.out.println(countOfRooms);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(matrix[j][i] + "  ");
            }
            System.out.println();
        }
    }

    public void draw(SpriteBatch batch, int fence) {
        Room.draw(batch, fence);
    }

    private void generate() {
        matrix[5][5] = true;
        while (countOfRooms < 6) {
            for (int x = 0; x < 11; x++) {
                for (int y = 0; y < 11; y++) {
                    if (matrix[x][y]) {
                        if (random.nextBoolean() && !matrix[x - 1][y]) {
                            matrix[x - 1][y] = true;
                            countOfRooms++;
                            if (countOfRooms >= 6) return;
                        }
                        if (random.nextBoolean() && !matrix[x + 1][y]) {
                            matrix[x + 1][y] = true;
                            countOfRooms++;
                            if (countOfRooms >= 6) return;
                        }
                        if (random.nextBoolean() && !matrix[x][y - 1]) {
                            matrix[x][y - 1] = true;
                            countOfRooms++;
                            if (countOfRooms >= 6) return;
                        }
                        if (random.nextBoolean() && !matrix[x][y + 1]) {
                            matrix[x][y + 1] = true;
                            countOfRooms++;
                            if (countOfRooms >= 6) return;
                        }
                    }
                }
            }
        }
    }
    public void createRooms(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (matrix[j][i]) {
                    int close = 0;
                    if (matrix[j - 1][i]) close++;
                    if (matrix[j + 1][i]) close++;
                    if (matrix[j][i - 1]) close++;
                    if (matrix[j][i + 1]) close++;
//                    System.out.println(close);
//                    close = 1;
                    switch (close) {
                        case 1:
                            if (matrix[j][i + 1]) {
                                new Room("textures/locations/1_city/room_1_left.png", i, j);
                                new Room("textures/locations/1_city/room_1_right_fance.png", i, j);
                            }
                            else if (matrix[j][i - 1]) {
                                new Room("textures/locations/1_city/room_1_right.png", i, j);
                                new Room("textures/locations/1_city/room_1_left_fance.png", i, j);
                            } else if (matrix[j - 1][i]) {

                                new Room("textures/locations/1_city/room_1_down.png", i, j);

                                new Room("textures/locations/1_city/room_1_down_fance.png", i, j);
                            }
                            else{
                                new Room("textures/locations/1_city/room_1_up.png", i, j);
                                new Room("textures/locations/1_city/room_1_up_fance.png", i, j);
                            }
                            break;
                        case 2:
                            if (matrix[j + 1][i] && matrix[j][i + 1]) {
                                new Room("textures/locations/1_city/room_2_corner_up.png", i, j);
                                new Room("textures/locations/1_city/room_2_corner_up_fance.png", i, j);
                            } else if (matrix[j][i + 1] && matrix[j - 1][i]) {
                                new Room("textures/locations/1_city/room_2_corner_right.png", i, j);
                                new Room("textures/locations/1_city/room_2_corner_right_fance.png", i, j);
                            } else if (matrix[j - 1][i] && matrix[j][i - 1]) {
                                new Room("textures/locations/1_city/room_2_corner_down.png", i, j);
                                new Room("textures/locations/1_city/room_2_corner_down_fance.png", i, j);
                            } else if (matrix[j][i - 1] && matrix[j + 1][i]) {
                                new Room("textures/locations/1_city/room_2_corner_left.png", i, j);
                                new Room("textures/locations/1_city/room_2_corner_left_fance.png", i, j);
                            } else if (matrix[j + 1][i] && matrix[j - 1][i]) {
                                new Room("textures/locations/1_city/room_2_straight_vert.png", i, j);
                                new Room("textures/locations/1_city/room_2_straight_vert_fance.png", i, j);
                            }
                            else{
                                new Room("textures/locations/1_city/room_2_straight_hor.png", i, j);
                                new Room("textures/locations/1_city/room_2_straight_hor_fance.png", i, j);
                            }
                            break;
                        case 3:
                            if (!matrix[j][i + 1]) {
                                new Room("textures/locations/1_city/room_3_left.png", i, j);
                                new Room("textures/locations/1_city/room_3_left_fance.png", i, j);
                            } else if (!matrix[j][i - 1]) {
                                new Room("textures/locations/1_city/room_3_right.png", i, j);
                                new Room("textures/locations/1_city/room_3_right_fance.png", i, j);
                            } else if (!matrix[j - 1][i]) {
                                new Room("textures/locations/1_city/room_3_down.png", i, j);
                                new Room("textures/locations/1_city/room_3_down_fance.png", i, j);
                            }else{
                                new Room("textures/locations/1_city/room_3_up.png", i, j);
                                new Room("textures/locations/1_city/room_3_up_fance.png", i, j);
                            }
                            break;
                        case 4:
                            new Room("textures/locations/1_city/room_4.png", i, j);
                            new Room("textures/locations/1_city/room_4_fance.png", i, j);
                            break;
                        default:
                            System.out.println("default");
                    }
                }
            }
        }
    }
    public int indexRoomWithHero(){
        for (int i = 0; i < Room.rooms.size(); i++) {
            if (Room.rooms.get(i).x - 256 * scale + 16 * 5 <= Hero.x && Room.rooms.get(i).x + 512 * scale >= Hero.x && Room.rooms.get(i).y - 256 * scale + 16 * 5 <= Hero.y && Room.rooms.get(i).y + 512 * scale - 16 * 5 >= Hero.y)
                return i;
        }
        return -1;
    }
    public void checkHeroColision(){
        if(indexRoomWithHero() != -1) lastRoom = indexRoomWithHero();
        if(Room.rooms.get(lastRoom).x - 256 * scale + 16 * 5 + 2 * 5 >= Hero.x) hero.changePosition(Room.rooms.get(lastRoom).x - 256 * scale + 16 * 5 - Hero.x + 2 * 5, 0);
        if(Room.rooms.get(lastRoom).x + 512 * scale - 2 * 5 <= Hero.x) hero.changePosition(Room.rooms.get(lastRoom).x + 512 * scale - Hero.x - 2 * 5, 0);
        if(Room.rooms.get(lastRoom).y - 256 * scale + 16 * 5 + 5 * 5 >= Hero.y) hero.changePosition(0, Room.rooms.get(lastRoom).y - 256 * scale + 16 * 5 - Hero.y + 5 * 5);
        if(Room.rooms.get(lastRoom).y + 512 * scale - 16 * 5 - 5 <= Hero.y) hero.changePosition(0, Room.rooms.get(lastRoom).y + 512 * scale - 16 * 5 - Hero.y - 5);
    }
}

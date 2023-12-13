package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.hero.Hero;

import java.util.Random;

public class City extends Locations {
    Sprite fourWaysRoom;
    Sprite treeWaysRoomUp;
    Sprite treeWaysRoomRight;
    Sprite treeWaysRoomDown;
    Sprite treeWaysRoomLeft;
    Sprite twoWaysRoom1Up;
    Sprite twoWaysRoom1Right;
    Sprite twoWaysRoom1Down;
    Sprite twoWaysRoom1Left;
    Sprite twoWaysRoom2Up;
    Sprite twoWaysRoom2Side;
    Sprite oneWaysRoomUp;
    Sprite oneWaysRoomRight;
    Sprite oneWaysRoomDown;
    Sprite oneWaysRoomLeft;
    Sprite roadUp;
    Sprite roadSide;
    Random random;
    int scale = 3;
    int countOfRooms = 0;
    boolean[][] matrix = new boolean[12][12];

    public City() {
        title = "Захваченный город";
        description = "В этот город прилетели пришельцы, полностью зачищен от людей. В ценре стоит их замок - космический корабль";
        random = new Random();

        oneWaysRoomUp = new Sprite(new Texture("textures/locations/1_city/room_1_up.png"));
        oneWaysRoomUp.scale(scale);
        oneWaysRoomRight = new Sprite(new Texture("textures/locations/1_city/room_1_right.png"));
        oneWaysRoomRight.scale(scale);
        oneWaysRoomDown = new Sprite(new Texture("textures/locations/1_city/room_1_down.png"));
        oneWaysRoomDown.scale(scale);
        oneWaysRoomLeft = new Sprite(new Texture("textures/locations/1_city/room_1_left.png"));
        oneWaysRoomLeft.scale(scale);

//        oneWaysRoom.setOriginCenter();
        twoWaysRoom1Up = new Sprite(new Texture("textures/locations/1_city/room_2_corner_up.png"));
        twoWaysRoom1Up.scale(scale);
        twoWaysRoom1Right = new Sprite(new Texture("textures/locations/1_city/room_2_corner_right.png"));
        twoWaysRoom1Right.scale(scale);
        twoWaysRoom1Down = new Sprite(new Texture("textures/locations/1_city/room_2_corner_down.png"));
        twoWaysRoom1Down.scale(scale);
        twoWaysRoom1Left = new Sprite(new Texture("textures/locations/1_city/room_2_corner_left.png"));
        twoWaysRoom1Left.scale(scale);

//        twoWaysRoom2.setOriginCenter();
        twoWaysRoom2Up = new Sprite(new Texture("textures/locations/1_city/room_2_straight_up.png"));
        twoWaysRoom2Up.scale(scale);
        twoWaysRoom2Side = new Sprite(new Texture("textures/locations/1_city/room_2_straight_side.png"));
        twoWaysRoom2Side.scale(scale);

//        twoWaysRoom1.setOriginCenter();
        treeWaysRoomUp = new Sprite(new Texture("textures/locations/1_city/room_3_up.png"));
        treeWaysRoomUp.scale(scale);
        treeWaysRoomRight = new Sprite(new Texture("textures/locations/1_city/room_3_right.png"));
        treeWaysRoomRight.scale(scale);
        treeWaysRoomDown = new Sprite(new Texture("textures/locations/1_city/room_3_down.png"));
        treeWaysRoomDown.scale(scale);
        treeWaysRoomLeft = new Sprite(new Texture("textures/locations/1_city/room_3_left.png"));
        treeWaysRoomLeft.scale(scale);

//        treeWaysRoom.setOriginCenter();
        fourWaysRoom = new Sprite(new Texture("textures/locations/1_city/room_4.png"));
        fourWaysRoom.scale(scale);

        roadSide = new Sprite(new Texture(("textures/locations/1_city/passage_horizontal.png")));
        roadSide.scale(scale);
        roadUp = new Sprite(new Texture(("textures/locations/1_city/passage_vecrtical.png")));
        roadUp.scale(scale);
//        fourWaysRoom.setOriginCenter();
        generate();
        System.out.println(countOfRooms);
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                System.out.print(matrix[j][i] + "  ");
            }
            System.out.println();
        }
    }

    public void draw(SpriteBatch batch) {
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if(matrix[j][i]){
                    int close = 0;
                    if(matrix[j - 1][i]) close++;
                    if(matrix[j + 1][i]) close++;
                    if(matrix[j][i - 1]) close++;
                    if(matrix[j][i + 1]) close++;
//                    System.out.println(close);
                    float deltax = 0, deltay = 0;
//                    close = 1;
                    switch (close){
                        case 1:
                            if(matrix[j][i - 1]){
                                oneWaysRoomLeft.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                oneWaysRoomLeft.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                            }
                             else if(matrix[j][i + 1]){
                                oneWaysRoomRight.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32));
                                oneWaysRoomRight.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                             }
                             else if(matrix[j - 1][i]){
                                oneWaysRoomDown.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32));
                                oneWaysRoomDown.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale - roadUp.getHeight());
                                roadUp.draw(batch);
                             }else{
                                oneWaysRoomUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32));
                                oneWaysRoomUp.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale - roadUp.getHeight());
                                roadUp.draw(batch);
                            }
                            break;
                        case 2:
                            if (matrix[j + 1][i] && matrix[j][i + 1]) {
                                twoWaysRoom1Up.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom1Up.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale - roadUp.getHeight());
                                roadUp.draw(batch);
                            }else if (matrix[j][i + 1] && matrix[j - 1][i]){
                                twoWaysRoom1Right.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom1Right.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale - roadUp.getHeight());
                                roadUp.draw(batch);
                            }else if (matrix[j - 1][i] && matrix[j][i - 1]){
                                twoWaysRoom1Down.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom1Down.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale - roadUp.getHeight());
                                roadUp.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                            }else if (matrix[j][i - 1] && matrix[j + 1][i]){
                                twoWaysRoom1Left.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom1Left.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                            }else if (matrix[j + 1][i] && matrix[j - 1][i]){
                                twoWaysRoom2Up.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom2Up.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                            }else{
                                twoWaysRoom2Side.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                twoWaysRoom2Side.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                            }
                            break;
                        case 3:
                            if(!matrix[j][i - 1]){
                                treeWaysRoomLeft.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                treeWaysRoomLeft.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                            }
                            else if(!matrix[j][i + 1]){
                                treeWaysRoomRight.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                treeWaysRoomRight.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                            }
                            else if(!matrix[j - 1][i]){
                                treeWaysRoomDown.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                treeWaysRoomDown.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                            }else{
                                treeWaysRoomUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                                treeWaysRoomUp.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                                roadUp.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + roadSide.getWidth(), (MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) - oneWaysRoomLeft.getWidth() / 2 * scale - roadSide.getWidth() / 8 * 6 * scale);
                                roadUp.draw(batch);
                                roadSide.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 2) + oneWaysRoomLeft.getWidth() / 2 * scale + roadSide.getWidth() / 8 * 7 * scale, (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32) + roadUp.getHeight());
                                roadSide.draw(batch);
                            }
                            break;
                        case 4:
                            fourWaysRoom.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoomLeft.getWidth() * scale / 2) / 2 + (i - 5) * (oneWaysRoomLeft.getWidth() * scale + roadSide.getWidth() * scale * 65 / 32), (MyGdxGame.SCR_HEIGHT - oneWaysRoomLeft.getHeight() * scale / 2) / 2 + (j - 5) * (oneWaysRoomLeft.getHeight() * scale + roadUp.getHeight() * scale * 65 / 32));
                            fourWaysRoom.draw(batch);
                            break;
                        default:
                            System.out.println("default");
                    }
                }
            }
        }
//        oneWaysRoom.setPosition((MyGdxGame.SCR_WIDTH - oneWaysRoom.getWidth()) / 2, (MyGdxGame.SCR_HEIGHT - oneWaysRoom.getHeight()) / 2);
//        oneWaysRoom.draw(batch);
    }

    /*private void generate() {
        while (countOfRooms == 0) {
            System.out.println("else if");
            for (int i = 0; i < 1; i++) {
                //System.out.println(i);
                if (random.nextInt(3) < 2) {
                    countOfRooms++;
                    matrix[countOfRooms][0] = matrix[countOfRooms - 1][0] + ((i + 1) % 2) * (i - 1);
                    matrix[countOfRooms][1] = matrix[countOfRooms - 1][1] + (i % 2) * (i - 2);
                }
            }
        }
        while (countOfRooms < 6) {
            //System.out.println(countOfRooms);
            //System.out.println("flag");
            while (matrix[countOfRooms + 1][0] == 0 && matrix[countOfRooms + 1][1] == 0) {
                for (int i = 0; i < 4; i++) {
                    boolean canGenerate = true;
                    for (int j = 0; j < 10; j++) {
                        if (matrix[countOfRooms][0] + ((i + 1) % 2) * (i - 1) == matrix[j][0] && matrix[countOfRooms][1] + (i % 2) * (i - 2) == matrix[j][1]) {
                            canGenerate = false;
//                            System.out.println((matrix[countOfRooms][0] + ((i + 1) % 2) * (i - 1)) + " " + (matrix[countOfRooms][1] + (i % 2) * (i - 2)));
                            break;
                        }
//                        else System.out.println(matrix[j][1]);
                    }
                    System.out.println(canGenerate);
                    if (random.nextBoolean() && canGenerate) {
                        matrix[countOfRooms + 1][0] = matrix[countOfRooms][0] + ((i + 1) % 2) * (i - 1);
                        matrix[countOfRooms + 1][1] = matrix[countOfRooms][1] + (i % 2) * (i - 2);
                        break;
                    }
                }
            }
            countOfRooms++;
            if (countOfRooms >= 6){
                for (int i = 0; i < countOfRooms; i++){
                    System.out.println(matrix[i][0] + " " + matrix[i][1]);
                }
                return;
            }
        }

    }*/
    private void generate(){
        matrix[5][5] = true;
        /*while (countOfRooms <= 1){
            for (int i = 0; i < 4; i++){
//                System.out.println(i);
                if(random.nextBoolean()) {
                    if (i % 2 == 0) matrix[countOfRooms][0] = i - 1;
                    else matrix[countOfRooms][1] = i - 2;
                    countOfRooms++;
                }
            }
        }*/
        while (countOfRooms < 6){
            for (int x = 0; x < 11; x++){
                for (int y = 0; y < 11; y++){
                    if(matrix[x][y]){
                        if(random.nextBoolean() && !matrix[x - 1][y]){
                            matrix[x - 1][y] = true;
                            countOfRooms++;
                            if(countOfRooms >= 6) return;
                        }
                        if(random.nextBoolean() && !matrix[x + 1][y]){
                            matrix[x + 1][y] = true;
                            countOfRooms++;
                            if(countOfRooms >= 6) return;
                        }
                        if(random.nextBoolean() && !matrix[x][y - 1]){
                            matrix[x][y - 1] = true;
                            countOfRooms++;
                            if(countOfRooms >= 6) return;
                        }
                        if(random.nextBoolean() && !matrix[x][y + 1]){
                            matrix[x][y + 1] = true;
                            countOfRooms++;
                            if(countOfRooms >= 6) return;
                        }
                    }
                }
            }
        }
    }
}

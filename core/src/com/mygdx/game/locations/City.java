package com.mygdx.game.locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.util.Random;

public class City extends Locations {
    Sprite fourWaysRoom;
    Sprite treeWaysRoom;
    Sprite twoWaysRoom1;
    Sprite twoWaysRoom2;
    Sprite oneWaysRoom;
    Sprite road;
    Random random;
    int countOfRooms = 0;
    boolean[][] matrix = new boolean[12][12];

    public City() {
        title = "Захваченный город";
        description = "В этот город прилетели пришельцы, полностью зачищен от людей. В ценре стоит их замок - космический корабль";
        random = new Random();
        fourWaysRoom = new Sprite(new Texture("textures/locations/1_city/room_1_floor.png"));
        fourWaysRoom.setOrigin(456, 456);
        fourWaysRoom.scale(MyGdxGame.scaleBullet);
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
                if(matrix[i][j]){
                    fourWaysRoom.setPosition((i - 6) * 456 * 2 * MyGdxGame.scaleBullet + MyGdxGame.SCR_WIDTH / 2, (j - 6) * 456 * 2 * MyGdxGame.scaleBullet + MyGdxGame.SCR_HEIGHT / 2);
                    fourWaysRoom.draw(batch);
                }
            }
        }
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

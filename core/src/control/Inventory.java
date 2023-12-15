package control;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.items.weapon.Gun;

public class Inventory {
    public static float heightInventory = 47, widhtInventory = 77;
    Texture inventoryTexture;

    public Inventory() {
        inventoryTexture = new Texture("textures/gui/inventory.png");
    }
    public void draw(SpriteBatch batch, float cx, float cy) {
        batch.draw(inventoryTexture, cx - widhtInventory*13/2, cy-MyGdxGame.SCR_HEIGHT/2+Continue.heightContinue*15, widhtInventory*13, heightInventory*13);
    }
}

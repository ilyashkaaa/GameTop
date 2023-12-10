package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	public OrthographicCamera camera;
	ScreenGame screenGame;

	public static int SCR_WIDTH, SCR_HEIGHT;

	
	@Override
	public void create () {
		SCR_WIDTH = Gdx.graphics.getWidth();
		SCR_HEIGHT = Gdx.graphics.getHeight();
//		SCR_WIDTH = 1080;
//		SCR_HEIGHT = 720;

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		screenGame = new ScreenGame(this);
		setScreen(screenGame);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

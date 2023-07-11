package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends Game {
	public SpriteBatch batch;

	@Override
	public void create() {
		ScreenViewport vp;
		Stage stage;
		vp = new ScreenViewport();
		stage = new Stage(vp);
		setScreen(new MenuScreen(this));
		batch = new SpriteBatch();
	}

	public void render(){
		super.render();
	}
}
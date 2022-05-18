package com.moonjew.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.moonjew.engine.states.GameStateManager;
import com.moonjew.engine.states.TestState;

public class Main extends ApplicationAdapter {
	private SpriteBatch sb;
	private GameStateManager gsm;
	Texture img;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GameStateManager(new OrthographicCamera(), sb);
		img = new Texture("badlogic.jpg");

		gsm.push(new TestState(gsm, new Color(1,0.5f,1,0.5f)));
	}

	@Override
	public void render() {
//		ScreenUtils.clear(1, 0, 0, 1);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		img.dispose();
	}
}

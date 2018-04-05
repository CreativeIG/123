package com.company.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.w3c.dom.css.Rect;

import java.awt.Rectangle;

public class carts extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Rectangle cart;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("snowman.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
		cart = new Rectangle();
		cart.x = 800/2-256;
		cart.y=480/2-256;
		cart.height=256;
		cart.width=256;


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img,cart.x,cart.y);
		batch.end();
		

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) cart.x= cart.x- 200;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) cart.x = cart.x + 200;

		if(cart.x>500 ) cart.x=500;
		if(cart.x<100 ) cart.x=300;

	}
}

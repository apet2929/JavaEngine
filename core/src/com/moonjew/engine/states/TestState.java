package com.moonjew.engine.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class TestState extends State{
    Color color;
    Rectangle rect;
    Texture test;
    public static final ShapeRenderer SR = new ShapeRenderer();
    public TestState(GameStateManager gsm, Color color) {
        super(gsm);
        this.color = color;
        int startX = (int)(Math.random() * Gdx.graphics.getWidth());
        int startY = (int)(Math.random() * Gdx.graphics.getHeight());
        this.rect = new Rectangle(startX, startY, 100, 100);
    }

    @Override
    public void show() {
        System.out.println("TestState Show!");
        test = gsm.assetManager.getTexture("badlogic.jpg");
    }

    @Override
    public void update(float delta) {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            gsm.push(new TransitionState(gsm, 2, false));
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        SR.begin(ShapeRenderer.ShapeType.Filled);
        SR.setColor(color);
        SR.rect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
        SR.end();
        sb.begin();
        sb.draw(test, 0,0,100,100);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

package com.moonjew.engine.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestState extends State{
    Color color;
    Rectangle rect;
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
    }

    @Override
    public void update(float delta) {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            gsm.push(new TestState(gsm, new Color(0,0,1,0.5f)));
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        SR.begin(ShapeRenderer.ShapeType.Filled);
        SR.setColor(color);
        SR.rect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
        SR.end();
    }

    @Override
    public void dispose() {

    }
}

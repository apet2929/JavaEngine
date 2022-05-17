package com.moonjew.engine.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Stack;

public class GameStateManager  {
    private final Stack<State> states;

    public OrthographicCamera cam;
    public SpriteBatch sb;
    public ShapeRenderer sr;

    public GameStateManager(OrthographicCamera cam, SpriteBatch sb) {
        this.states = new Stack<>();
        this.cam = cam;
        this.sb = sb;
        this.sr = new ShapeRenderer();
    }

    public State peek(){
        return states.peek();
    }

    public State pop(){
        State state = states.pop();
        state.hide();
        return states.pop();
    }

    public void push(State state){
        states.push(state);
        state.show();
    }

    public void update(float delta){
        states.peek().update(delta);
        
    }

    public void render(){
        for (State state : states) {
            state.draw(sb);
        }
    }




}

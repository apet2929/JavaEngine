package com.moonjew.engine.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.moonjew.engine.states.GameStateManager;

public abstract class UIComponent {
    private final GameStateManager gsm;
    public UIComponent(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void draw(Batch batch);

}

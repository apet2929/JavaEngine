package com.moonjew.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Utils {
    public static void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);
    }
}

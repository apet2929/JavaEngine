package com.moonjew.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class AssetManager {
    private HashMap<String, Texture> textures;
    public AssetManager() {
        textures = new HashMap<>();
        textures.put("NOT_FOUND", new Texture("NOT_FOUND.jpg"));
    }

    public Texture getTexture(String path){
        if(textures.containsKey(path)){
            return textures.get(path);
        } else {
            return tryLoadTexture(path);
        }
    }

    private Texture tryLoadTexture(String path){
        try {
            Texture texture = new Texture(path);
            textures.put(path, texture);
            System.out.println("Texture " + path + " loaded successfully.");
            return texture;
        } catch (GdxRuntimeException e){
            System.err.println("Texture load failed! error = " + e);
            return getNotFoundTexture();
        }
    }

    public Texture getNotFoundTexture(){
        return textures.get("NOT_FOUND");
    }
}

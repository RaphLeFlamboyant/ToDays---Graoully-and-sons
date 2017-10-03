package com.ggj16.days.view.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.ggj16.days.utils.AssetsLoader;

/**
 * Created by Reborn Portable on 29/01/2016.
 */
public class MapView {
    int id;
    String textureName;
    boolean isVisible;
    Vector2 position = new Vector2();

    public MapView(String texName)
    {
        textureName = texName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public TextureRegion getTextureRegion()
    {
        return (AssetsLoader.getTextureRegion(textureName));
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }
}

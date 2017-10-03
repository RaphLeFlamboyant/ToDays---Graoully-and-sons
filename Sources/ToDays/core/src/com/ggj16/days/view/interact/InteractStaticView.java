package com.ggj16.days.view.interact;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.model.InteractModel;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.drawable.ITextured;

/**
 * Created by Reborn Portable on 29/01/2016.
 */
public class InteractStaticView implements ITextured {
    int interactID;
    InteractModel model;
    String textureRegionName;
    Vector2 position = new Vector2();
    Vector2 offset = new Vector2();

    public InteractStaticView(InteractModel model)
    {
        this.model = model;
    }

    public int getInteractID() {
        return interactID;
    }

    public void setInteractID(int interactID) {
        this.interactID = interactID;
    }

    public String getTextureRegionName() {
        return textureRegionName;
    }

    public void setTextureRegionName(String textureRegionName) {
        this.textureRegionName = textureRegionName;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        position.y = y;
    }

    public Vector2 getOffset() {
        return offset;
    }

    public void setOffset(float x, float y) {
        this.offset.x = x;
        offset.y = y;
    }

    @Override
    public TextureRegion getTextureRegion(float delta) {
        return AssetsLoader.getTextureRegion(textureRegionName);
    }
}

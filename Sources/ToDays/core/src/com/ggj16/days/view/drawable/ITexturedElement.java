package com.ggj16.days.view.drawable;

import com.badlogic.gdx.math.Vector2;
import com.ggj16.days.view.EDirection;

/**
 * Created by Reborn Portable on 29/01/2016.
 */
public interface ITexturedElement extends ITextured {
    Vector2 getPosition();
    void setPosition(float x, float y);

    Vector2 getOffset();
    void setOffset(float x, float y);


    EDirection getDirection();
    void setDirection(EDirection dir);
}

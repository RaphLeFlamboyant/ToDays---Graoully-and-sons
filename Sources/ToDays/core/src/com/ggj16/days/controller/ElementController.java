package com.ggj16.days.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class ElementController {
    private int eltID;
    private Vector2 virtualCoordinates = new Vector2();
    private Array<Vector2> fulls = new Array<Vector2>();
    private boolean colides;
    private boolean intercepts;

    public Vector2 getVirtualCoordinates() {
        return virtualCoordinates;
    }

    public void setVirtualCoordinates(float x, float y) {
        this.virtualCoordinates.x = x;
        this.virtualCoordinates.y = y;
    }

    public boolean colides() {
        return colides;
    }

    public void setColides(boolean colides) {
        this.colides = colides;
    }

    public boolean intercepts() {
        return intercepts;
    }

    public void setIntercepts(boolean intercepts) {
        this.intercepts = intercepts;
    }

    public int getEltID() {
        return eltID;
    }

    public void setEltID(int eltID) {
        this.eltID = eltID;
    }

    public Array<Vector2> getFulls() {
        return fulls;
    }

    public void setFulls(Array<Vector2> fulls) {
        this.fulls = fulls;
    }
}

package com.ggj16.days.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.scripts.ActionScript;

/**
 * Created by Florian on 29/01/2016.
 */
public class InteractEventModel {
    Array<Integer> listIds;
    int weight;
    ActionScript scripts;
    int scriptID;
    Vector2 coordinates = new Vector2();
    String viewName; //gros hack dégueu

    public InteractEventModel(ActionScript scripts, int scriptID){
        this.listIds = new Array<Integer>();
        this.weight = 0;
        this.scripts = scripts;
        this.scriptID = scriptID;
    }

    public void launchScript()
    {
        scripts.launchScript(scriptID);
    }

    public Array<Integer> getListIds() {
        return listIds;
    }

    public void setListIds(Array<Integer> listIds) {
        this.listIds = listIds;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vector2 getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float x, float y) {
        this.coordinates.x = x;
        coordinates.y = y;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}

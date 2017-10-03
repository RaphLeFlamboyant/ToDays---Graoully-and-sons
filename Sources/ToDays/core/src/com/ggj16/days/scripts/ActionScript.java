package com.ggj16.days.scripts;

import com.badlogic.gdx.InputProcessor;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public abstract class ActionScript implements InputProcessor {
    protected ToDaysController controller;
    protected ToDaysWorld world;
    protected ToDaysRenderer renderer;
    protected ToDaysScreen screen;
    protected int linkedID;

    protected int currentScriptID;

    public ActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id)
    {
        this.controller = controller;
        this.world = world;
        this.renderer = renderer;
        this.screen = screen;
        linkedID = id;
    }

    public void launchScript(int scriptID)
    {
        controller.setCurrentScript(this);
        currentScriptID = scriptID;
    }

    //returns true while running
    public abstract boolean update(float delta);
}

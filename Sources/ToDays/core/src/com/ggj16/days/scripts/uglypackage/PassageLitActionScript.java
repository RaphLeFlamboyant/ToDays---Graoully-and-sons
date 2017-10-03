package com.ggj16.days.scripts.uglypackage;

import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.controller.tools.ControllerHelper;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 31/01/2016.
 */
public class PassageLitActionScript extends ActionScript {
    public PassageLitActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
        super(controller, world, renderer, screen, id);
    }

    private int step;

    @Override
    public boolean update(float delta) {
        if (this.currentScriptID == 0)
            return false;
        if (this.currentScriptID == 1)
            return update1();
        if (this.currentScriptID == 2)
            return false;

        return false;
    }

    private boolean update1()
    {
        if (step == 0)
        {
            return true;
        }

        return false;
    }

    @Override
    public void launchScript(int scriptID) {
        super.launchScript(scriptID);

        if (scriptID == 0) {
        }
        if (scriptID == 1) {
            step = 0;
            renderer.setTextToDraw("Bob, à bout de forces, se traîne difficilement jusqu'à son lit...", 0);
        }
        if (scriptID == 2) {
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (step == 0 && currentScriptID == 1)
        {
            ControllerHelper.getElementFromID(controller.getMap().getElements(), 7).setIntercepts(false);
            world.getListEvents().set(11, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

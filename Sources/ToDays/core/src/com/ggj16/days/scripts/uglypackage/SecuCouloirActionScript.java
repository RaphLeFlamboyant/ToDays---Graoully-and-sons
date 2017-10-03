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
public class SecuCouloirActionScript extends ActionScript {
    public SecuCouloirActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
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
            return update2();
        if (this.currentScriptID == 3)
            return false;

        return false;
    }

    private boolean update1()
    {
        if (step == 0 || step == 2)
        {
            return true;
        }

        if (step == 1)
        {
            if (controller.pathFindingOver() && renderer.getPlayerView().reachedTarget())
            {
                step++;
                renderer.setTextToDraw("Faisant demi-tour, Bob avance de nouveau vers le miroir.", 0);
            }

            return true;
        }

        return false;
    }

    private boolean update2()
    {
        if (step == 0 || step == 2 || step == 3)
        {
            return true;
        }

        if (step == 1)
        {
            if (controller.pathFindingOver() && renderer.getPlayerView().reachedTarget())
            {
                step++;
                renderer.setTextToDraw("Bob est cette fois fermement décidé à lire sa petite liste de tâche.", 0);
            }

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
            renderer.setTextToDraw("\"Je ferrai mieux d'aller voir ce que j'ai à faire avant de commencer ma journée...\"", 1);
        }
        if (scriptID == 2) {
            step = 0;
            renderer.setTextToDraw("\"Non sérieusement... c'est une mauvaise idée de commencer ma journée sans savoir quoi faire !\"", 1);
        }
        if (scriptID == 3) {
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
            step ++;
            renderer.setTextToDraw("", -1);
            controller.movePlayer(403, 408);
            return true;
        }

        if (step == 1 && currentScriptID == 1)
        {
            return true;
        }
        if (step == 2 && currentScriptID == 1)
        {
            world.getListEvents().set(2, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 2)
        {
            step ++;
            renderer.setTextToDraw("", -1);
            controller.movePlayer(403, 407);
            return true;
        }

        if (step == 1 && currentScriptID == 2)
        {
            return true;
        }
        if (step == 2 && currentScriptID == 2)
        {
            step ++;
            renderer.setTextToDraw("Jour 1 :\n" +
                    "        Prendre une douche\n" +
                    "        Manger\n" +
                    "        Travailler\n" +
                    "        Se coucher tôt", 2);
            return true;
        }
        if (step == 3 && currentScriptID == 2)
        {
            ControllerHelper.getElementFromID(controller.getMap().getElements(), 1).setIntercepts(false);
            world.getListEvents().set(3, true);
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

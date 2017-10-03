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
public class MainMirrorActionScript extends ActionScript {
    public MainMirrorActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
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

        return false;
    }

    private boolean update1()
    {
        if (step == 0 || step == 1)
        {
            return true;
        }

        return false;
    }

    private boolean update2()
    {
        if (step == 0 || step == 1)
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
            renderer.setTextToDraw("Jour 1 :\n" +
                    "        Prendre une douche\n" +
                    "        Manger\n" +
                    "        Travailler\n" +
                    "        Se coucher tôt", 2);
        }
        if (scriptID == 2) {
            step = 0;
            renderer.setTextToDraw("Jour 2 :\n" +
                    "        Prendre une douche\n" +
                    "        Manger\n" +
                    "        Travailler\n" +
                    "        Se coucher tôt", 2);
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
            step++;
            renderer.setTextToDraw("\"D'abord, me débarbouiller. J'irai manger un morceau après.\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            ControllerHelper.getElementFromID(controller.getMap().getElements(), 1).setIntercepts(false);
            world.getListEvents().set(3, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 2)
        {
            step++;
            renderer.setTextToDraw("\"Pas cette fois encore… La prochaine peut être? C’est partie pour une bonne douche… ou manger? Je pourrais très bien me mettre " +
                    "au boulot tout de suite. Quoi que je fasse, ça ne change pas grand-chose en fait...\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 2)
        {
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

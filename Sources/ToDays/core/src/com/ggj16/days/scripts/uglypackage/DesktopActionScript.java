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
public class DesktopActionScript  extends ActionScript {
    public DesktopActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
        super(controller, world, renderer, screen, id);
    }

    private int step;

    @Override
    public boolean update(float delta) {
        if (this.currentScriptID == 1)
            return update1();
        if (this.currentScriptID == 2)
            return false;
        if (this.currentScriptID == 3)
            return update3();
        if (this.currentScriptID == 4)
            return false;

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

    private boolean update3()
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

        if (scriptID == 1) {
            step = 0;
            renderer.setTextToDraw("De la paperasse, du code, et des jeux vidéo. Une nouvelle journée de travail bien remplie qui s’achève. Notre Bob éreinté ressent l'appel de son lit.", 0);
        }
        if (scriptID == 2) {
        }
        if (scriptID == 3) {
            step = 0;
            renderer.setTextToDraw("Du travail, du travail, encore du travail… bob n’a pas un moment de répit. Le clavier et la plume comme seul arme," +
                    " il bâcle les dossiers presque systématiquement.Il finit par se poser au fond de sa chaise", 0);
        }
        if (scriptID == 4) {
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
            renderer.setTextToDraw("\"Crevé... toujours...pareil...vais me coucher.\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            ControllerHelper.getElementFromID(controller.getMap().getElements(), 7).setIntercepts(true);
            world.getListEvents().set(10, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 3)
        {
            step++;
            renderer.setTextToDraw("\"Crevant… C’est toujours pareil. Je ferai mieux d’aller me coucher directement.\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 3)
        {
            world.getListEvents().set(27, true);
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

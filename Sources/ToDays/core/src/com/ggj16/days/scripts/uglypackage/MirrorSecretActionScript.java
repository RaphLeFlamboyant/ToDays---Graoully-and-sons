package com.ggj16.days.scripts.uglypackage;

import com.badlogic.gdx.Gdx;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 31/01/2016.
 */
public class MirrorSecretActionScript extends ActionScript {
    public MirrorSecretActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
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

        if (step == 4 &&  controller.pathFindingOver() && renderer.getPlayerView().reachedTarget())
        {
            renderer.setTextToDraw("\"Je savais bien que cette voix, tous les jours, n’était pas juste un bruit de fond de mon esprit... Qui es-tu? Que fais-tu ici?\"", 1);
            step++;
            return true;
        }

        if (step == 11 && renderer.transitionDone())//
        {
            renderer.setTextToDraw("Mais est-on réellement libre de ses choix?", 0);
            step++;
            return true;
        }

        if (step < 14)
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
            renderer.setTextToDraw("“Bob fait demi-tour et s’éloigne du miroir", 0);
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
            step++;
            renderer.setTextToDraw("(Bob passe sa mains sur le miroir)\" On dirait qu’il y a quelque chose de l’autre côté.\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("Eloigne toi du miroir j’ai dit !", 0);
            return true;
        }
        if (step == 2 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("(Bob recule d’un pas, et fonce sur le miroir épaule en avant. Il passe au travers.) Schblink! ", 1);
            return true;
        }
        if (step == 3 && currentScriptID == 1)
        {
            step++;
            world.getListEvents().set(31, true);
            screen.regenerate();

            controller.movePlayer(414, 406);
            return true;
        }
        if (step == 4 && currentScriptID == 8)
        {
            return true;
        }
        if (step == 5 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Qui je suis? Mais… je suis toi! Une simple forme que tu as créé et qui t’aide chaque jour à prendre de bonnes décisions et garder de bonnes habitudes !\"", 0);
            return true;
        }
        if (step == 6 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Et si je ne veux plus ?\"", 1);
            return true;
        }
        if (step == 7 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Difficile de changer ses habitudes, non ?\"", 0);
            return true;
        }
        if (step == 8 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Tu as raison. Il vaut mieux que je commence tout de suite. (Bob frappe son double qui disparaît).\"", 1);

            return true;
        }
        if (step == 9 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Fini pour toujours les routines. Je me barre d’ici. Et tu n’es plus là pour m’en empêcher!\"", 1);
            world.getListEvents().set(32, true);
            screen.regenerate();
            return true;
        }
        if (step == 10 && currentScriptID == 1)
        {
            step++;
            renderer.activateNightTransition(true);
            AssetsLoader.getMusic("gameMusic").stop();
            renderer.setTextToDraw("", -1);
            return true;
        }
        if (step == 11 && currentScriptID == 1)
        {
            return true;
        }
        if (step == 12 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("", -1);
            //quitte le texte met les credits
            return true;
        }
        if (step == 13 && currentScriptID == 1)
        {
            step++;
            Gdx.app.exit();
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

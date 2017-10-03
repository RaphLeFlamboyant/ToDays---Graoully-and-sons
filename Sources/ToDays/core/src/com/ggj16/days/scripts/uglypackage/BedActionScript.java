package com.ggj16.days.scripts.uglypackage;

import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.controller.tools.ControllerHelper;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class BedActionScript extends ActionScript {
    public BedActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
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
            return update4();
        if (this.currentScriptID == 5)
            return update5();
        if (this.currentScriptID == 6)
            return false;


        return false;
    }

    private boolean update1()
    {
        if (step == 0 && renderer.transitionDone())//TODO
        {
            renderer.setTextToDraw("Doucement, Bob s'éveille. Une nouvelle journée commence.", 0);
            step++;
            return true;
        }

        if (step < 5)
        {
            return true;
        }

        return false;
    }

    private boolean update3()
    {
        if (step == 0 && renderer.transitionDone())//TODO
        {
            world.getListEvents().set(24, true);
            screen.regenerate();
            renderer.activateNightTransition(false);
            AssetsLoader.getMusic("gameMusic").play();
            step++;
            return true;
        }
        if (step == 1 && renderer.transitionDone())//TODO
        {
            renderer.setTextToDraw("Doucement, Bob s'éveille. Une nouvelle journée commence.", 0);
            step++;
            return true;
        }
        if (step < 6)
            return true;

        return false;
    }

    private boolean update4()
    {
        if (step == 0 && renderer.transitionDone())//TODO
        {
            world.getListEvents().set(25, false);
            world.getListEvents().set(26, false);
            world.getListEvents().set(27, false);
            screen.regenerate();
            renderer.activateNightTransition(false);
            AssetsLoader.getMusic("gameMusic").play();
            step++;
            return true;
        }
        if (step == 1 && renderer.transitionDone())//TODO
        {
            step++;
            return true;
        }
        if (step < 2)
            return true;

        return false;
    }

    private boolean update5()
    {
        if (step == 0 && renderer.transitionDone())//
        {
            world.getListEvents().set(29, true);
            screen.regenerate();
            renderer.activateNightTransition(false);
            AssetsLoader.getMusic("gameMusic").play();
            step++;
            return true;
        }
        if (step == 1 && renderer.transitionDone())//
        {
            renderer.setTextToDraw("Bob se réveille soudainement. Il semble affamé.", 0);
            step++;
            return true;
        }
        if (step < 4)
            return true;

        return false;
    }

    @Override
    public void launchScript(int scriptID) {
        super.launchScript(scriptID);

        if (scriptID == 1) {
            step = 0;
            renderer.activateNightTransition(false);
        }
        if (scriptID == 2) {
        }
        if (scriptID == 3) {
            step = 0;
            renderer.activateNightTransition(true);
            AssetsLoader.getMusic("gameMusic").stop();
        }
        if (scriptID == 4) {
            step = 0;
            renderer.activateNightTransition(true);
            AssetsLoader.getMusic("gameMusic").stop();
        }
        if (scriptID == 5) {
            step = 0;
            renderer.activateNightTransition(true);
            AssetsLoader.getMusic("gameMusic").stop();
        }
        if (scriptID == 6) {
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
        if (step == 0 && currentScriptID == 1) {
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            step ++;
            renderer.setTextToDraw("\"Une journée de plus...\"", 1);
            return true;
        }
        if (step == 2 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("Comme à l'accoutumée, une fois assis sur le bord de son lit, il enfile en premier sa pantoufle" +
                    " droite, puis la gauche. Une banale histoire de superstition...", 0);
            return true;
        }
        if (step == 3 && currentScriptID == 1)
        {
            step++;
            renderer.setTextToDraw("\"Bon, voyons voir ce que j'ai à faire aujourd'hui.\"", 1);
            return true;
        }
        if (step == 4 && currentScriptID == 1)
        {
            ControllerHelper.getElementFromID(controller.getMap().getElements(), 1).setIntercepts(true);
            world.getListEvents().set(1, true);
            screen.regenerate();

            renderer.setTextToDraw("", -1);
            step++;
            return true;
        }


        if (step == 0 && currentScriptID == 2) {
            return false;
        }



        if (step == 0 && currentScriptID == 3)
        {
            return true;
        }
        if (step == 1 && currentScriptID == 3)
        {
            return true;
        }
        if (step == 2 && currentScriptID == 3)
        {
            step ++;
            renderer.setTextToDraw("\"J’ai un de ces mal de crâne ce matin… J’ai comme un déjà vu en plus...\"", 1);
            return true;
        }
        if (step == 3 && currentScriptID == 3)
        {
            step++;
            renderer.setTextToDraw("Comme à l'accoutumée, une fois assis sur le bord de son lit, il enfile en premier sa pantoufle droite, " +
                    "puis la gauche. Une banale histoire de superstition… il tourne alors la tête sur la gauche et observe le miroir et le post-it.", 0);
            return true;
        }
        if (step == 4 && currentScriptID == 3)
        {
            step++;
            renderer.setTextToDraw("\"Ouais ouais je sais… se doucher, manger, travailler. Tu ne m’apprends rien morceau de papier… " +
                    "mais… cette fois peut être? Bha… ça vauts toujours le coup de jeter un coup d’oeil, non?\n\"", 1);
            return true;
        }
        if (step == 5 && currentScriptID == 3)
        {

            renderer.setTextToDraw("", -1);
            step++;
            return true;
        }


        if (step == 0 && currentScriptID == 4)
        {
            return true;
        }
        if (step == 1 && currentScriptID == 4)
        {
            return true;
        }


        if (step == 0 && currentScriptID == 5)
        {
            return true;
        }
        if (step == 1 && currentScriptID == 5)
        {
            return true;
        }
        if (step == 2 && currentScriptID == 5)
        {
            step++;
            renderer.setTextToDraw("\"Je savais que les anchois n’allaient pas suffire… J’vais aller me faire un casse-croûte.\"", 1);
            return true;
        }
        if (step == 3 && currentScriptID == 5)
        {
            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }

        if (currentScriptID == 6)
        {
            return false;
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

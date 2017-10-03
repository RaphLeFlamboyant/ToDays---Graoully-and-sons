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
public class KitchenActionScript extends ActionScript {
    public KitchenActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
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
            return update3();
        if (this.currentScriptID == 4)
            return update4();
        if (this.currentScriptID == 5)
            return false;
        if (this.currentScriptID == 6)
            return update6();
        if (this.currentScriptID == 7)
            return false;
        if (this.currentScriptID == 8)
            return update8();
        if (this.currentScriptID == 9)
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

    private boolean update2()
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

        if (step == 2)
        {
            if (controller.pathFindingOver() && renderer.getPlayerView().reachedTarget())
            {
                world.getListEvents().set(8, true);
                screen.regenerate();

                step++;
                renderer.setTextToDraw("", -1);
            }

            return true;
        }

        return false;
    }

    private boolean update4()
    {
        if (step == 0 || step == 1 || step == 2)
        {
            return true;
        }

        return false;
    }

    private boolean update6()
    {
        if (step == 0 || step == 1)
        {
            return true;
        }

        return false;
    }

    private boolean update8()
    {
        if (step ==  1)
        {
            if (controller.pathFindingOver() && renderer.getPlayerView().reachedTarget())
            {
                renderer.setTextToDraw("\"Ce miroir, je me suis toujours demandé si…\"", 1);
                step++;
            }
            return true;
        }

        if (step < 3)
            return true;

        return false;
    }

    @Override
    public void launchScript(int scriptID) {
        super.launchScript(scriptID);

        if (scriptID == 0) {
        }
        if (scriptID == 1) {
            step = 0;
            renderer.setTextToDraw("\"Il vaut mieux que je me lave d'abord. Je suis tout poisseux, je ne veux pas cuisiner comme ça\"", 1);
        }
        if (scriptID == 2) {
            step = 0;
            renderer.setTextToDraw("\"Encore une fois, j'aimerais me laver en premier. En plus, si c'est dans cet ordre sur la liste, c'est qu'il y a une raison.\"", 1);
        }
        if (scriptID == 3) {
            step = 0;
            renderer.setTextToDraw("\"Je vais me laver, point.\"", 1);
        }
        if (scriptID == 4) {
            step = 0;
            renderer.setTextToDraw("Bob pose une main sur le plan de travail, la glisse sur le rebord puis commence à se préparer un petit repas très simple.", 0);
        }
        if (scriptID == 5) {
        }
        if (scriptID == 6) {
            step = 0;
            renderer.setTextToDraw("Bob pose une main sur le plan de travail, la glisse machinalement sur le rebord puis commence à se préparer un petit repas très simple.", 0);
        }
        if (scriptID == 7) {
        }
        if (scriptID == 8) {
            step = 0;
            renderer.setTextToDraw("Après avoir ouvert son frigo, bob se confectionne un sandwich de l’amour de Dieu composé de multitude d’ingrédient diver et varié à en assommer un " +
                    "Développeur. En se retournant, au moment de croquer dans son sandwich, le mirroir à sa gauche semble l’intrigué plus que " +
                    "d’habitude. Mais il n’y continue de retourner vers sa chambre", 0);
        }
        if (scriptID == 9) {
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
            renderer.setTextToDraw("Bien qu'affamé, l'hygiène avant tout ! Bob décide d'aller se doucher avant de se préparer un repas.", 0);
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            world.getListEvents().set(4, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 2)
        {
            step++;
            renderer.setTextToDraw("Tout en s’interrogeant sur la perte de temps que causerait un nouvel aller-retour cuisine, salle de bain, Bob continue de regarder fixement sa plaque de cuisson.", 0);
            return true;
        }
        if (step == 1 && currentScriptID == 2)
        {
            world.getListEvents().set(5, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 3)
        {
            step++;
            renderer.setTextToDraw("Enfin une bonne décision ! Notre Bob s'élance vers la salle de bain, et la douche qui l'attend.", 0);
            return true;
        }
        if (step == 1 && currentScriptID == 3)
        {
            controller.movePlayer(403, 412);

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }
        if (step == 2 && currentScriptID == 3)
        {
            return true;
        }


        if (step == 0 && currentScriptID == 4)
        {
            step++;
            renderer.setTextToDraw("\"Rien ne vauts un bon sandwich... aux anchoix.\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 4)
        {
            step++;
            renderer.setTextToDraw("Le ventre plein, bob part en direction de son bureau pour se mettre au travail. Un rapide regard dans le miroir de la cuisine, et il est partie.", 0);
            return true;
        }
        if (step == 2 && currentScriptID == 4)
        {
            world.getListEvents().set(9, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }


        if (step == 0 && currentScriptID == 6)
        {
            step++;
            renderer.setTextToDraw("\"Des anchois? Vraiment? Mais c’est dégueulasse les anchois...pourquoi je mange ça moi...\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 6)
        {
            world.getListEvents().set(26, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }

        if (step == 0 && currentScriptID == 8)
        {
            controller.movePlayer(411, 406);

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }
        if (step == 1 && currentScriptID == 8)
        {
            return true;
        }
        if (step == 2 && currentScriptID == 8)
        {
            world.getListEvents().set(30, true);
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

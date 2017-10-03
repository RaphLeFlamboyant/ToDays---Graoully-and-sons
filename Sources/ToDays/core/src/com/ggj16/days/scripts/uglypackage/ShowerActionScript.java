package com.ggj16.days.scripts.uglypackage;

import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 31/01/2016.
 */
public class ShowerActionScript extends ActionScript {
    public ShowerActionScript(ToDaysController controller, ToDaysWorld world, ToDaysRenderer renderer, ToDaysScreen screen, int id) {
        super(controller, world, renderer, screen, id);
    }

    private int step;

    @Override
    public boolean update(float delta) {
        if (this.currentScriptID == 1)
            return update1();
        if (this.currentScriptID == 2)
            return update2();
        if (this.currentScriptID == 3)
            return false;
        if (this.currentScriptID == 4)
            return update4();
        if (this.currentScriptID == 5)
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

    private boolean update4()
    {
        if (step == 0 || step == 1 || step == 2 || step == 3)
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
            renderer.setTextToDraw("Bob se glisse dans la douche, frottant sa barbe sous l'eau chaude. Un passage au sèche-cheveux, et le poil est aussi soyeux qu'avant !", 0);
        }
        if (scriptID == 2) {
            step = 0;
            renderer.setTextToDraw("Bob se glisse dans la douche, frottant sa barbe sous l'eau chaude. Un passage au sèche-cheveux, et le poil est aussi soyeux qu'avant !", 0);
        }
        if (scriptID == 3) {
        }
        if (scriptID == 4) {
            step = 0;
            renderer.setTextToDraw("Bob sous l’eau chaude semble pensif.", 0);
        }
        if (scriptID == 5) {
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
            renderer.setTextToDraw("\"Une bonne chose de faite, allons manger !\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 1)
        {
            world.getListEvents().set(7, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }

        if (step == 0 && currentScriptID == 2)
        {
            step++;
            renderer.setTextToDraw("\"Maintenant, je peux enfin aller manger un morceau !\"", 1);
            return true;
        }
        if (step == 1 && currentScriptID == 2)
        {
            world.getListEvents().set(7, true);
            screen.regenerate();

            step++;
            renderer.setTextToDraw("", -1);
            return true;
        }

        if (step == 0 && currentScriptID == 4)
        {
            step++;
            renderer.setTextToDraw("\"J’ai beau réfléchir, j’ai vraiment du mal à me souvenir d’hier… je devais être exténué, j’ai dû tomber " +
                    "comme une masse sur mon lit. Ce post-it, j’ai beau le jeter, il revient toujours...\"", 1);
            return true;
        }

        if (step == 1 && currentScriptID == 4)
        {
            step++;
            renderer.setTextToDraw("“Il coupe l’eau, sort de la douche et se sèche vigoureusement la barbe avant d’enfiler une tenue decontractée.", 0);
            return true;
        }

        if (step == 2 && currentScriptID == 4)
        {
            step++;
            renderer.setTextToDraw("\"On est quand même nettement mieux après une douche chaude…\"", 1);
            return true;
        }
        if (step == 3 && currentScriptID == 4)
        {
            world.getListEvents().set(25, true);
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

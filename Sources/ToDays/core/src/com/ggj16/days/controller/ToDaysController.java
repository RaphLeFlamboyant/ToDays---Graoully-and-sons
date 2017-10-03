package com.ggj16.days.controller;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.ggj16.days.ToDaysGame;
import com.ggj16.days.controller.tools.ControllerHelper;
import com.ggj16.days.debug.DebugHelper;
import com.ggj16.days.model.InteractEventModel;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.view.ToDaysRenderer;
import com.ggj16.days.view.character.CharacterView;
import com.ggj16.days.view.tools.RendererUtils;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class ToDaysController  implements InputProcessor {
    private MapController map = new MapController();
    private ToDaysRenderer renderer;
    private ToDaysWorld world;
    private ToDaysScreen owner;
    private OrthographicCamera camera;
    private ActionScript currentScript;

    private CharacterController character = new CharacterController();

    private ElementController elementToReach;
    private Array<Vector2> pathFinding = new Array<Vector2>();

    public ToDaysController(ToDaysScreen toDaysScreen, ToDaysWorld w, ToDaysRenderer r, OrthographicCamera cam) {
        world = w;
        renderer = r;
        camera = cam;
        owner = toDaysScreen;
    }

    public void launchGame()
    {
        world.getEventModelFromID(0).launchScript();
    }

    public void update (float delta) {
        camera.position.x = renderer.getPlayerView().getPosition().x;
        camera.position.y = renderer.getPlayerView().getPosition().y;


        Vector2 vPos = RendererUtils.toVirtualPosition(renderer.getPlayerView().getPosition());
        vPos.y += 1;
        if (renderer.getPlayerView().reachedTarget() && pathFinding.size == 0 && !vPos.equals(character.getVirtualCoordinates()))
        {
            //if (vPos.x < 0 || vPos.y < 0)
            //    vPos = vPos;
            Vector2 vPos2 = RendererUtils.toVirtualPosition(renderer.getPlayerView().getPosition());
            vPos2.y += 1;
            character.setVirtualCoordinates(vPos.x, vPos.y);

            if (vPos.x < 0 )
                vPos.x +=0;
        }

        if (renderer.getPlayerView().reachedTarget() && pathFinding.size == 0 && elementToReach != null) {
            world.getEventModelFromID(elementToReach.getEltID()).launchScript();
            elementToReach = null;
        }
        else if (renderer.getPlayerView().reachedTarget() && pathFinding.size != 0)
        {
            Vector2 realPosition = RendererUtils.toRealPosition(pathFinding.get(0));
            Vector2 offset = renderer.getPlayerView().getOffset();
            realPosition.x += offset.x;
            realPosition.y += offset.y;
            renderer.getPlayerView().setTargetPosition(realPosition.x, realPosition.y);
            pathFinding.removeIndex(0);
        }

        if (currentScript != null)
        {
            if (!currentScript.update(delta))
                currentScript = null;

            return;
        }
    }

    public void regenerate()
    {
        for (int i = 0; i < map.getElements().size; i++)
        {
            ElementController eltCtrl = map.getElements().get(i);
            InteractEventModel eventModel = world.getEventModelFromID(eltCtrl.getEltID());

            eltCtrl.setVirtualCoordinates(eventModel.getCoordinates().x, eventModel.getCoordinates().y);
        }

    }

    public void movePlayer(float targetX, float targetY)
    {
        pathFinding = map.pathFind(character, new Vector2(targetX, targetY));
        pathFinding = map.epurePath(pathFinding, character.getVirtualCoordinates());
    }

    public boolean pathFindingOver()
    {
        return pathFinding.size == 0;
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
        if (currentScript != null)
            return currentScript.touchDown(screenX,screenY,pointer,button);

        if (!renderer.getPlayerView().reachedTarget() || pathFinding.size != 0)
            return false;

        int realX = screenX + (int) camera.position.x - 1920 / 2;
        int realY = screenY + (int) camera.position.y - 1080 / 2;

        int virtualX = realX >= 0 ? realX / 100 : realX / 100 - 1;
        int virtualY = realY >= 0 ? realY / 100 : realY / 100 - 1;

        if (virtualX < 0 || virtualY < 0 || virtualX >= 1000 || virtualY >= 1000)
            return false;

        //Array<Array<Integer>> mini = DebugHelper.minimizeMap(map.walkingMap, 401, 404, 12, 8);

        if (map.getWalkingMap().get(virtualX).get(virtualY) == 1) {
            pathFinding = map.pathFind(character, new Vector2(virtualX, virtualY));
            if (pathFinding != null) {

                ElementController intercepter = checkInterceptionAndUpdatePath();
                if (intercepter != null) {
                    elementToReach = intercepter;
                }

                pathFinding = map.epurePath(pathFinding, character.getVirtualCoordinates());
            }
            else
                pathFinding = new Array<Vector2>();

        }
        else if (map.getWalkingMap().get(virtualX).get(virtualY) == 3) {

            ElementController elementToMaybeReach = ControllerHelper.getElementAtPosition(new Vector2(virtualX, virtualY), map.getElements());
            pathFinding = map.pathFind(character, elementToMaybeReach.colides(), new Vector2(virtualX, virtualY));

            if (pathFinding != null) {
                ElementController intercepter = checkInterceptionAndUpdatePath();
                if (intercepter != null) {
                    elementToMaybeReach = intercepter;
                }

                pathFinding = map.epurePath(pathFinding, character.getVirtualCoordinates());
                elementToReach = elementToMaybeReach;
            }
            else
                pathFinding = new Array<Vector2>();
        }
        else
            return false;

        return true;
    }

    private ElementController checkInterceptionAndUpdatePath()
    {
        for (int i = 0; i < pathFinding.size; i++)
        {
            Vector2 pos = pathFinding.get(i);

            if (map.getWalkingMap().get((int) pos.x).get((int) pos.y) == 3)
            {
                for (int j = 0; j < map.getElements().size; j++)
                {
                    ElementController elt = map.getElements().get(j);

                    if (elt.intercepts()) {
                        boolean intercept = elt.getVirtualCoordinates().equals(pos);

                        for (int toto = 0; toto < elt.getFulls().size && !intercept; toto++)
                        {
                            Vector2 full = elt.getFulls().get(toto);

                            intercept = pos.x == elt.getVirtualCoordinates().x + full.x && pos.y == elt.getVirtualCoordinates().y + full.y;
                        }

                        if (intercept)
                        {
                            while(i + 1 < pathFinding.size)
                            {
                                pathFinding.removeIndex(i + 1);
                            }

                            return elt;
                        }
                    }
                }
            }
        }

        return null;
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

    public MapController getMap() {
        return map;
    }

    public void setMap(MapController map) {
        this.map = map;
    }

    public CharacterController getCharacter() {
        return character;
    }

    public void setCharacter(CharacterController character) {
        this.character = character;
    }

    public ActionScript getCurrentScript() {
        return currentScript;
    }

    public void setCurrentScript(ActionScript currentScript) {
        this.currentScript = currentScript;
    }
}

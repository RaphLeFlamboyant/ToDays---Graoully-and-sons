package com.ggj16.days.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.debug.DebugHelper;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class MapController {
    // 0 rien, 1 sol, 2 mur, 3 element
    Array<Array<Integer>> walkingMap = new Array<Array<Integer>>();
    Array<ElementController> elements = new Array<ElementController>();
    Array<CharacterController> characters = new Array<CharacterController>();

    public Array<Vector2> pathFind(CharacterController movingCharacter, boolean colides, Vector2 destination)
    {
        if (!colides)
            return pathFind(movingCharacter, destination);
        else {
            walkingMap.get((int) destination.x).set((int) destination.y, 1);
            Array<Vector2> res = pathFindDetailed(movingCharacter, destination);
            if (res != null) {
                walkingMap.get((int) destination.x).set((int) destination.y, 3);
                res.removeIndex(res.size - 1);
            }

            return res;
        }
    }


    //Renvoit une liste de coordonnées que le personnage doit suivre pr arriver à destination
    public Array<Vector2> pathFind(CharacterController movCharacter, Vector2 destination) {
        return pathFindDetailed(movCharacter, destination);
    }

    public Array<Vector2> epurePath(Array<Vector2> path, Vector2 origin)
    {
        Array<Vector2> res = new Array<Vector2>();
        Vector2 previous = new Vector2(origin);
        Vector2 nextStepPath;

        for (int i = 0; i < path.size; i++)
        {
            boolean xFixed = path.get(i).x == previous.x;
            nextStepPath = path.get(i);

            while (i + 1 < path.size && ((path.get(i + 1).x == previous.x && xFixed) || (path.get(i + 1).y == previous.y && !xFixed)))
            {
                nextStepPath = path.get(++i);
            }

            res.add(nextStepPath);
            previous = nextStepPath;
        }

        return res;
    }

    //Renvoit une liste de coordonnées que le personnage doit suivre pr arriver à destination
    private Array<Vector2> pathFindDetailed(CharacterController movCharacter, Vector2 destination)
    {
        Array<Array<Integer>> flamingMap = new Array<Array<Integer>>();
        int dstX = (int) destination.x;
        int dstY = (int) destination.y;

        Gdx.app.log("Tageul", "X : " + (int) movCharacter.getVirtualCoordinates().x);
        Gdx.app.log("Tageul", "Y : " + (int) movCharacter.getVirtualCoordinates().y);

        for (int i = 0; i < walkingMap.size; i++)
        {
            Array<Integer> line = new Array<Integer>();
            flamingMap.add(line);

            for (int j = 0; j < walkingMap.get(i).size; j++)
            {
                if (movCharacter.getVirtualCoordinates().x == i && movCharacter.getVirtualCoordinates().y == j)
                    line.add(-1);
                else
                    line.add(walkingMap.get(i).get(j) == 1 ? -1 : -2);
            }
        }

        //Array<Array<Integer>> mini = DebugHelper.minimizeMap(flamingMap, 401, 404, 12, 8);
        for (int i = 0; i < elements.size; i++)
        {
            ElementController elt = elements.get(i);

            int blockvalue = elt.colides() ? -2 : -1;

            Vector2 caseFill = elt.getVirtualCoordinates();
            flamingMap.get((int) caseFill.x).set((int) caseFill.y, blockvalue);

            for (int fillI = 0; fillI < elt.getFulls().size; fillI++)
            {
                Vector2 offset = elt.getFulls().get(fillI);
                flamingMap.get((int) (caseFill.x + offset.x)).set((int) (caseFill.y + offset.y), blockvalue);
            }
        }

        //Array<Array<Integer>> mini2 = DebugHelper.minimizeMap(flamingMap, 401, 404, 12, 8);
        for (int i = 0; i < characters.size; i++)
        {
            ElementController elt = characters.get(i);

            if (!elt.colides())
                continue;

            Vector2 caseFill = elt.getVirtualCoordinates();

            flamingMap.get((int) caseFill.x).set((int) caseFill.y, -2);
        }

        flamingMap.get(dstX).set(dstY, 0);

        Array<Vector2> previousFlamed = new Array<Vector2>();
        Array<Vector2> currentFlamed;

        //Array<Array<Integer>> mini3 = DebugHelper.minimizeMap(flamingMap, 401, 404, 12, 8);
        previousFlamed.add(destination);

        do {
            currentFlamed = new Array<Vector2>();

            for (int i = 0; i < previousFlamed.size; i++)
            {
                int caseX = (int) previousFlamed.get(i).x;
                int caseY = (int) previousFlamed.get(i).y;
                int caseValue = flamingMap.get(caseX).get(caseY);

                if (caseX - 1 >= 0 && flamingMap.get(caseX - 1).get(caseY) == -1) {
                    flamingMap.get(caseX - 1).set(caseY, caseValue + 1);
                    currentFlamed.add(new Vector2(caseX - 1, caseY));
                }
                if (caseX + 1 < flamingMap.size && flamingMap.get(caseX + 1).get(caseY) == -1) {
                    flamingMap.get(caseX + 1).set(caseY, caseValue + 1);
                    currentFlamed.add(new Vector2(caseX + 1, caseY));
                }
                if (caseY - 1 >= 0 && flamingMap.get(caseX).get(caseY - 1) == -1) {
                    flamingMap.get(caseX).set(caseY - 1, caseValue + 1);
                    currentFlamed.add(new Vector2(caseX, caseY - 1));
                }
                if (caseY + 1 < flamingMap.get(0).size && flamingMap.get(caseX).get(caseY + 1) == -1) {
                    flamingMap.get(caseX).set(caseY + 1, caseValue + 1);
                    currentFlamed.add(new Vector2(caseX, caseY + 1));
                }
            }

            previousFlamed = currentFlamed;
        } while (flamingMap.get((int) movCharacter.getVirtualCoordinates().x).get((int) movCharacter.getVirtualCoordinates().y) == -1 && previousFlamed.size != 0);

        Array<Vector2> res = new Array<Vector2>();

       // Array<Array<Integer>> flamini = DebugHelper.minimizeMap(flamingMap, 401, 404, 12, 8);
        if(previousFlamed.size == 0) {
            return null;
        }

        Vector2 current = movCharacter.getVirtualCoordinates();

        do
        {
            Vector2 next = null;

            int caseX = (int) current.x;
            int caseY = (int) current.y;
            int caseValue = flamingMap.get(caseX).get(caseY);

            if (caseX - 1 >= 0 && flamingMap.get(caseX - 1).get(caseY) == caseValue - 1) {
                next = new Vector2(caseX - 1, caseY);
            }
            else if (caseX + 1 < flamingMap.size && flamingMap.get(caseX + 1).get(caseY) == caseValue -1) {
                next = new Vector2(caseX + 1, caseY);
            }
            else if (caseY - 1 >= 0 && flamingMap.get(caseX).get(caseY - 1) == caseValue -1) {
                next = new Vector2(caseX, caseY - 1);
            }
            else if (caseY + 1 < flamingMap.get(0).size && flamingMap.get(caseX).get(caseY + 1) == caseValue -1) {
                next = new Vector2(caseX, caseY + 1);
            }

            res.add(current);
            current = next;
        } while (current != null);

        res.removeIndex(0);

        return res;
    }

    public Array<Array<Integer>> getWalkingMap() {
        return walkingMap;
    }

    public void setWalkingMap(Array<Array<Integer>> walkingMap) {
        this.walkingMap = walkingMap;
    }

    public Array<ElementController> getElements() {
        return elements;
    }

    public void setElements(Array<ElementController> elements) {
        this.elements = elements;
    }

    public Array<CharacterController> getCharacters() {
        return characters;
    }

    public void setCharacters(Array<CharacterController> characters) {
        this.characters = characters;
    }
}

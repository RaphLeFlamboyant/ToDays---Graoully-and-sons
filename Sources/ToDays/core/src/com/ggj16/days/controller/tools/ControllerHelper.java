package com.ggj16.days.controller.tools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.controller.CharacterController;
import com.ggj16.days.controller.ElementController;
import com.ggj16.days.view.character.CharacterView;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class ControllerHelper {
    public static ElementController getElementAtPosition(Vector2 position, Array<ElementController> elements)
    {
        for(int i = 0; i < elements.size; i++)
        {
            ElementController elt = elements.get(i);
            if (elt.getVirtualCoordinates().equals(position))
                return  elt;

            for (int j = 0; j < elt.getFulls().size; j++)
            {
                if ((elt.getVirtualCoordinates().x + elt.getFulls().get(j).x) == position.x && (elt.getVirtualCoordinates().y + elt.getFulls().get(j).y) == position.y)
                    return elt;
            }
        }

        return null;
    }

    public static ElementController getElementFromID(Array<ElementController> elements, int id)
    {
        for (int i = 0; i < elements.size; i++)
        {
            if (elements.get(i).getEltID() == id)
                return elements.get(i);
        }

        return null;
    }

    public static CharacterController getCharacterFromID(Array<CharacterController> characters, int id)
    {
        for (int i = 0; i < characters.size; i++)
        {
            if (characters.get(i).getEltID() == id)
                return characters.get(i);
        }

        return null;
    }
}

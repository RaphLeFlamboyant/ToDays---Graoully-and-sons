package com.ggj16.days.view.tools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.view.interact.InteractCharacter;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class RendererUtils {
    public static Vector2 toRealPosition(Vector2 virtualPosition)
    {
        return new Vector2(virtualPosition.x * 100, virtualPosition.y * 100);
    }

    public static Vector2 toVirtualPosition(Vector2 realPosition)
    {
        Vector2 res = new Vector2(realPosition.x / 100, realPosition.y / 100);
        res.x = realPosition.x >= 0 || realPosition.x % 100 == 0 ? res.x : res.x - 1;
        res.y = realPosition.y >= 0 || realPosition.y % 100 == 0 ? res.y : res.y - 1;

        return res;
    }

    public static InteractCharacter getInteractCharacter(Array<InteractCharacter> characters, int id)
    {
        for (int i = 0; i < characters.size; i++)
        {
            if (characters.get(i).getInteractID() == id)
                return characters.get(i);
        }

        return null;
    }
}

package com.ggj16.days.model.tools;

import com.badlogic.gdx.utils.Array;
import com.ggj16.days.model.InteractEventModel;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class ModelHelper {
    public static InteractEventModel getCorrespondingInteraction(Array<Boolean> listEvents, Array<InteractEventModel> states)
    {
        InteractEventModel res = null;

        for (int i = 0; i < states.size; i++)
        {
            InteractEventModel current = states.get(i);
            if (validateCondition(listEvents, current.getListIds()) && (res == null || res.getWeight() <= current.getWeight()))
            {
                res = current;
            }
        }

        return res;
    }

    private static boolean validateCondition(Array<Boolean> listEvents, Array<Integer> listID)
    {
        for (int i = 0; i < listID.size; i++)
        {
            if (!listEvents.get(listID.get(i)))
                return false;
        }

        return true;
    }
}

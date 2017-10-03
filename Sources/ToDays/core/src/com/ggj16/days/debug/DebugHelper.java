package com.ggj16.days.debug;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Florian on 30/01/2016.
 */
public class DebugHelper {
    public static Array<Array<Integer>> minimizeMap(Array<Array<Integer>> map, int x, int y, int w, int h)
    {
        Array<Array<Integer>> res = new Array<Array<Integer>>();

        for (int i = 0; i < w; i++) {
            res.add(new Array<Integer>());
            for (int j = 0; j < h; j++) {
                res.get(i).add(map.get((x+i)).get((y+j)));
            }
        }

        return res;
    }
}


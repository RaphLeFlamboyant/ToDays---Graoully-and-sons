package com.ggj16.days.view.interact;

import com.ggj16.days.model.InteractModel;
import com.ggj16.days.view.character.CharacterView;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class InteractCharacter extends CharacterView {
    int interactID;
    InteractModel model;

    public InteractCharacter(String standUp, String standDown, String standRight, String standLeft,
                             String walkUp, String walkDown, String walkRight, String walkLeft)
    {
        super(standUp, standDown, standRight, standLeft, walkUp, walkDown, walkRight, walkLeft);
        //this.model = model;
    }

    public int getInteractID() {
        return interactID;
    }

    public void setInteractID(int interactID) {
        this.interactID = interactID;
    }


}

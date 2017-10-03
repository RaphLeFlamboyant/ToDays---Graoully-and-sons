package com.ggj16.days.model;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.model.tools.ModelHelper;

/**
 * Created by Florian on 29/01/2016.
 */
public class ToDaysWorld {

    Array<Boolean> listEvents;
    Array<InteractModel> listInteractModel;
    CharacterModel toDayChar;


    public ToDaysWorld(){
        this.listEvents = new Array<Boolean>();
        this.listInteractModel = new Array<InteractModel>();
        this.toDayChar = new CharacterModel();
    }

    public void update(float delta)
    {

    }

    public InteractEventModel getEventModelFromID(int interactID)
    {
        for (int i = 0; i < listInteractModel.size; i++)
        {
            InteractModel im = listInteractModel.get(i);

            if (im.getId() == interactID)
            {
                InteractEventModel res = ModelHelper.getCorrespondingInteraction(listEvents, im.getListEvents());

                return res;
            }
        }

        return null;
    }

    public Array<Boolean> getListEvents() {
        return listEvents;
    }

    public void setListEvents(Array<Boolean> listEvents) {
        this.listEvents = listEvents;
    }

    public Array<InteractModel> getListInteractModel() {
        return listInteractModel;
    }

    public void setListInteractModel(Array<InteractModel> listInteractModel) {
        this.listInteractModel = listInteractModel;
    }

    public CharacterModel getToDayChar() {
        return toDayChar;
    }

    public void setToDayChar(CharacterModel toDayChar) {
        this.toDayChar = toDayChar;
    }
}

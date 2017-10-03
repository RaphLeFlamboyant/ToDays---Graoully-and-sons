package com.ggj16.days.model;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Florian on 29/01/2016.
 */
public class InteractModel {
    int id;
    Array<InteractEventModel> listEvents;
    ToDaysWorld owner;

    public InteractModel(){
        this.id = 0;
        this.listEvents = new Array<InteractEventModel>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Array<InteractEventModel> getListEvents() {
        return listEvents;
    }

    public void setListEvents(Array<InteractEventModel> listEvents) {
        this.listEvents = listEvents;
    }
}

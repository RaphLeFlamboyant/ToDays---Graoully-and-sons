package com.ggj16.days.gamegenerator;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.controller.ElementController;
import com.ggj16.days.controller.MapController;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.InteractEventModel;
import com.ggj16.days.model.InteractModel;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;
import com.ggj16.days.view.character.CharacterView;
import com.ggj16.days.view.interact.InteractCharacter;
import com.ggj16.days.view.interact.InteractStaticView;
import com.ggj16.days.view.map.MapView;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class GameGeneratorOld {
    public void initGameGeneration(){

    }

    public void regenerate(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world)
    {
        MapController mapC =  controller.getMap();

        for (int i = 0; i < 12; i++)
        {
            Array<Integer> newLine = new Array<Integer>();
            for (int j = 0; j < 12; j++)
                newLine.add(1);

            mapC.getWalkingMap().add(newLine);
        }

        mapC.getWalkingMap().get(0).set(0, 2);
        mapC.getWalkingMap().get(0).set(1, 2);
        mapC.getWalkingMap().get(1).set(2, 2);
        mapC.getWalkingMap().get(1).set(9, 2);
        mapC.getWalkingMap().get(1).set(10, 2);
        mapC.getWalkingMap().get(1).set(11, 2);
        mapC.getWalkingMap().get(3).set(5, 2);
        mapC.getWalkingMap().get(3).set(6, 2);
        mapC.getWalkingMap().get(3).set(7, 2);
        mapC.getWalkingMap().get(4).set(5, 2);
        mapC.getWalkingMap().get(4).set(7, 2);
        mapC.getWalkingMap().get(5).set(5, 2);
        mapC.getWalkingMap().get(5).set(7, 2);
        mapC.getWalkingMap().get(6).set(7, 2);
        mapC.getWalkingMap().get(8).set(1, 2);
        mapC.getWalkingMap().get(8).set(2, 2);
        mapC.getWalkingMap().get(8).set(3, 2);
        mapC.getWalkingMap().get(8).set(4, 2);
        mapC.getWalkingMap().get(8).set(5, 2);
        mapC.getWalkingMap().get(8).set(6, 2);
        mapC.getWalkingMap().get(8).set(7, 2);
        mapC.getWalkingMap().get(8).set(8, 2);
        mapC.getWalkingMap().get(8).set(9, 2);
        mapC.getWalkingMap().get(9).set(9, 2);

        for (int i = 0; i < controller.getMap().getElements().size; i++)
        {
            ElementController elt = controller.getMap().getElements().get(i);

            mapC.getWalkingMap().get((int) elt.getVirtualCoordinates().x).set((int) elt.getVirtualCoordinates().y, 3);

            for (int fillI = 0; fillI < elt.getFulls().size; fillI++)
            {
                Vector2 offset = elt.getFulls().get(fillI);
                mapC.getWalkingMap().get((int) (elt.getVirtualCoordinates().x + offset.x)).set((int) (elt.getVirtualCoordinates().y + offset.y), 3);
            }
        }
    }

    public void setGameGeneration(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world, ToDaysScreen owner)
    {
        MapController mapC =  controller.getMap();

        for (int i = 0; i < 12; i++)
        {
            Array<Integer> newLine = new Array<Integer>();
            for (int j = 0; j < 12; j++)
                newLine.add(1);

            mapC.getWalkingMap().add(newLine);
        }

        mapC.getWalkingMap().get(0).set(0, 2);
        mapC.getWalkingMap().get(0).set(1, 2);
        mapC.getWalkingMap().get(1).set(2, 2);
        mapC.getWalkingMap().get(1).set(9, 2);
        mapC.getWalkingMap().get(1).set(10, 2);
        mapC.getWalkingMap().get(1).set(11, 2);
        mapC.getWalkingMap().get(3).set(5, 2);
        mapC.getWalkingMap().get(3).set(6, 2);
        mapC.getWalkingMap().get(3).set(7, 2);
        mapC.getWalkingMap().get(4).set(5, 2);
        mapC.getWalkingMap().get(4).set(7, 2);
        mapC.getWalkingMap().get(5).set(5, 2);
        mapC.getWalkingMap().get(5).set(7, 2);
        mapC.getWalkingMap().get(6).set(7, 2);
        mapC.getWalkingMap().get(8).set(1, 2);
        mapC.getWalkingMap().get(8).set(2, 2);
        mapC.getWalkingMap().get(8).set(3, 2);
        mapC.getWalkingMap().get(8).set(4, 2);
        mapC.getWalkingMap().get(8).set(5, 2);
        mapC.getWalkingMap().get(8).set(6, 2);
        mapC.getWalkingMap().get(8).set(7, 2);
        mapC.getWalkingMap().get(8).set(8, 2);
        mapC.getWalkingMap().get(8).set(9, 2);
        mapC.getWalkingMap().get(9).set(9, 2);

        MapView mapV = new MapView("fakemap");
        mapV.setPosition(0, 0);
        renderer.getMapViews().add(mapV);
        AssetsLoader.loadTextureRegion("badlogic.jpg", "badlogic", 0, 0, 50, 50);
        AssetsLoader.loadTextureRegion("Maps/fakemap.png", "fakemap", 0, 0, 1200, 1200);

        controller.getCharacter().setVirtualCoordinates(1, 3);

        renderer.setPlayerView(new CharacterView("bobUpStand", "bobDownStand", "bobRightStand", "bobLeftStand", "bobUpWalk", "bobDownWalk", "bobRightWalk", "bobLeftWalk"));
        renderer.getPlayerView().setPosition(100, 200);
        renderer.getPlayerView().setTargetPosition(100, 200);
        renderer.getPlayerView().setOffset(0, -100);
        AssetsLoader.loadAnimation("Characters/bobUpStand.png", "bobUpStand", "bobUpStand", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobDownStand.png", "bobDownStand", "bobDownStand", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobRightStand.png", "bobRightStand", "bobRightStand", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobLeftStand.png", "bobLeftStand", "bobLeftStand", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobUpWalk.png", "bobUpWalk", "bobUpWalk", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobDownWalk.png", "bobDownWalk", "bobDownWalk", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobRightWalk.png", "bobRightWalk", "bobRightWalk", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/bobLeftWalk.png", "bobLeftWalk", "bobLeftWalk", 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);

        world.getListEvents().add(true);
        world.getListEvents().add(false);
        world.getListEvents().add(false);

        ElementController bed = new ElementController();
        bed.setEltID(0);
        bed.setColides(true);
        bed.setVirtualCoordinates(3, 9);
        bed.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(bed);

        InteractStaticView bedV = new InteractStaticView(null);
        bedV.setInteractID(0);
        bedV.setTextureRegionName("bed");
        bedV.setPosition(300, 900);
        renderer.getInteracts().add(bedV);
        AssetsLoader.loadTextureRegion("Elements/fakebed.png", "bed", 0, 0, 100, 200);
/*
        InteractModel im = new InteractModel();
        ActionScript as = new TestActionScript(controller, world, renderer, owner, 0);
        im.setId(0);
        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("bed");
        iem.setCoordinates(3, 9);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);
        iem = new InteractEventModel(as, 2);
        iem.setViewName("bed");
        iem.setCoordinates(5, 9);
        iem.getListIds().add(1);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);


        ElementController helicoGuy = new ElementController();
        helicoGuy.setEltID(1);
        helicoGuy.setColides(false);
        helicoGuy.setVirtualCoordinates(10, 5);
        controller.getMap().getElements().add(helicoGuy);

        InteractCharacter helico = new InteractCharacter("fakemanUpStand", "fakemanDownStand", "fakemanRightStand", "fakemanLeftStand", "fakemanUpWalk", "fakemanDownWalk", "fakemanRightWalk", "fakemanLeftWalk");
        helico.setPosition(1000, 400);
        helico.setTargetPosition(1000, 400);
        helico.setOffset(0, -100);
        helico.setInteractID(1);
        AssetsLoader.loadAnimation("Characters/fakemanUpStand.png", "fakemanUpStand", "fakemanUpStand", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanDownStand.png", "fakemanDownStand", "fakemanDownStand", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanRightStand.png", "fakemanRightStand", "fakemanRightStand", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanLeftStand.png", "fakemanLeftStand", "fakemanLeftStand", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanUpWalk.png", "fakemanUpWalk", "fakemanUpWalk", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanDownWalk.png", "fakemanDownWalk", "fakemanDownWalk", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanRightWalk.png", "fakemanRightWalk", "fakemanRightWalk", 100, 200, Animation.PlayMode.LOOP);
        AssetsLoader.loadAnimation("Characters/fakemanLeftWalk.png", "fakemanLeftWalk", "fakemanLeftWalk", 100, 200, Animation.PlayMode.LOOP);
        renderer.getInteractCharacters().add(helico);*/

        /*InteractModel im2 = new InteractModel();
        ActionScript as2 = new TestActionScript2(controller, world, renderer, owner, 1);
        im2.setId(1);
        InteractEventModel iem2 = new InteractEventModel(as2, 1);
        iem2.setViewName("fakemanUpStand");
        iem2.setCoordinates(10, 5);
        iem2.getListIds().add(0);
        im2.getListEvents().add(iem2);
        iem2 = new InteractEventModel(as2, 2);
        iem2.setViewName("fakemanUpStand");
        iem2.setCoordinates(1, 1);
        iem2.getListIds().add(2);
        im2.getListEvents().add(iem2);

        world.getListInteractModel().add(im2);


        for (int i = 0; i < controller.getMap().getElements().size; i++)
        {
            ElementController elt = controller.getMap().getElements().get(i);

            mapC.getWalkingMap().get((int) elt.getVirtualCoordinates().x).set((int) elt.getVirtualCoordinates().y, 3);

            for (int fillI = 0; fillI < elt.getFulls().size; fillI++)
            {
                Vector2 offset = elt.getFulls().get(fillI);
                mapC.getWalkingMap().get((int) (elt.getVirtualCoordinates().x + offset.x)).set((int) (elt.getVirtualCoordinates().y + offset.y), 3);
            }
        }*/

    }
}

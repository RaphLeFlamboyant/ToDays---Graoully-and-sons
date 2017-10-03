package com.ggj16.days.gamegenerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.controller.ElementController;
import com.ggj16.days.controller.MapController;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.debug.DebugHelper;
import com.ggj16.days.gamegenerator.modules.PlayerGenerator;
import com.ggj16.days.gamegenerator.modules.UglyElementGenerator;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;
import com.ggj16.days.view.character.CharacterView;
import com.ggj16.days.view.interact.InteractStaticView;
import com.ggj16.days.view.map.MapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.SysexMessage;
import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class GameGenerator {
    public void initGameGeneration(){

    }

    public void regenerate(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world)
    {
        MapController mapC =  controller.getMap();

        generateMap(mapC, controller, renderer);

        Array<ElementController> listelt = controller.getMap().getElements();
        updateControllerMapFromElements(listelt, mapC);
    }

    public void setGameGeneration(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world, ToDaysScreen owner)
    {
        MapController mapC =  controller.getMap();

        generateMap(mapC, controller, renderer);

        initEventList(world);

        MapView mapV = new MapView("map");
        mapV.setPosition(400 * 100, 404 * 100);
        renderer.getMapViews().add(mapV);
        AssetsLoader.loadTextureRegion("Maps/Map.png", "map", 0, 0, 1700, 1296);

        PlayerGenerator playerGenerator = new PlayerGenerator(controller, renderer, world);
        playerGenerator.generatePlayer(403, 407, "bobUpStand", "bobDownStand", "bobRightStand", "bobLeftStand", "bobUpWalk", "bobDownWalk", "bobRightWalk", "bobLeftWalk");

        UglyElementGenerator elementGenerator = new UglyElementGenerator(controller, renderer, world, owner);
        elementGenerator.generateElements();

        Array<ElementController> listelt = controller.getMap().getElements();
        updateControllerMapFromElements(listelt, mapC);
    }



    private void initEventList(ToDaysWorld world)
    {
        //TODO : mettre le vrai nbr d'event
        for (int i = 0; i < 100; i++)
        {
            world.getListEvents().add(false);
        }

        world.getListEvents().set(0, true);
    }

    private void updateControllerMapFromElements(Array<ElementController> listelt, MapController mapC)
    {
        for (ElementController ec: listelt) {

            mapC.getWalkingMap().get((int) ec.getVirtualCoordinates().x).set((int) ec.getVirtualCoordinates().y, 3);
            int fullslength = ec.getFulls().size;
            for (int fillI = 0; fillI < fullslength; fillI++)
            {
                Vector2 offset = ec.getFulls().get(fillI);
                mapC.getWalkingMap().get((int) (ec.getVirtualCoordinates().x + offset.x)).set((int) (ec.getVirtualCoordinates().y + offset.y), 3);
            }
        }
    }

    public void generateMap(MapController mapC, ToDaysController controller, ToDaysRenderer renderer){
        for (int i = 0; i < 1000; i++)
        {
            Array<Integer> newLine = new Array<Integer>();
            for (int j = 0; j < 1000; j++) {
                newLine.add(0);
            }
            mapC.getWalkingMap().add(newLine);
        }

        List<String> mapconf = new FileHelper().loadFile();

        for (int i = 2; i < mapconf.size(); i++) {
            List<String> block = Arrays.asList(mapconf.get(i).split(" "));
            int blockX = Integer.parseInt(block.get(0));
            int blockY = Integer.parseInt(block.get(1));
            int width = Integer.parseInt(block.get(2));
            int height = Integer.parseInt(block.get(3));
            int type = Integer.parseInt(block.get(4).trim());

            for(int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    int coordX = (blockX + j);
                    int coordY = (blockY + k);
                    mapC.getWalkingMap().get(coordX).set(coordY, type);
                }
            }
        }


    }
}
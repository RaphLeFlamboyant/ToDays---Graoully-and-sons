package com.ggj16.days.gamegenerator.modules;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;
import com.ggj16.days.view.character.CharacterView;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class PlayerGenerator {
    ToDaysController controller;
    ToDaysRenderer renderer;
    ToDaysWorld world;


    public PlayerGenerator(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world) {
        this.controller = controller;
        this.renderer = renderer;
        this.world = world;
    }

    public void generatePlayer(float posX, float posY,
                               String upStand, String downStand, String rightStand, String leftStand,
                               String upWalk, String downWalk, String rightWalk, String leftWalk)
    {
        controller.getCharacter().setVirtualCoordinates(posX, posY);

        renderer.setPlayerView(new CharacterView(upStand, downStand, rightStand, leftStand, upWalk, downWalk, rightWalk, leftWalk));
        renderer.getPlayerView().setPosition(posX * 100, posY * 100);
        renderer.getPlayerView().setTargetPosition(posX * 100, posY * 100);
        renderer.getPlayerView().setOffset(0, -100);
        AssetsLoader.loadAnimation("Characters/" + upStand + ".png", upStand, upStand, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + downStand + ".png", downStand, downStand, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + rightStand + ".png", rightStand, rightStand, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + leftStand + ".png", leftStand, leftStand, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + upWalk + ".png", upWalk, upWalk, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + downWalk + ".png", downWalk, downWalk, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + rightWalk + ".png", rightWalk, rightWalk, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
        AssetsLoader.loadAnimation("Characters/" + leftWalk + ".png", leftWalk, leftWalk, 100, 200, Animation.PlayMode.LOOP).setFrameDuration(1f / 30f);
    }
}

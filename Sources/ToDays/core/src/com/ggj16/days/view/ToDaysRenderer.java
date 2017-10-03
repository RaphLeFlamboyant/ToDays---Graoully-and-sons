package com.ggj16.days.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ggj16.days.model.InteractEventModel;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.character.CharacterView;
import com.ggj16.days.view.interact.InteractCharacter;
import com.ggj16.days.view.interact.InteractStaticView;
import com.ggj16.days.view.map.MapView;
import com.ggj16.days.view.tools.RendererUtils;

/**
 * Created by Reborn Portable on 29/01/2016.
 */
public class ToDaysRenderer {
    boolean fogbath = false;
    boolean fogdesk = false;
    boolean fogwc = false;
    boolean foghiden = false;

    boolean goToNight = true;
    boolean transitionDone = true;
    float oneseconde;

    int id;
    Array<MapView> mapViews = new Array<MapView>();
    Array<InteractStaticView> interacts = new Array<InteractStaticView>();
    Array<InteractCharacter> interactCharacters = new Array<InteractCharacter>();
    CharacterView playerView;

    BitmapFont defaultFont;
    String textToDraw = "";

    ToDaysWorld world;

    public ToDaysRenderer(ToDaysWorld model)
    {
        world = model;

        Music music = AssetsLoader.loadMusic("Musics/gameMusic.mp3", "gameMusic");
        music.setLooping(true);
        music.play();

        defaultFont = new BitmapFont(Gdx.files.internal("Fonts/font.fnt"),true);
        defaultFont.setColor(0.5f, 0.5f, 0.5f, 1f);

        Pixmap pm = new Pixmap(Gdx.files.internal("Cursor/cursor0.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        pm.dispose();
    }

    public Array<MapView> getMapViews() {
        return mapViews;
    }

    public void render(SpriteBatch batcher, float delta, ShapeRenderer shapeRenderer){
        playerView.update(delta);

        if (!transitionDone) {
            shade(batcher, delta);
        }

        if(playerView.getPosition().x == 40300 && playerView.getPosition().y >= 41100){
            this.fogbath = true;
        } else if(playerView.getPosition().x == 41000 && playerView.getPosition().y >= 41100){
            this.fogdesk = true;
        } else if(playerView.getPosition().x == 40700 && playerView.getPosition().y >= 41100){
            this.fogwc = true;
        } else if(playerView.getPosition().x >= 41200 && playerView.getPosition().y == 40500){
            this.foghiden = true;
        }

        for(int i = 0; i < mapViews.size; i++)
        {
            MapView map = mapViews.get(i);
            batcher.draw(map.getTextureRegion(), map.getPosition().x, map.getPosition().y);

        }

        for (int i = 0; i < interacts.size; i++)
        {
            InteractStaticView inter = interacts.get(i);
            batcher.draw(inter.getTextureRegion(delta), inter.getPosition().x + inter.getOffset().x, inter.getPosition().y + inter.getOffset().y);
        }

        for (int i = 0; i < interactCharacters.size; i++)
        {
            InteractCharacter inter = interactCharacters.get(i);
            inter.update(delta);
            batcher.draw(inter.getTextureRegion(delta), inter.getPosition().x, inter.getPosition().y);
        }

        batcher.draw(playerView.getTextureRegion(delta), playerView.getPosition().x, playerView.getPosition().y);

        batcher.draw(AssetsLoader.loadTextureRegion("Elements/DarkBobLeftStand.png", "DarkBobLeftStand", 0, 0, 96, 194), 415 * 100, 404 * 100);
        batcher.end();
        shapeRenderer.setProjectionMatrix(batcher.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(38 / 255.0f, 26 / 255.0f, 15 / 255.0f, 1);


        if(!fogdesk){
            shapeRenderer.rect(40900, 41196, 650, 600);
        }
        if(!fogbath){
            shapeRenderer.rect(40000, 41196, 605, 600);
        }
        if(!fogwc){
            shapeRenderer.rect(40600, 41196, 300, 600);
        }
        if(!foghiden){
            shapeRenderer.rect(41300, 40400, 500, 500);
        }

        shapeRenderer.end();
        batcher.begin();

        if (!textToDraw.equals(""))
        {
            float txtX = playerView.getPosition().x;
            float txtY = playerView.getPosition().y;
            drawText(txtX, txtY, batcher, shapeRenderer);
        }
    }

    public void shade(SpriteBatch batcher, float delta){
        oneseconde += delta/2;
        if (goToNight) {
            if(oneseconde < 1) {
                float clr = 1f - oneseconde * 1f;
                batcher.setColor(clr,clr,clr, 1f);
            } else {
                batcher.setColor(0f, 0f, 0f, 1f);
                oneseconde = 0;
                transitionDone = true;
            }
        } else {
            if(oneseconde < 1) {
                float clr = oneseconde * 1f;
                batcher.setColor(clr,clr,clr, 1f);
            } else {
                batcher.setColor(Color.WHITE);
                oneseconde = 0;
                transitionDone = true;
            }
        }
    }

    public void regenerate()
    {
        for (int i = 0; i < interacts.size; i++)
        {
            InteractStaticView interact = interacts.get(i);
            InteractEventModel eventModel = world.getEventModelFromID(interact.getInteractID());

            interact.setTextureRegionName(eventModel.getViewName());
            Vector2 realPos = RendererUtils.toRealPosition(eventModel.getCoordinates());
            interact.setPosition(realPos.x, realPos.y);
        }

        for (int i = 0; i < interactCharacters.size; i++)
        {
            InteractCharacter interact = interactCharacters.get(i);
            InteractEventModel eventModel = world.getEventModelFromID(interact.getInteractID());

            //TODO : setAnim
            Vector2 realPos = RendererUtils.toRealPosition(eventModel.getCoordinates());
            interact.setPosition(realPos.x + interact.getOffset().x, realPos.y + interact.getOffset().y);
            interact.setTargetPosition(realPos.x + interact.getOffset().x, realPos.y + interact.getOffset().y);
        }
    }

    public void setMapViews(Array<MapView> mapViews) {
        this.mapViews = mapViews;
    }

    public CharacterView getPlayerView() {
        return playerView;
    }

    public void setPlayerView(CharacterView playerView) {
        this.playerView = playerView;
    }

    public Array<InteractStaticView> getInteracts() {
        return interacts;
    }

    public void setInteracts(Array<InteractStaticView> interacts) {
        this.interacts = interacts;
    }

    public Array<InteractCharacter> getInteractCharacters() {
        return interactCharacters;
    }

    public void setInteractCharacters(Array<InteractCharacter> interactCharacters) {
        this.interactCharacters = interactCharacters;
    }

    public String getTextToDraw() {
        return textToDraw;
    }

    /**
     *
     * @param textToDraw
     * @param id : 0 nar; 1 bob; 2 postit
     */
    public void setTextToDraw(String textToDraw, int id) {
        this.textToDraw = textToDraw;
        this.id = id;
    }

    public void drawText(float txtX, float txtY, SpriteBatch batcher, ShapeRenderer shapeRenderer){
            batcher.end();
            shapeRenderer.setProjectionMatrix(batcher.getProjectionMatrix());
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

            switch (id){
                case 0:
                    txtX = txtX - 955;
                    txtY = txtY - 535;
                    shapeRenderer.setColor(0f, 0f, 0f, 0.1f);
                    shapeRenderer.rect(txtX - 5, txtY - 5, 1920, 110);
                    shapeRenderer.setColor(255f, 255f, 255f, 0.1f);
                    shapeRenderer.rect(txtX, txtY, 1910, 100);
                    break;
                case 1:
                    txtX = txtX - 955;
                    txtY = txtY + 420;
                    shapeRenderer.setColor(0f, 0f, 0f, 0.1f);
                    shapeRenderer.rect(txtX - 5, txtY - 5, 1920, 110);
                    shapeRenderer.setColor(255f, 255f, 255f, 0.1f);
                    shapeRenderer.rect(txtX, txtY, 1910, 100);
                    break;
                case 2:
                    txtX = txtX - 150;
                    txtY = txtY - 150;
                    shapeRenderer.setColor(254/255.0f, 226/255.0f, 102/255.0f, 1f);
                    shapeRenderer.rect(txtX, txtY, 300, 500);
                    break;
                default:
                    break;
            }

            shapeRenderer.end();
            batcher.begin();
            defaultFont.setColor(Color.BLUE);
            defaultFont.draw(batcher, textToDraw, txtX + 10, txtY + 10);
    }

    public void changeSaturation(){

    }


    public void activateNightTransition(boolean isNight)
    {
        goToNight = isNight;
        transitionDone = false;
    }

    public boolean transitionDone()
    {
        return transitionDone;
    }
}

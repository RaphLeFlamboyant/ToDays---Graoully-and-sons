package com.ggj16.days.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ggj16.days.ToDaysGame;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.gamegenerator.GameGenerator;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.view.ToDaysRenderer;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class ToDaysScreen implements Screen {
    private ToDaysGame game;

    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private ToDaysWorld world;
    private ToDaysRenderer renderer;
    private ToDaysController controller;
    private GameGenerator generator;

    public ToDaysScreen(final ToDaysGame gam)
    {
        game = gam;

        world = new ToDaysWorld();
        renderer = new ToDaysRenderer(world);
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 1920, 1080);
        controller = new ToDaysController(this, world, renderer, camera);

        generator = new GameGenerator();
        generator.initGameGeneration();
        generator.setGameGeneration(controller, renderer, world, this);

        Gdx.input.setInputProcessor(controller);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        game.batch.setProjectionMatrix(camera.combined);

        controller.launchGame();
    }

    public void regenerate()
    {
        //world.regenerate();
        renderer.regenerate();
        controller.regenerate();
        generator.regenerate(controller, renderer, world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        world.update(delta);
        controller.update(delta);

        Gdx.gl.glClearColor(38/255.0f,26/255.0f,15/255.0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        //shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //shapeRenderer.end();

        game.batch.begin();
        renderer.render(game.batch, delta, shapeRenderer);
        game.batch.end();

//        controller.getStage().act(delta);
//        controller.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

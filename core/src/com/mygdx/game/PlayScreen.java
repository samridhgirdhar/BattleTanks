package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private Stage stage;
    private Texture tex1;
    private Texture terrain;

    private Texture tank1;
    private Texture tank2;
    public PlayScreen(MyGdxGame game){
        this.game = game;
        tex1 = new Texture("gamebackground.png");
        OrthographicCamera gamecam = new OrthographicCamera();
        Viewport gamePort = new FitViewport(1080,720,gamecam);
    }
    @Override
    public void show() {
        stage = new Stage();

        ImageButton pausebutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("pausebutton.png"))));
        terrain = new Texture("terrainimg.png");

        tank1= new Texture("tank1rotated.png");
        tank2= new Texture("tank2flipped.png");

        Gdx.input.setInputProcessor(stage);

        stage.addActor(pausebutton);
        pausebutton.setPosition(0,420);
        pausebutton.setSize(50,50);



        pausebutton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });



    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(tex1,-0,-0,640,481);
        game.batch.draw(terrain,-0,-0,640,481);
        game.batch.draw(tank1,-0,185,150,80);
        game.batch.draw(tank2,475,200,150,78);

        game.batch.end();

        stage.act();
        stage.draw();
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

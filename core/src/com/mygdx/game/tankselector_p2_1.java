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

public class tankselector_p2_1 implements Screen {
    private MyGdxGame game;
    private Stage stage;
    private Texture tex1;


    public tankselector_p2_1(MyGdxGame ga){
        this.game=ga;
        tex1 = new Texture("tankbg.png");
        OrthographicCamera gamecam = new OrthographicCamera();
        Viewport gamePort = new FitViewport(1080,720,gamecam);
    }
    public Texture tank1 = new Texture("tank1.png");


    @Override
    public void show() {
        stage = new Stage();

        ImageButton left = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("left.png"))));
        ImageButton right = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("right.png"))));
        ImageButton select = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("selectbutton.png"))));


        Gdx.input.setInputProcessor(stage);
        stage.addActor(left);
        left.setPosition(-30,15);
        left.setSize(150,80);

        stage.addActor(right);
        right.setPosition(520,15);
        right.setSize(150,80);

        stage.addActor(select);
        select.setPosition(260,30);
        select.setSize(100,50);


        left.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tankselector_p2_3(game));
            }
        });
        right.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tankselector_p2_2(game));
            }
        });
        select.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });




    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(tex1,-0,-0,640,481);
        game.batch.draw(tank1,-50,28,700,400);
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

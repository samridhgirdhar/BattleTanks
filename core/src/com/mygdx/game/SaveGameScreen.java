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

public class SaveGameScreen implements Screen {
    private MyGdxGame game;
    private Stage stage;
    private Texture tex1;
    public SaveGameScreen(MyGdxGame game){
        this.game = game;
        tex1 = new Texture("menubg.png");
        OrthographicCamera gamecam = new OrthographicCamera();
        Viewport gamePort = new FitViewport(1080,720,gamecam);
    }
    @Override
    public void show() {
        stage = new Stage();

        ImageButton savegame1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("savegame1.png"))));
        ImageButton savegame2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("savegame2.png"))));
        ImageButton savegame3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("savegame3.png"))));

        Gdx.input.setInputProcessor(stage);

        stage.addActor(savegame1);
        savegame1.setPosition(220,260);
        savegame1.setSize(200,100);

        stage.addActor(savegame2);
        savegame2.setPosition(220,180);
        savegame2.setSize(200,100);

        stage.addActor(savegame3);
        savegame3.setPosition(220,100);
        savegame3.setSize(200,100);

        savegame1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });
        savegame2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });
        savegame3.addListener(new ClickListener(){
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

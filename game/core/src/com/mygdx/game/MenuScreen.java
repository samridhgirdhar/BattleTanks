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

public class MenuScreen implements Screen {
    private MyGdxGame game;
    private Stage stage;
    private Texture tex1;
    public MenuScreen(MyGdxGame game){
        this.game = game;
        tex1 = new Texture("menubg.png");
        OrthographicCamera gamecam = new OrthographicCamera();
        Viewport gamePort = new FitViewport(1080,720,gamecam);
    }
    @Override
    public void show() {
        stage = new Stage();

        ImageButton newgame = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("newgame.png"))));
        ImageButton savegame = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("continue.png"))));
        ImageButton exit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("exit.png"))));

        Gdx.input.setInputProcessor(stage);
        stage.addActor(newgame);
        newgame.setPosition(220,260);
        newgame.setSize(200,100);

        stage.addActor(savegame);
        savegame.setPosition(220,180);
        savegame.setSize(200,100);

        stage.addActor(exit);
        exit.setPosition(220,100);
        exit.setSize(200,100);

        newgame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tankselector_p1_1(game));
            }
        });
        savegame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SaveGameScreen(game));
            }
        });
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
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

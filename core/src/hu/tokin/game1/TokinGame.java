package hu.tokin.game1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TokinGame extends Game {
	SpriteBatch batch;
	Texture img;
	Stage stage;
	Viewport viewport;
	RoadActor road;

	static float wigth;
	static float height;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		stage=new Stage();
		wigth=Gdx.graphics.getWidth();
		height=Gdx.graphics.getHeight();
		viewport=new ExtendViewport(wigth,height);
		Gdx.input.setInputProcessor(stage);

		road=new RoadActor();
		stage.addActor(road);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

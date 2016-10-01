package hu.tokin.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by -Dinamo- on 2016.10.01..
 */

public class RoadActor extends Actor{

    Sprite road1;
    Sprite road2;
    Texture img;

    float delta;

    float x1=0;
    float x2=TokinGame.wigth;

    static float roadSpeed=300;

    public RoadActor(){
        debug();
        img=new Texture("road.png");
        road1=new Sprite(img);
        road2=new Sprite(img);
        addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            CarActor.carThereX=Gdx.input.getX()-(int)CarActor.carWidth;
                            CarActor.carThereY=Gdx.input.getY();
                            float m=Gdx.input.getY()/TokinGame.height;
                            float b=1-m;

                            CarActor.carThereY=TokinGame.height*b-10;
                            CarActor.goX=true;
                            CarActor.goY=true;
                            CarActor.GO=false;
                        }
                    }
        );
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        delta=Gdx.graphics.getDeltaTime();
        road1.setSize(TokinGame.wigth,TokinGame.height);
        road2.setSize(TokinGame.wigth,TokinGame.height);
        super.setSize(TokinGame.wigth,TokinGame.height);
        setPos();
        move();
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        road1.setSize(width,height);
        road2.setSize(width,height);
    }

    public void setPos() {
        super.setPosition(0, 0);
        road1.setPosition(x1,0);
        road2.setPosition(x2,0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        road1.draw(batch);
        road2.draw(batch);
    }

    public void move(){
        x1=x1-(Gdx.graphics.getDeltaTime()*roadSpeed);
        x2=x2-(Gdx.graphics.getDeltaTime()*roadSpeed);
        setPos();
        if(x2<=0){
            x1=0;
            x2=TokinGame.wigth;
        }
    }
}

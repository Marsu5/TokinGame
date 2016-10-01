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

public class CarActor extends Actor{

    Sprite car;
    Texture img;

    static float carWidth;
    float carHeight;
    float proportionality;

    float carHereX;
    float carHereY;
    static float carThereX;
    static float carThereY;

    float carSpeed=RoadActor.roadSpeed;

    static boolean goX=false;
    static boolean goY=false;
    static boolean GO=false;

    public CarActor(){
        img=new Texture("car.png");
        car=new Sprite(img);
        carWidth=car.getWidth();
        carHeight=car.getHeight();
        addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            GO=!GO;
                        }
                    }
        );
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        proportionality=carWidth/carHeight;
        carWidth=TokinGame.wigth/(float)2.3;
        carHeight=carWidth/proportionality;
        car.setSize(carWidth,carHeight);
        car.setPosition(carHereX,carHereY);
        move();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        car.draw(batch);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        car.setSize(width,height);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        car.setPosition(x,y);
    }

    public void move() {
        if(goX) {
            if (carThereX > carHereX)
                carHereX +=Gdx.graphics.getDeltaTime()* carSpeed;
            else
                carHereX -=Gdx.graphics.getDeltaTime()* carSpeed;
        }
        if(goY) {
            if (carThereY > carHereY)
                carHereY += Gdx.graphics.getDeltaTime() * carSpeed;
            else
                carHereY -=Gdx.graphics.getDeltaTime() * carSpeed;
        }

        if(carThereX==carHereX)
            goX=false;
        if(carThereY==carHereY)
            goY=false;

        if(GO)
            carHereX = carHereX + Gdx.graphics.getDeltaTime() * carSpeed;

        car.setPosition(carHereX,carHereY);
        super.setPosition(carHereX,carHereY);
    }
}

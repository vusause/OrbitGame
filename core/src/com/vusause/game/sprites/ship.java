package com.vusause.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Mike on 5/14/2016.
 */
public class ship {
    private static final int GRAVITY = -9;
    private static final int MOVE = 100;

    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;

    private Texture Ship;

    public ship(int x, int y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        Ship = new Texture("ship.png");
        bounds = new Rectangle(x, y, 24, 19);
    }

    public void update(float dt){
        if(position.y > 0){
            velocity.add(0, GRAVITY);
        }
        velocity.add(0,GRAVITY);
        velocity.scl(dt);
        position.add(MOVE * dt, velocity.y);
        if(position.y < 0) {
            position.y = 0;
        }
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return Ship;
    }

    public void boost() {
        velocity.y = 250;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}

package com.vusause.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Mike on 5/14/2016.
 */
public class ast {
    private Circle binding;

    private Vector2 position;

    private Texture asteroid;

    public ast(int x, int y) {
        position = new Vector2(x, y);
        asteroid = new Texture("astL.png");
        binding = new Circle();
        binding.set(position.x + 25, position.y + 26, 12.5f);
    }

    public void update(float dt){

    }

    public void reposition(float move, int movey) {
        position.set(move, movey);
        binding.set(move + 25, movey + 26, 12.5f);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return asteroid;
    }

    public boolean collides(Rectangle player){
        if (position.x < player.getX() + player.getWidth()) {
            return (Intersector.overlaps(binding, player));
        } else {
            return false;
        }
    }
}
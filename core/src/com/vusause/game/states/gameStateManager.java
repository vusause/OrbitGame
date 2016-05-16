package com.vusause.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Mike on 5/14/2016.
 */
public class gameStateManager {

    private Stack<state> states;

    public gameStateManager(){
        states = new Stack<state>();
    }

    public void push(state s){
        states.push(s);
    }

    public void pop() {
        states.pop().dispose();
    }

    public void set(state s){
        states.pop();
        states.push(s);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}

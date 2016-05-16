package com.vusause.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vusause.game.AstGame;

/**
 * Created by Mike on 5/14/2016.
 */
public class menuState extends state{
    private Texture background;
    private Texture playBtn;

    public menuState(gameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("btn.jpg");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new playState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, AstGame.WIDTH, AstGame.HEIGHT);
        sb.draw(playBtn, (AstGame.WIDTH / 2) - (playBtn.getWidth() / 2), (AstGame.HEIGHT / 2) - (playBtn.getHeight() / 2));
        sb.end();
    }
}

package com.vusause.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.sun.media.jfxmedia.events.PlayerStateEvent;
import com.vusause.game.AstGame;
import com.vusause.game.sprites.ast;
import com.vusause.game.sprites.ship;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Mike on 5/14/2016.
 */
public class playState extends state{
    private static final int AST_ARRAY = 5;
    private static final int AST_SPACE = 125;
    private ship ship;
    private Array<ast[]> asteroids;
    private Texture background;

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    int height;

    public playState(gameStateManager gsm) {
        super(gsm);
        ship = new ship(50, 300);
        background = new Texture("bg.png");
        cam.setToOrtho(false, (AstGame.WIDTH / 2), (AstGame.HEIGHT / 2));

        height = (int)cam.viewportHeight;

        asteroids = new Array<ast[]>();
        for(int i = 1; i < AST_ARRAY; i++) {
            asteroids.add(new ast[]{new ast((i * AST_SPACE), getRandomNumberInRange(height / 3 * 2, height)),
                    new ast((i * AST_SPACE), getRandomNumberInRange(height / 3, height / 3 * 2)),
                    new ast((i * AST_SPACE), getRandomNumberInRange(0, height / 3))});
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            ship.boost();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        ship.update(dt);
        cam.position.x = ship.getPosition().x + 80;

        for(ast[] asteroid : asteroids) {
            if (cam.position.x - (cam.viewportWidth / 2) > asteroid[1].getPosition().x + asteroid[1].getTexture().getWidth()) {
                for (int i = 0; i < 3; i++) {
                    asteroid[i].reposition(asteroid[i].getPosition().x + ((AST_SPACE) * (AST_ARRAY - 1)), getRandomNumberInRange(height / 3 * i, height / 3 * (i + 1)));
                }
            }
            for (int i = 0; i < 3; i++) {
                if (asteroid[i].collides(ship.getBounds())){
                    gsm.set(new playState(gsm));
                }
            }
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(ship.getTexture(), ship.getPosition().x, ship.getPosition().y);
        for(ast[] asteroid: asteroids) {
            for(int i = 0; i < 3; i++) {
                sb.draw(asteroid[i].getTexture(), asteroid[i].getPosition().x, asteroid[i].getPosition().y);
            }
        }
        sb.end();
    }

    @Override
    public void dispose() {
    }
}

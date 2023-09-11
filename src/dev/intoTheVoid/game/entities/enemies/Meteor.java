package dev.intoTheVoid.game.entities.enemies;

import dev.intoTheVoid.game.Game;
import dev.intoTheVoid.game.entities.projectiles.Projectile;
import dev.intoTheVoid.game.gfx.Assets;
import dev.intoTheVoid.game.sfx.SoundPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

// falling projectile
public class Meteor extends Projectile {

    private Assets assets;
    private boolean meteor = true;

    public Meteor(float x, float y, int speed, Game game) {
        super(game.getAssets().getSprite("projectile2"), x, y, defaultSize, defaultSize, game, speed, 1);
        id = "mProj";
        bounds.x = 20;
        bounds.y = 15;
        bounds.width *= 2;
        assets = game.getAssets();
    }

    public Meteor(float x, float y, int speed, Game game, BufferedImage sprite) {
        super(sprite, x, y, defaultSize, defaultSize, game, speed, 1);
        id = "mProj";
        bounds.x = 20;
        bounds.y = 15;
        bounds.width *= 2;
        assets = game.getAssets();
        meteor = false;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        if (!active)
            return;
        if (meteor) {
            if (getSpeed() > 0) {
                g.drawImage(getSprite(), (int) x, (int) y, (int) width, (int) height, null);
            } else if (getSpeed() == 0) {
                g.drawImage(assets.getSprite("projectile3"), (int) x, (int) y, (int) width, (int) height, null);
            }
            if (getSpeed() < 0) {
                g.drawImage(assets.getSprite("projectile4"), (int) x, (int) y, (int) width, (int) height, null);
            }
        }
        else {
            g.drawImage(getSprite(), (int) x, (int) y, (int) width, (int) height, null);
        }
    }

    @Override
    public void die() {
        super.die();
    }
}

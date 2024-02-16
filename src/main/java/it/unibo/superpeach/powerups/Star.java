package it.unibo.superpeach.powerups;

import java.awt.Graphics;

import it.unibo.superpeach.blocks.BlocksHandler;

public class Star extends PowerUp{

    public Star (int x, int y, int w, int h, int s, BlocksHandler blocksHandler) {
        super(x, y, w, h, s, blocksHandler, PowerUpType.STAR);
        setMovement(2);
        setIsFalling(false);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getImage()[2], getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {
        setIsFalling(true);
        collisions();
        updateCoords();
    }
    
}
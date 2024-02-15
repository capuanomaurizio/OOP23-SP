package it.unibo.superpeach.powerups;

import java.awt.*;

import it.unibo.superpeach.blocks.BlocksHandler;

public class LifeMushroom extends PowerUp{

    public LifeMushroom (int x, int y, int w, int h, int s, BlocksHandler blocksHandler) {
        super(x, y, w, h, s, blocksHandler);
        setMovement(2);
        setIsFalling(true);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getImage()[1],getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {
        setIsFalling(true);
        collisions();
        updateCoords();
    }
    
}

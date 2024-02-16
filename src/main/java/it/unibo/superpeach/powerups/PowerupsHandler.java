package it.unibo.superpeach.powerups;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerupsHandler {

    private List<PowerUp> powerups;

    public PowerupsHandler() {
        powerups = new ArrayList<PowerUp>();
    }

    public void tickPowerups() {
        Set<PowerUp> powerupsToRemove = new HashSet<>();
        for (PowerUp powerUp : powerups) {
            powerUp.tick();
            if (!powerUp.getIsAlive()) {
                powerupsToRemove.add(powerUp);
            }
        }

        for (PowerUp powerUp : powerupsToRemove) {
            powerups.remove(powerUp);
        }
    }

    public void renderPowerups(Graphics g) {
        for (PowerUp powerup : powerups) {
            powerup.render(g);
        }
    }

    public void addPowerUp(PowerUp p) {
        powerups.add(p);
    }

    public void removePowerUp(PowerUp p) {
        powerups.remove(p);
    }

    public List<PowerUp> getPowerups() {
        return List.copyOf(powerups);
    }

}

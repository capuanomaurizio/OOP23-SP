package it.unibo.superpeach.gameObjects.powerups;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.unibo.superpeach.game.Game;
import it.unibo.superpeach.gameentities.blocks.BlocksHandler;
import it.unibo.superpeach.gameentities.powerups.Coin;
import it.unibo.superpeach.gameentities.powerups.LifeMushroom;
import it.unibo.superpeach.gameentities.powerups.PowerupsHandler;
import it.unibo.superpeach.gameentities.powerups.RedMushroom;
import it.unibo.superpeach.gameentities.powerups.Star;

public class PowerupsHandlerTest {
    
    private static final int X = 12;
    private static final int Y = 12;

    private static final int WIDTH = 16;
    private static final int HEIGHT = 16;

    private static final int SCALE = 1;

    private final BlocksHandler blocksHandler = new BlocksHandler();
    private final PowerupsHandler powerupsHandler = new PowerupsHandler();

    Game game = new Game();

    @Test
    void powerupsHandlerTest() {
        
        game.init();

        // VERIFICO SE I POWERUPS VENGONO CORRETTAMENTE AGGIUNTI ALL'HANDLER
        powerupsHandler.addPowerUp(new RedMushroom(X, Y, WIDTH, HEIGHT, SCALE, blocksHandler));
        powerupsHandler.addPowerUp(new LifeMushroom(X, Y, WIDTH, HEIGHT, SCALE, blocksHandler));
        powerupsHandler.addPowerUp(new Star(X, Y, WIDTH, HEIGHT, SCALE, blocksHandler));
        powerupsHandler.addPowerUp(new Coin(X, Y, WIDTH, HEIGHT, SCALE, blocksHandler));

        assertEquals(4, powerupsHandler.getPowerups().size());

        // VERIFICO SE I POWERUPS VENGONO CORRETTAMENTE RIMOSSI DALL'HANDLER
        powerupsHandler.removePowerUp(powerupsHandler.getPowerups().get(1));
        assertEquals(3, powerupsHandler.getPowerups().size());

        // VERIFICO CORRETTA RIMOZIONE DEL POWERUP QUANDO MORTO
        assertTrue(powerupsHandler.getPowerups().get(0).getIsAlive());
        powerupsHandler.getPowerups().get(0).die();
        assertFalse(powerupsHandler.getPowerups().get(0).getIsAlive());
        powerupsHandler.removePowerUp(powerupsHandler.getPowerups().get(0));
        assertEquals(2, powerupsHandler.getPowerups().size());


    }

}
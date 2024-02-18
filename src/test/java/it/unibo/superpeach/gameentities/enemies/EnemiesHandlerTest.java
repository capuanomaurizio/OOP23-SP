
package it.unibo.superpeach.gameentities.enemies;

import org.junit.jupiter.api.Test;

import it.unibo.superpeach.game.Game;
import it.unibo.superpeach.gameentities.blocks.BlocksHandler;
import it.unibo.superpeach.gameentities.enemies.EnemiesHandler;
import it.unibo.superpeach.gameentities.enemies.FlyingKoopa;
import it.unibo.superpeach.gameentities.enemies.Goomba;
import it.unibo.superpeach.gameentities.enemies.KoopaTroopa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing the EnemyHandler class.
 * 
 * @author Eraldo Tabaku
 */
public class EnemiesHandlerTest {

    private static final int X = 12;
    private static final int Y = 14;
    private static final int WIDTH = 16;
    private static final int KOOPA_HEIGHT = 23;
    private static final int GOOMBA_HEIGHT = 16;
    private static final int SCALE = 1;
    private static final int KOOPA_SPEED = 2;
    private static final int FKOOPA_SPEED = 1;
    private static final int GOOMBA_SPEED = 1;

    private final static BlocksHandler blocksHandler = new BlocksHandler();

    /**
     * testing the method addEnemy.
     */
    @Test
    void testEnemyHandlerAddEnemy() {

        new Game().init();
        EnemiesHandler enemiesHandler1 = new EnemiesHandler();

        // Adding a new goomba to the Enemies Handler
        enemiesHandler1.addEnemy(new Goomba(X, Y, WIDTH, GOOMBA_HEIGHT, SCALE, blocksHandler));
        assertNotNull(blocksHandler);

        // Checking if the enemy got added correctly by checking if the first enemy in
        // enemis<Enemy> has the correct fields values
        assertEquals(X, enemiesHandler1.getEnemies().get(0).getX());
        assertNotEquals(Y, enemiesHandler1.getEnemies().get(0).getX());
        assertEquals(Y, enemiesHandler1.getEnemies().get(0).getY());
        assertNotEquals(X, enemiesHandler1.getEnemies().get(0).getY());
        assertEquals(WIDTH, enemiesHandler1.getEnemies().get(0).getWidth());
        assertNotEquals(KOOPA_HEIGHT, enemiesHandler1.getEnemies().get(0).getWidth());
        assertEquals(GOOMBA_HEIGHT, enemiesHandler1.getEnemies().get(0).getHeight());
        assertNotEquals(KOOPA_HEIGHT, enemiesHandler1.getEnemies().get(0).getHeight());
        assertEquals(SCALE, enemiesHandler1.getEnemies().get(0).getScale());
        assertNotEquals(KOOPA_HEIGHT, enemiesHandler1.getEnemies().get(0).getScale());
        assertEquals(blocksHandler, enemiesHandler1.getEnemies().get(0).getBlocksHandler());

        // Checking if the enemy is alive
        assertTrue(enemiesHandler1.getEnemies().get(0).isAlive());

        // Removing the previosly added enemy
        enemiesHandler1.removeEnemy(enemiesHandler1.getEnemies().get(0));

    }

    /**
     * Testing the removeEnemy method.
     */
    @Test
    public void testenemiesHandlerRemoveEnemy() {

        new Game().init();

        EnemiesHandler enemiesHandler2 = new EnemiesHandler();

        enemiesHandler2.addEnemy(new KoopaTroopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler2.addEnemy(new FlyingKoopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler2.addEnemy(new Goomba(X, Y, WIDTH, GOOMBA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler2.addEnemy(new FlyingKoopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler2.addEnemy(new Goomba(X, Y, WIDTH, GOOMBA_HEIGHT, SCALE, blocksHandler));

        // Checking if the number of enemies in List<Enemy> of the EnemyHandler is
        // correct
        assertEquals(5, enemiesHandler2.getEnemies().size());
        enemiesHandler2.removeEnemy(enemiesHandler2.getEnemies().get(1));
        assertEquals(4, enemiesHandler2.getEnemies().size());
        enemiesHandler2.removeEnemy(enemiesHandler2.getEnemies().get(1));
        assertEquals(3, enemiesHandler2.getEnemies().size());
        enemiesHandler2.removeEnemy(enemiesHandler2.getEnemies().get(1));
        assertEquals(2, enemiesHandler2.getEnemies().size());
        enemiesHandler2.removeEnemy(enemiesHandler2.getEnemies().get(1));
        assertEquals(1, enemiesHandler2.getEnemies().size());

        // Checking if the remaining enemy is the correct one
        assertEquals(X, enemiesHandler2.getEnemies().get(0).getX());
        assertEquals(Y, enemiesHandler2.getEnemies().get(0).getY());
        assertEquals(WIDTH, enemiesHandler2.getEnemies().get(0).getWidth());
        assertEquals(KOOPA_HEIGHT, enemiesHandler2.getEnemies().get(0).getHeight());
        assertEquals(SCALE, enemiesHandler2.getEnemies().get(0).getScale());
        assertEquals(blocksHandler, enemiesHandler2.getEnemies().get(0).getBlocksHandler());
    }

    /**
     * Testing the enemiesTick method.
     */
    @Test
    public void testTickEnemies() {

        new Game().init();

        EnemiesHandler enemiesHandler3 = new EnemiesHandler();

        // Checking if the tick method correctly updates all enemies coordinates
        enemiesHandler3.addEnemy(new KoopaTroopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler3.addEnemy(new FlyingKoopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler3.addEnemy(new Goomba(X, Y, WIDTH, GOOMBA_HEIGHT, SCALE, blocksHandler));

        enemiesHandler3.tickEnemies();

        assertEquals(X + KOOPA_SPEED, enemiesHandler3.getEnemies().get(0).getX());
        assertEquals(X + FKOOPA_SPEED, enemiesHandler3.getEnemies().get(1).getX());
        assertEquals(X + GOOMBA_SPEED, enemiesHandler3.getEnemies().get(2).getX());

    }

    /**
     * Testing if the enemies correctly die.
     */
    @Test
    public void testDeadEnemies() {

        new Game().init();

        EnemiesHandler enemiesHandler4 = new EnemiesHandler();

        // Adding a new enemy and then changing his "isAlive" field to "false"
        // to check if dead enemies are removed automatically correctly
        enemiesHandler4.addEnemy(new KoopaTroopa(X, Y, WIDTH, KOOPA_HEIGHT, SCALE, blocksHandler));
        enemiesHandler4.getEnemies().get(0).die();
        assertFalse(enemiesHandler4.getEnemies().get(0).isAlive());
        enemiesHandler4.tickEnemies();

        assertEquals(0, enemiesHandler4.getEnemies().size());

    }
}

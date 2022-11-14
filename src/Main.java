import object.Enemy;
import pool.EnemyPool;

/**
 * This is the tester class for the Object Pool.
 * @author Conor O'Brien
 * @version 1.0
 */
public class Main
{
    /**
     * This is the 'PSVM' driver function.
     * @param args string array of arguments
     */
    public static void main(String[] args)
    {
        EnemyPool<Enemy> bunchOfEnemies = new EnemyPool<>(5);

        /*TODO: test pulling out enemies for fights, test putting them back, eventually provide
                                            a runtime analysis between this and not using this...?*/

        Enemy thisOne = bunchOfEnemies.fightEnemy();
        thisOne.attackEnemy(50);
        bunchOfEnemies.returnEnemy(thisOne);



    }
}
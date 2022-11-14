import data.EnemyInfo;
import object.Enemy;
import pool.EnemyPool;

import java.util.List;

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
        EnemyInfo creatorInfo = EnemyInfo.getInstance();
        EnemyPool<Enemy> bunchOfEnemies = new EnemyPool<>(5);

        //TODO: loop and create like... 10 of these
        Enemy testEnemy = new Enemy(creatorInfo.getRandomName(), creatorInfo.getRandomHitPoints(), List.of("No"));

        /*TODO: provide a package with just enemy class, enemy info singleton class, asciiart*/
        /*TODO: write a simple driver program for console user input*/

        /*TODO: test pulling out enemies for fights, test putting them back, eventually provide
                                            a runtime analysis between this and not using this...?*/



        Enemy thisOne = bunchOfEnemies.fightEnemy();
        thisOne.attackEnemy(50);
        bunchOfEnemies.returnEnemy(thisOne);



    }

    /**
     * This method contains the code for the user's console interactions.
     */
    public void consoleDriver()
    {
        /*TODO: create the program for user interactions*/
    }
}
package objectpooltests;

import object.Enemy;

/**
 * This is the tester class for comparison to the Object pool tester.
 * @author Conor O'Brien
 * @version 1.0
 */
public class ComparisonMain
{
    /*test constants*/
    public static final int ARR_SIZE = 100000;
    public static final int TOTAL_LOOPS = 1000;

    /**
     * This is the 'PSVM' driver function.
     * @param args string array of arguments
     */
    public static void main(String[] args)
    {
        /* TEST REGULAR OBJECT INSTANTIATION RUNTIME*/
        Enemy[] enemies = new Enemy[ARR_SIZE];

        long startTime = System.currentTimeMillis();

        for(int x = 0; x < TOTAL_LOOPS; x++)
        {
            fillArray(enemies);
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("ELAPSED TIME: " + elapsedTime + "ms");

        /* TEST REGULAR OBJECT INSTANTIATION MEMORY USAGE */
        System.out.println("COMPARISON MEMORY USAGE: " +
                ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1000*1000)) + "MB");
    }

    /**
     * This method loops through the instantiated array and fills it with Enemy objects.
     * @param enemyArray array to fill
     */
    public static void fillArray(Enemy[] enemyArray)
    {
        for(int x = 0; x < enemyArray.length; x++)
        {
            new Enemy();
        }
    }
}

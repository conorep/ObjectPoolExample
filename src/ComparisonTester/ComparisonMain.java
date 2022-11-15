import object.Enemy;

/**
 * This is the tester class for comparison to the Object pool tester.
 * @author Conor O'Brien
 * @version 1.0
 */
public class ComparisonMain
{
    /**
     * This is the 'PSVM' driver function.
     * @param args string array of arguments
     */
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();

        Enemy[] enemies = new Enemy[10];
        for(int x = 0; x < enemies.length; x++)
        {
           new Enemy();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("ELAPSED TIME: " + elapsedTime);
    }
}

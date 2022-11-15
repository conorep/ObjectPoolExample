import object.Enemy;
import pool.EnemyPool;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the tester class for the Object Pool.
 * @author Conor O'Brien
 * @version 1.0
 */
public class ObjectPoolMain
{
    /*test constants*/
    public static final int COLLECTION_SIZE = 100000;
    public static final int TOTAL_LOOPS = 1000;
    public static final  Scanner[] readerArray;
    static
    {
        try
        {
            readerArray = new Scanner[]{
                    new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyDead.txt")),
                    new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyFace.txt")),
                    new Scanner(new File(ObjectPoolMain.asciiPathString()+"sword.txt")),
                    new Scanner(new File(ObjectPoolMain.asciiPathString()+"swordAttack.txt"))};
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * This is the 'PSVM' driver function.
     * @param args string array of arguments
     * @throws FileNotFoundException when scanner can't find required files
     */
    public static void main(String[] args) throws FileNotFoundException
    {

        /* RUN THE OBJECT POOL TESTS (RUNTIME AND MEMORY USAGE) */
        runPoolTest();

        /* KICK OFF THE PROGRAM. UNCOMMENT THIS AND SCANNER ARRAY TO RUN. */
        consoleDriver();
    }

    /**
     * This function runs the pool tests.
     */
    public static void runPoolTest()
    {
        /* TEST POOL RUNTIME SECTION */
        Enemy[] transferArr = new Enemy[COLLECTION_SIZE];

        long startTime = System.currentTimeMillis();

        EnemyPool testingPool = new EnemyPool(COLLECTION_SIZE);
        for(int x = 0; x < TOTAL_LOOPS; x++)
        {
            poolTest(testingPool, transferArr);
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("ELAPSED TIME: " + elapsedTime);

        /* TEST POOL MEMORY USAGE */
        System.out.println("POOL TEST MEMORY USAGE: " +
                ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1000*1000)) + "MB");
    }

    /**
     * This function checks out Enemy objects from the pool and then sends them back.
     *      NOTE: this is a slightly imperfect test to show the large margin of difference
     *      between instantiating new objects and simply reusing objects kept in a pool.
     * @param transferPool pool of Enemy objects to transfer to array and back
     * @param transferArr array used for get and return of Enemy objects
     */
    public static void poolTest(EnemyPool transferPool, Enemy[] transferArr)
    {
        for(int x = 0; x < transferPool.getCapacity(); x++)
        {
            transferArr[x] = transferPool.getEnemy();
        }
        for(int x = 0; x < transferPool.getCapacity(); x++)
        {
            transferPool.returnEnemyToPool(transferArr[x]);
        }
    }

    /**
     * This method contains the code for the user's console interactions.
     * @throws  FileNotFoundException thrown when files can't be found
     */
    public static void consoleDriver() throws FileNotFoundException
    {
        Scanner consoleHandling = new Scanner(System.in);
        Random randomDamage = new Random();
        EnemyPool bunchOfEnemies = new EnemyPool(20);

        String lineSeparator = "\n********************\n";
        System.out.println(lineSeparator+"Welcome to The Game!"+lineSeparator+"GAME STARTING:\n");

        asciiArtReader(1);

        Enemy thisOne = bunchOfEnemies.getEnemy();
        System.out.println(thisOne);
        boolean keepPlaying = true;
        while(keepPlaying)
        {
            gameMenu();
            String userInput = consoleHandling.nextLine();

            switch (userInput)
            {
                case "0" -> keepPlaying = false;
                case "1" ->
                {
                    //attack enemy with a value somewhere between 1 and 500
                    asciiArtReader(3);
                    thisOne.attackEnemy(randomDamage.nextInt(500) + 1);
                    if(thisOne.isDead())
                    {
                        asciiArtReader(0);
                        System.out.println("DEAD ENEMY ROLLED DOWN HILL. NEW ENEMY!\n");
                        bunchOfEnemies.returnEnemyToPool(thisOne);
                        thisOne = bunchOfEnemies.getEnemy();
                        System.out.println(thisOne);
                    }
                }
                case "2" ->
                {
                    bunchOfEnemies.returnEnemyToPool(thisOne);
                    thisOne = bunchOfEnemies.getEnemy();
                    System.out.println("ENEMY RETURNED. NEW ENEMY!\n");
                    System.out.println(thisOne);
                }
                case "3" ->
                {
                    System.out.println("\nENEMY INFO:\n" + thisOne);
                }
                default ->
                {
                    System.out.println("\nWRONG. YOU CAN ONLY ENTER 0, 1, 2, OR 3 IN THIS EXCITING GAME.");
                    gameMenu();
                }
            }
        }
        gameOver();
    }

    /**
     * This class reads ASCII art from its folder and displays it in console.
     *    0: dead enemy
     *    1: new enemy
     *    3: sword
     *    4: attack sword
     * @param choice int 0 - 3. chooses between files
     * @throws FileNotFoundException exception if file not found
     */
    public static void asciiArtReader(int choice) throws FileNotFoundException
    {
        /*0 is dead, 1 is alive, 2 is sword, 3 is sword attack*/
        Scanner[] readerArray = new Scanner[]{
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyDead.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyFace.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"sword.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"swordAttack.txt"))};
        switch(choice)
        {
            case 0 -> readFileOut(readerArray[0]);
            case 1 -> readFileOut(readerArray[1]);
            case 2 -> readFileOut(readerArray[2]);
            case 3 -> readFileOut(readerArray[3]);
            default -> System.out.println(".... how did you choose this?");
        }
    }

    /**
     * This reads the ASCII art text files to console.
     * @param readThisScanner the particular scanner holding a particular file.
     */
    public static void readFileOut(Scanner readThisScanner)
    {
        while(readThisScanner.hasNextLine())
        {
            System.out.println(readThisScanner.nextLine());
        }
    }

    /**
     * This class prints the "game's" menu.
     */
    public static void gameMenu()
    {
        System.out.print("""
                
                Instructions:
                ~~~~0 = END GAME
                ~~~~1 = ATTACK ENEMY
                ~~~~2 = RETURN ENEMY
                ~~~~3 = ENEMY INFO
                ~~~~MAKE YOUR CHOICE:
                #\040""");
    }

    /**
     * This returns the local path of the Intellij instance running this process
     * @return String representation of path
     */
    public static String asciiPathString()
    {
        return new File("").getAbsolutePath() + "/src/asciiart/";
    }

    /**
     * This prints out a game ending line.
     * @throws FileNotFoundException exception if file not found
     */
    public static void gameOver() throws FileNotFoundException
    {
        System.out.println("\nTHANKS FOR PLAYING THIS HIGH QUALITY GAME. GAME ENDED.");
        asciiArtReader(2);
    }
}


import data.EnemyInfo;
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
    /**
     * This is the 'PSVM' driver function.
     * @param args string array of arguments
     * @throws FileNotFoundException when scanner can't find required files
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        /*0 is dead, 1 is alive, 2 is sword, 3 is sword attack*/
        Scanner[] readerArray = new Scanner[]{
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyDead.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"enemyFace.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"sword.txt")),
                new Scanner(new File(ObjectPoolMain.asciiPathString()+"swordAttack.txt"))};


        //TODO: RUNTIME ANALYSIS OF CREATE ALL ENEMIES IN POOL VS CREATE SAME NUMBER OF ENEMIES ONE BY ONE

    /*kick off the program*/
        consoleDriver(readerArray);
    }

    /**
     * This method contains the code for the user's console interactions.
     */
    protected static void consoleDriver(Scanner[] readerArray) throws FileNotFoundException
    {
        Scanner consoleHandling = new Scanner(System.in);
        Random randomDamage = new Random();
        EnemyPool<Enemy> bunchOfEnemies = new EnemyPool<>(10);

        String lineSeparator = "\n****************************************\n";
        String welcomeString = lineSeparator+"Welcome to the game!"+lineSeparator+"GAME STARTING:\n";

        asciiArtReader(1);

        Enemy thisOne = bunchOfEnemies.fightEnemy();

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
                    //todo: check for Enemy isDead! if dead, return and get new one
                    if(thisOne.isDead())
                    {
                        System.out.println("DEAD ENEMY ROLLED DOWN HILL. NEW ENEMY!");
                        bunchOfEnemies.returnEnemyToPool(thisOne);
                        thisOne = bunchOfEnemies.fightEnemy();
                        System.out.println(thisOne);
                    }
                }
                case "2" ->
                {
                    bunchOfEnemies.returnEnemyToPool(thisOne);
                    thisOne = bunchOfEnemies.fightEnemy();
                    System.out.println("ENEMY RETURNED. NEW ENEMY!");
                    System.out.println(thisOne);
                }
                case "3" ->
                {
                    System.out.println(thisOne);
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
     */
    protected static void asciiArtReader(int choice) throws FileNotFoundException
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
    protected static void readFileOut(Scanner readThisScanner)
    {
        while(readThisScanner.hasNextLine())
        {
            System.out.println(readThisScanner.nextLine());
        }
    }

    /**
     * This class prints the "game's" menu.
     */
    protected static void gameMenu()
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
    protected static String asciiPathString()
    {
        return new File("").getAbsolutePath() + "/src/asciiart/";
    }

    /**
     * This prints out a game ending line.
     */
    protected static void gameOver()
    {
        System.out.println("\nThanks for playing. Game ended.");
    }
}


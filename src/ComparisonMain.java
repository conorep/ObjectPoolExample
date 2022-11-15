import data.EnemyInfo;
import object.Enemy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/*TODO: provide a package with just enemy class, enemy info singleton class, asciiart*/
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
     * @throws FileNotFoundException when scanner can't find required files
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        EnemyInfo creatorInfo = EnemyInfo.getInstance();
        Enemy[] enemies = new Enemy[10];
        for(int x = 0; x < enemies.length; x++)
        {
           new Enemy();
        }

    }
}

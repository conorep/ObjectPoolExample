package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This singleton class provides a random name from the names list.
 * @author Conor O'Brien
 * @version 1.0
 */
public class EnemyInfo
{
    private static EnemyInfo namesInstance;
    private List<String> names;
    private List<String> abilities;
    private Random random = new Random();

    /**
     * This private constructor is called by getInstance. It instantiates an arraylist of names.
     */
    private EnemyInfo()
    {
        this.names = new ArrayList<>();
        this.abilities = new ArrayList<>();
        addNames(this.names);
        addAbilities(this.abilities);
    }

    /**
     * This method returns an instance of EnemyInfo
     * @return namesInstance
     */
    public static EnemyInfo getInstance()
    {
        if(namesInstance == null)
        {
            namesInstance = new EnemyInfo();
        }
        return namesInstance;
    }

    //TODO: add more names
    /**
     * This class adds all the names to the names list.
     * @param names name that will be tied to an enemy
     */
    private static void addNames(List<String> names)
    {
        names.add("General Feet");
        names.add("Medium Man");
        names.add("Federal Friend");
        names.add("Colonel Hand");
        names.add("Arid Offel");
        names.add("Nick");
        names.add("Every Person");
        names.add("Woah Dude");
        names.add("Great Guy");
        names.add("Elise Eloise");
        names.add("Hydrangea");
        names.add("Hydro Nicole");
        names.add("Oh Wow");
        names.add("Left Side");
        names.add("For Each");
        names.add("Jeraime");
        names.add("Weent");
        names.add("Back Neck");
        names.add("Ventricles Girl");
        names.add("Never");
        names.add("THE FUTURE");
    }


    //TODO: add more abilities
    /**
     * This class adds all the abilities to the ability list.
     * @param abilities abilities that will be tied to an enemy
     */
    private static void addAbilities(List<String> abilities)
    {
        abilities.add("Fall Down");
        abilities.add("Elevate");
        abilities.add("Go Up Down Escalator");
        abilities.add("Wring Hands");
        abilities.add("Stress");
        abilities.add("Get Angered");
        abilities.add("Do Nothing But Look Like Doing Something");
        abilities.add("Hold Book");
        abilities.add("Drop Book");
        abilities.add("Open Book");
        abilities.add("Read Graffiti Badly");
    }

    /**
     * Return a random name from the collection of names.
     * @return String name for new enemy
     */
    public String getRandomName()
    {
        return this.names.get(this.random.nextInt(this.names.size()));
    }

    /**
     * Return a random number between 1 and 1000.
     * @return integer between 1 and 1000
     */
    public int getRandomHitPoints()
    {
        return this.random.nextInt(1000) +1;
    }

    @Override
    public String toString()
    {
        return "RandomNames List:\n" + names + '\n';
    }
}

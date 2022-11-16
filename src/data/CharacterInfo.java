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

    /**
     * This class adds all the names to the names list.
     * @param names name that will be tied to an enemy
     */
    private static void addNames(List<String> names)
    {
        names.addAll(List.of(
                "General Feet", "Medium Man", "Federal Friend", "Colonel Hand", "Arid Offel", "Nick", "Every Person",
                "Woah Dude", "Great Guy", "Elise Eloise", "Hydrangea", "Hydro Nicole", "Oh Wow", "Left Side",
                "For Each", "Jeraime", "Weent", "Back Neck", "Ventricles Girl", "Never", "THE FUTURE",
                "WHAM BAM Tambourine Man", "Butt-Cart Doggo seeking revenge",
                "Half-Empty carton of 'I can't believe it's not butter!'", "Literally Mel Gibson",
                "Sunday-Evening Monday-Morning Dread", "Two full-sized ferrets and a sleeve of Ritz crackers",
                "Slippery Kyle", "Potentially used band-aid floating in the pool", "Uncle Mitch",
                "Surprise, It's Nate!", "Guy who won't shut up while you are trying to leave the party",
                "Cellphone that has slid in-between your driver seat and center-console", "Marcus",
                "The coupons that get printed with your receipt that you are definitely going to just throw-away",
                "Local Plumber with competitive service prices", "Lego piece hidden in a high-pile rug",
                "Suspicious white speck on a two-week-old block of cheese",
                "The physical embodiment of having to do math in front of a group of people", "Two Left Socks"
        ));
    }

    /**
     * This class adds all the abilities to the ability list.
     * @param abilities abilities that will be tied to an enemy
     */
    private static void addAbilities(List<String> abilities)
    {
        abilities.addAll(List.of(

        ));
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
        abilities.add("Ties shoes fast and efficiently");
        abilities.add("Need to get your glasses or this is going to take awhile");
        abilities.add("Order a ceasar salad");
        abilities.add("Take Nap");
        abilities.add("Remembers to Floss Twice Daily");
        abilities.add("Breathe Underwater");
        abilities.add("Never Needs to Wash Hands");
        abilities.add("Content with all current material possessions");
        abilities.add("Embroiders one garment");
        abilities.add("Thinks about squirrels");
        abilities.add("All number two's instantly converted to number one's");
        abilities.add("Slaps previously tied-down thing and says 'That's not going anywhere'");
        abilities.add("Just gets sick and tired of all the drama going on in the world");
        abilities.add("Goes on a cruise");
        abilities.add("Hammer Fists");
        abilities.add("Shirt is on backwards");
        abilities.add("Kneads Dough Vigorously");
        abilities.add("Tries and Fails at re-organizing pantry");
        abilities.add("Heat Vision");
        abilities.add("Really Toned Shoulders");
        abilities.add("Is totally fine to drive, actually hasn't had a beer in a couple of hours");
        abilities.add("Likes the taste of Cilantro");
        abilities.add("Pudding Breath");
        abilities.add("Makes positive things happen in their life by working hard and never giving up");
        abilities.add("Ability to say 'No'");
        abilities.add("Reaches into pocket and finds a crisp $5");
        abilities.add("Once had a short conversation with former child star Haley Joel Osment");
        abilities.add("Wishes people would just 'lighten up' once in awhile");
        abilities.add("Question Mark Kick");
        abilities.add("Performs a slow but deliberate reenactment of Homeward Bound");
        abilities.add("Never makes eye-contact");
        abilities.add("Bad at lying");
        abilities.add("Just wants everyone to get along");

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

    /**
     * This returns three random abilities from the ability list.
     * @return String List with three abilities.
     */
    public List<String> getThreeAbilities()
    {
        return List.of(
                this.abilities.get(this.random.nextInt(this.abilities.size())),
                this.abilities.get(this.random.nextInt(this.abilities.size())),
                this.abilities.get(this.random.nextInt(this.abilities.size()))
        );
    }

    @Override
    public String toString()
    {
        return "RandomNames List:\n" + names + '\n';
    }
}

package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This singleton class provides a random name from the names list.
 * @author Conor O'Brien
 * @version 1.0
 */
public class CharacterInfo
{
    private static CharacterInfo namesInstance;
    private List<String> names;
    private List<String> abilities;
    private Random random = new Random();

    /**
     * This private constructor is called by getInstance. It instantiates an arraylist of names.
     */
    private CharacterInfo()
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
    public static CharacterInfo getInstance()
    {
        if(namesInstance == null)
        {
            namesInstance = new CharacterInfo();
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
                "For Each", "Jeraime", "Weent", "Back Neck", "Ventricles Girl", "Never", "THE FUTURE","Uncle Mitch",
                "WHAM BAM Tambourine Man", "Butt-Cart Doggo seeking revenge", "Slippery Kyle", "Marcus",
                "Half-Empty carton of 'I can't believe it's not butter!'", "Literally Mel Gibson",
                "Sunday-Evening Monday-Morning Dread", "Two full-sized ferrets and a sleeve of Ritz crackers",
                "Potentially used band-aid floating in the pool",  "Lego piece hidden in a high-pile rug",
                "Surprise, It's Nate!", "Guy who won't shut up while you are trying to leave the party",
                "Cellphone that has slid in-between your driver seat and center-console",
                "The coupons that get printed with your receipt that you are definitely going to just throw-away",
                "Local Plumber with competitive service prices", "Two Left Socks",
                "Suspicious white speck on a two-week-old block of cheese",
                "The physical embodiment of having to do math in front of a group of people"
        ));
    }

    /**
     * This class adds all the abilities to the ability list.
     * @param abilities abilities that will be tied to an enemy
     */
    private static void addAbilities(List<String> abilities)
    {
        abilities.addAll(List.of(
                "Fall Down", "Elevate", "Go Up Down Escalator", "Wring Hands", "Stress", "Get Angered",
                "Do Nothing But Look Like Doing Something", "Hold Book", "Drop Book", "Open Book",
                "Ties Shoes Fast and Efficiently", "Need to Get Your Glasses or This is Going to Take Awhile",
                "Order a caesar salad", "Take Nap", "Remembers to Floss Twice Daily", "Breathe Underwater",
                "Never Needs to Wash Hands", "Content With All Current Material Possessions", "Embroiders One Garment",
                "Thinks About Squirrels", "All Number Twos Instantly Converted to Number Ones",
                "Slaps Previously Tied-Down Thing and Says 'That's Not Going Anywhere'", "Read Graffiti Badly",
                "Just Gets Sick and Tired of All the Drama Going On in the World", "Goes On a Cruise", "Hammer Fists",
                "Shirt Is On Backwards", "Kneads Dough Vigorously", "Tries and Fails at Re-organizing Pantry",
                "Is Totally Fine to Drive, Actually Hasn't Had a Beer in a Couple of Hours",
                "Likes the Taste of Cilantro", "Pudding Breath", "Heat Vision", "Really Toned Shoulders",
                "Makes Positive Things Happen in their Life by Working Hard and Never Giving Up", "Ability to Say 'NO'",
                "Reaches Into Pocket and Finds a Crisp $5", "Bad At Lying", "Just Wants Everyone to Get Along",
                "Once Had a Short Conversation With Former Child Star 'Haley Joel Osment'",
                "Wishes People Would Just 'LIGHTEN UP' Once in A While", "Question Mark Kick",
                "Performs a Slow but Deliberate Reenactment of Homeward Bound", "Never Makes Eye Contact"

        ));
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
     * Return a random ability to set as Player character's weakness.
     * @return String ability weakness.
     */
    public String getWeakness()
    {
        return this.abilities.get(this.random.nextInt(this.abilities.size()));
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

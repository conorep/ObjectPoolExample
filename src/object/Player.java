package object;

/**
 * This class represents the player's character.
 *  killCount: how many Enemy objects the Player has killed
 *  abilityWeakness: an enemy ability that may be encountered which causes significant issues for the Player
 * @author Conor O'Brien
 * @version 1.0
 */
public class Player extends CharacterType
{
    public static final int SPECIAL_ATTACK = 200;
    private int killCount = 0;
    private String abilityWeakness;

    /**
     * This is the Player constructor.
     */
    public Player()
    {
        super();
        this.name = "IDK. Whatever you want your name to be I guess?";
        initializeHP();
        this.abilityWeakness = this.characterInfo.getWeakness();
    }

    /**
     * This method initializes the player's HP to 1000.
     */
    @Override
    protected void initializeHP()
    {
        this.maxHitPoints = 1000;
        this.currentHitPoints = 1000;
    }

    /**
     * This method sets the player's current hit points when attacked. It is called on the Player object itself.
     *  If the current points are equal to or less than 0, isDead is toggled to true.
     * @param attackDamage amount of damage taken from attack
     */
    @Override
    public void attackCharacter(int attackDamage)
    {
        System.out.println("\nAh heck - you've been attacked!\n"
                + "HP before attack: " + this.currentHitPoints + "\nAttack damage: " + attackDamage
                + "\nHealth after: " + (this.currentHitPoints - attackDamage));
        this.currentHitPoints -= attackDamage;
        butDidYouDie();
    }

    /**
     * This method causes an automatic 200 HP loss due to a matched character ability weakness.
     */
    public void attackCharacterWeakness()
    {
        System.out.println("\nUH OHHHHH!\nThis enemy has the ability to exploit your weakness to '" +
                abilityWeakness + "'. I smell trouble (and FUNK)!\n" + "HP before attack: " +
                this.currentHitPoints + "\nSpecial attack damage: " + SPECIAL_ATTACK +
                "\nHealth after: " + (this.currentHitPoints - SPECIAL_ATTACK));
        this.currentHitPoints -= SPECIAL_ATTACK;
        butDidYouDie();
    }

    /**
     * This method checks for a state of death and, if found, sets isDead to true while printing some text.
     */
    private void butDidYouDie()
    {
        if(currentHitPoints <= 0)
        {
            System.out.println("You've died. What a waste!!");
            this.isDead = true;
        }
    }

    /**
     * This method returns the player's kill count.
     * @return int kill count
     */
    public int getKillCount()
    {
        return killCount;
    }

    /**
     * This method adds one to the player's current kill count.
     * @return int count of kills after method has been called.
     */
    public int setKillCount()
    {
        this.killCount++;
        return killCount;
    }

    /**
     * This method returns the player's ability weakness.
     * @return String player weakness
     */
    public String getAbilityWeakness()
    {
        return this.abilityWeakness;
    }

    @Override
    public String toString()
    {
        return " *PLAYER NAME: " + this.name + "\n *MAX HP: " + this.maxHitPoints +
                "\n *CURRENT HP: " + this.currentHitPoints + "\n *WEAKNESS: " + abilityWeakness +
                "\n *PLAYER KILL COUNT: " + this.killCount;
    }
}

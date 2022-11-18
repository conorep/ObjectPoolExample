package object;

import data.CharacterInfo;

/**
 * This abstract class sets the interface for Enemy and Player Character classes.
 * @author Conor O'Brien
 * @version 1.0
 */
public abstract class CharacterType
{
    protected CharacterInfo characterInfo = CharacterInfo.getInstance();
    protected String name;
    protected int maxHitPoints;
    protected int currentHitPoints;
    protected boolean isDead;

    /**
     * This getter returns the maximum hit points for an enemy.
     * @return maximum hit points of enemy
     */
    public int getMaxHitPoints()
    {
        return maxHitPoints;
    }

    /**
     * This getter returns the current hit points for an enemy.
     * @return current hit points
     */
    public int getCurrentHitPoints()
    {
        return currentHitPoints;
    }

    /**
     * This getter returns an enemy name.
     * @return enemy's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This getter returns the current living state of an enemy.
     * @return true if dead, false if alive
     */
    public boolean isDead()
    {
        return this.isDead;
    }

    /**
     * This abstract method enforces setting a character's max and current HP.
     */
    protected abstract void initializeHP();

    /**
     * This abstract method enforces an attack on the character object.
     * @param attackDamage int value of damage to character
     */
    protected abstract void attackCharacter(int attackDamage);

    @Override
    public String toString()
    {
        return "I hope you never have to see this!";
    }
}

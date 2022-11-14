package object;

import java.util.List;

/**
 * This class represents a unique enemy.
 * @author Conor O'Brien
 * @version 1.0
 */
public class Enemy
{
    private String name;
    private int maxHitPoints;
    private int currentHitPoints;
    private boolean isDead;
    private List<String> abilities;

    /**
     * The enemy constructor. Requires a name, max hit points, and a list of abilities.
     * @param name what the enemy is called
     * @param maxHitPoints maximum health points
     * @param abilities what the enemy can do
     */
    public Enemy(String name, int maxHitPoints, List<String> abilities)
    {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = maxHitPoints;
        this.abilities = abilities;
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
     * This getter returns the current living state of an enemy.
     * @return true if dead, false if alive
     */
    public boolean isDead()
    {
        return isDead;
    }

    /**
     * This getter returns a list of an enemy's abilities.
     * @return list of abilities
     */
    public List<String> getAbilities()
    {
        return abilities;
    }

    /**
     * This method sets the enemy's current hit points when attacked.
     *  If the current points are equal to or less than 0, isDead is toggled to true.
     * @param attackDamage amount of damage taken from attack
     */
    public void attackEnemy(int attackDamage)
    {
        System.out.println(this.name + " was attacked!\n"
                + "HP before attack: " + this.currentHitPoints + "\nAttack damage: " + attackDamage
                + "\nHealth after: " + (this.currentHitPoints - attackDamage) + "\n");
        this.currentHitPoints -= attackDamage;

        if(currentHitPoints <= 0)
        {
            System.out.println(this.name + " is dead. Bummer!");
            this.isDead = true;
        }
    }

    /**
     * This returns an enemy to life.
     */
    public void resurrectEnemy()
    {
        this.isDead = false;
    }

    //TODO: fix this. it sucks.
    @Override
    public String toString()
    {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", maxHitPoints=" + maxHitPoints +
                ", currentHitPoints=" + currentHitPoints +
                ", isDead=" + isDead +
                ", abilities=" + abilities +
                '}';
    }
}

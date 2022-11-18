package object;

import java.util.List;

/**
 * This class represents a unique enemy.
 *  abilities: three special abilities that an Enemy can have. if one matches the Player character, it is used in combat
 *      and hurts the Player object significantly
 * @author Conor O'Brien
 * @version 1.0
 */
public class Enemy extends CharacterType
{
    private List<String> abilities;

    /**
     * The enemy constructor. Requires a list of abilities and auto-generates a name and hit points.
     */
    public Enemy()
    {
        super();
        this.name = this.characterInfo.getRandomName();
        initializeHP();
        this.abilities = this.characterInfo.getThreeAbilities();
    }

    /**
     * This method initializes the Enemy object's HP randomly and sets its current HP to that value.
     */
    @Override
    protected void initializeHP()
    {
        this.maxHitPoints = this.characterInfo.getRandomHitPoints();
        this.currentHitPoints = this.maxHitPoints;
    }

    /**
     * This method sets the enemy's current hit points when attacked. It is called on the Enemy object itself.
     *  If the current points are equal to or less than 0, isDead is toggled to true.
     * @param attackDamage amount of damage taken from attack
     */
    @Override
    public void attackCharacter(int attackDamage)
    {
        System.out.println(this.name + " was attacked!\n"
                + "HP before attack: " + this.currentHitPoints + "\nAttack damage: " + attackDamage
                + "\nHealth after: " + (this.currentHitPoints - attackDamage));
        this.currentHitPoints -= attackDamage;

        if(currentHitPoints <= 0)
        {
            System.out.println(this.name + " is dead. Bummer!");
            this.isDead = true;
        }
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
     * This returns an enemy to life and gives it a new name and hit point value.
     */
    public void resurrectEnemy()
    {
        this.isDead = false;
        this.name = this.characterInfo.getRandomName();
        this.maxHitPoints = this.characterInfo.getRandomHitPoints();
        this.currentHitPoints = this.maxHitPoints;
    }

    /**
     * This private method returns a formatted string representation of an Enemy's three abilities.
     * @return String abilities
     */
    private String returnAbilities()
    {
        StringBuilder buildAbilities = new StringBuilder();
        for(String ability : this.abilities)
        {
            buildAbilities.append(" [").append(ability).append("] ");
        }
        return buildAbilities.toString();
    }

    @Override
    public String toString()
    {
        return " *ENEMY NAME: " + this.name + "\n *MAX HP: " + this.maxHitPoints +
                "\n *CURRENT HP: " + this.currentHitPoints + "\n *ABILITIES: " + returnAbilities();
    }
}

package completedpool;

import object.Enemy;

/**
 * This class represents a pool of Enemies.
 * @author Conor O'Brien
 * @version 1.0
 */
public class EnemyPool
{
    private ObjectPool<Enemy> enemyPool;

    /**
     * This is the EnemyPool constructor.
     * @param objectPoolSize int size of objectPool
     */
    public EnemyPool(int objectPoolSize)
    {
        this.enemyPool = new ObjectPool<>(objectPoolSize)
        {
            @Override
            protected Enemy createObject()
            {
                return new Enemy();
            }
        };
    }

    /**
     * This method returns the max capacity of the storage object.
     * @return int capacity
     */
    public int getCapacity()
    {
        return enemyPool.getCapacity();
    }

    /**
     * Draw out an enemy to fight them!
     * @return Enemy object
     */
    public Enemy getEnemy()
    {
        return enemyPool.borrowObject();
    }

    /**
     * Let an enemy return to its hole.
     * @param enemy object to return
     */
    public void returnEnemyToPool(Enemy enemy)
    {
        if(enemy.isDead())
        {
            enemy.resurrectEnemy();
        }
        enemyPool.returnObject(enemy);
    }

    @Override
    public String toString()
    {
        return "EnemyPool:\n" +
                enemyPool + "\n";
    }
}

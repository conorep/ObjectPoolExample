package pool;

import object.Enemy;

/**
 * This class represents a pool of Enemies.
 * @author Conor O'Brien
 * @version 1.0
 */
public class EnemyPool<T>
{
    private ObjectPool<Enemy> objectPool;

    /**
     * This is the EnemyPool constructor.
     * @param objectPoolSize int size of objectPool
     */
    public EnemyPool(int objectPoolSize)
    {
        this.objectPool = new ObjectPool<>(objectPoolSize)
        {
            @Override
            protected Enemy createObject()
            {
                return new Enemy();
            }
        };
    }

    /**
     * Draw out an enemy to fight them!
     * @return Enemy object
     */
    public Enemy fightEnemy()
    {
        return objectPool.borrowObject();
    }

    //TODO: if dead.... should I auto-trigger this?
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
        objectPool.returnObject(enemy);
    }

    @Override
    public String toString()
    {
        return "EnemyPool:\n" +
                objectPool + "\n";
    }
}

package pool;

import data.EnemyInfo;
import object.Enemy;

import java.util.List;

/**
 * This class represents a pool of Enemies.
 * @author Conor O'Brien
 * @version 1.0
 */
public class EnemyPool<T>
{
    private ObjectPool<Enemy> objectPool;
    private EnemyInfo enemyInfo = EnemyInfo.getInstance();

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
                /*name, hit points, list of abilities*/
                //TODO: this needs to be dynamic-ish
                return new Enemy(enemyInfo.getRandomName(), enemyInfo.getRandomHitPoints(),
                        List.of("scratch", "roll", "sleep"));
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
    public void returnEnemy(Enemy enemy)
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

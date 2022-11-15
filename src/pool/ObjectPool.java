package pool;

import java.util.ArrayDeque;

/**
 * This abstract class represents the Object Pool that is used in this project.
 * @author Conor O'Brien
 * @version 1.0
 * @param <T> generic Object type.
 */
public abstract class ObjectPool<T>
{
    private ArrayDeque<T> poolStorage;
    private int poolCapacity;

    /**
     * This is our constructor. It requires an integer value of the size of the arrayDeque (stack) that we are using.
     * @param poolStorageSize int size of poolStorage
     */
    public ObjectPool(final int poolStorageSize)
    {
        initialize(poolStorageSize);
        poolCapacity = poolStorageSize;
    }

    /**
     * This method returns the max capacity of the pool storage object.
     * @return int capacity
     */
    public int getCapacity()
    {
        return poolCapacity;
    }

    /**
     * This 'checks out' an object from the pool, removing an object from the end of the collection.
     * If there are no longer items to check out, writes to console and returns null.
     * @return T object that was requested from client
     */
    public T borrowObject()
    {
        if(poolStorage.peek() != null)
        {
            return poolStorage.pop();
        } else
        {
            System.out.println("The pool is currently empty.");
            return null;
        }
    }

    /**
     * This returns an object to the pool (placing it in the front of the collection).
     * It checks for the pool's max capacity and won't allow adding more than that.
     * @param object T object requested from pool
     */
    public void returnObject(T object)
    {
        if(poolStorage.size() == poolCapacity)
        {
            System.out.println("Can't add any more! This pool has a max capacity.");
        } else
        {
            poolStorage.addLast(object);
        }
    }

    /**
     * This abstract class adds objects to the pool. It's accessed via initialize().
     * @return T object to add to collection
     */
    protected abstract T createObject();

    /**
     * This method creates an ArrayDeque with the required storage size.
     * @param poolStorageSize int size of ArrayDeque
     */
    private void initialize(final int poolStorageSize)
    {
        poolStorage = new ArrayDeque<>(poolStorageSize);
        for (int x = 0; x < poolStorageSize; x++)
        {
            poolStorage.add(createObject());
        }
    }

    /*String representation of pool contents*/
    @Override
    public String toString()
    {
        return "Stored Contents:\n" + poolStorage + '\n';
    }
}

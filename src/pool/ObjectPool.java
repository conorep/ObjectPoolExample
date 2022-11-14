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
    //TODO: think about NOT using ArrayDeque. Want to be able to put dead enemies on bottom or something.
    private ArrayDeque<T> poolStorage;

    /**
     * This is our constructor. It requires an integer value of the size of the arrayDeque (stack) that we are using.
     * @param poolStorageSize int size of poolStorage
     */
    public ObjectPool(final int poolStorageSize)
    {
        initialize(poolStorageSize);
    }

    /**
     * This 'checks out' an object from the pool.
     *  If there are no longer items to check out, writes to console and returns null.
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
     * This returns an object to the pool.
     * @param object T object requested from pool
     */
    public void returnObject(T object)
    {
        poolStorage.add(object);
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

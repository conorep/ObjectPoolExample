package devExamplePool;

/**
 * This abstract class will represent the Object Pool that is used in this project.
 * @author Conor O'Brien
 * @version 1.0
 * @param <T> generic Object type.
 */
public abstract class ObjectPoolDev<T>
{
    //TODO: create fields for collection and capacity access


    //TODO: create constructor


    //TODO: create capacity getter


    //TODO: create borrow object method


    //TODO: create return object method

    /**
     * This abstract method adds objects to the pool. It's accessed via initialize().
     * @return T object to add to collection
     */
    protected abstract T createObject();

    //TODO: create initialize method (called in constructor)


}

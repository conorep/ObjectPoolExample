package pool;

/**
 * This class represents a database connection object.
 *  It implements the runnable class to allow multithreaded access to the DB.
 * @author Conor O'Brien
 * @version 1.0
 */
public class DatabaseConnection implements Runnable
{
    private static int threadNumber;

    /**
     * This is the DBConnection constructor. It increments the threadNumber field.
     *  Note: the first thread will be 1.
     */
    public DatabaseConnection()
    {
        incrementThread();
    }

    @Override
    public void run()
    {

    }

    //TODO: do I need this...?
    /**
     * This increments the current connection number and returns it for database connection thread tracking.
     */
    public static void incrementThread()
    {
        threadNumber++;
    }

    public int getThreadNumber()
    {
        return threadNumber;
    }
}

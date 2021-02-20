package part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Proxy class for DataBaseTable
 * It ensures that the reader does not enter while writer sets the table and vice versa.
 */
public class ProxyDataBaseTableA implements ITable {
    private int AR = 0; //active reader
    private int AW = 0; //active writer
    private final Lock lock = new ReentrantLock();
    private final Condition okToRead = lock.newCondition();
    private final Condition okToWrite = lock.newCondition();
    private final DataBaseTable dataBaseTable;

    /**
     * Constructor to initialize DataBaseTable object
     * @param dataBaseTable DataBaseTable object
     */
    public ProxyDataBaseTableA(DataBaseTable dataBaseTable){
        this.dataBaseTable = dataBaseTable;
    }

    /**
     * If a reader thread call getElementAt method and a writer thread sets the table,
     * reader thread wait for writer thread.
     * If a reader thread call getElementAt method and another reader thread calls the getElementAt;
     * it allows both because no thread set the table
     * @param row row index
     * @param column column index
     * @return Returns element in specified row and column
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    @Override
    public Object getElementAt(int row, int column) throws InterruptedException {
        Object retVal;
        
        System.out.println("READER: One of the threads enters the getElementAt method. AR=" + AR + " AW=" + AW );
        //Thread.sleep(3000);
        lock.lock();
        System.out.println("READER: One of the threads takes the lock and it will check conditions. AR=" + AR + " AW=" + AW );

        while (AW > 0){
            System.out.println("READER: One of the threads is waiting to meet the condition. AR=" + AR + " AW=" + AW );
            okToRead.await();
        }

        ++AR;
        lock.unlock();

        System.out.println("READER: One of the threads met the condition and gets the element. AR=" + AR + " AW=" + AW );
        retVal = dataBaseTable.getElementAt(row, column);

        lock.lock();

        --AR;

        if(AR == 0)
            okToWrite.signal();

        System.out.println("READER: One of the threads read the table and leaving the method. AR=" + AR + " AW=" + AW );
        lock.unlock();

        return retVal;
    }

    /**
     * If a writer thread call setElementAt method and if a reader thread read the table,
     * or a writer thread sets the table, writer thread wait for this thread.
     * @param row row index
     * @param column column index
     * @param o element to write in the table
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    @Override
    public void setElementAt(int row, int column, Object o) throws InterruptedException {
        System.out.println("WRITER: One of the threads enters the setElementAt method. AR=" + AR + " AW=" + AW );
        lock.lock();
        System.out.println("WRITER: One of the threads takes the lock and it will check conditions. AR=" + AR + " AW=" + AW );

        //Thread.sleep(3000);

        while ((AR + AW) > 0){
            System.out.println("WRITER: One of the threads is waiting to meet the conditions. AR=" + AR + " AW=" + AW );
            okToWrite.await();
        }

        ++AW;
        lock.unlock();

        System.out.println("WRITER: One of the threads met the conditions and sets the element. AR=" + AR + " AW=" + AW );
        dataBaseTable.setElementAt(row, column, o);

        lock.lock();
        --AW;

        okToRead.signalAll();
        okToWrite.signal();

        System.out.println("WRITER: One of the threads wrote to the table and leaving the method. AR=" + AR + " AW=" + AW );
        lock.unlock();
    }

    /**
     * gets the number of rows
     * @return Returns the number of rows
     */
    @Override
    public int getNumberOfRows() {
       return dataBaseTable.getNumberOfRows();
    }

    /**
     * gets the number of columns
     * @return Returns the number of columns
     */
    @Override
    public int getNumberOfColumns() {
        return dataBaseTable.getNumberOfColumns();
    }
}

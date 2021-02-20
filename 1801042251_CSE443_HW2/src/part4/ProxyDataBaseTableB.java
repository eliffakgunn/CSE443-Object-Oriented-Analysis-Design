package part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProxyDataBaseTableB implements ITable {
    private int AR = 0; //active reader
    private int WR = 0; //waiting reader
    private int AW = 0; //active writer
    private int WW = 0; //waiting writer
    private final Lock lock = new ReentrantLock();
    private final Condition okToRead = lock.newCondition();
    private final Condition okToWrite = lock.newCondition();
    private final DataBaseTable dataBaseTable;

    public ProxyDataBaseTableB(DataBaseTable dataBaseTable){
        this.dataBaseTable = dataBaseTable;
    }

    /**
     * Reader threads wait for waiting writers and active writers
     * @param row row index
     * @param column column index
     * @return Returns element in specified row and column
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    @Override
    public Object getElementAt(int row, int column) throws InterruptedException {
        Object retVal;

        //Thread.sleep(2000);
        System.out.println("READER: One of the threads enters the getElementAt method. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
        lock.lock();
        System.out.println("READER: One of the threads takes the lock and it will check conditions. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);

        while ((AW + WW) > 0){
            ++WR;
             System.out.println("READER: One of the threads is waiting to meet the conditions. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
            okToRead.await();
            --WR;
        }

        //Thread.sleep(3000);
        ++AR;
        lock.unlock();

        System.out.println("READER: One of the threads met the conditions and gets the element. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
        retVal = dataBaseTable.getElementAt(row, column);

        lock.lock();
        --AR;

        if(AR == 0 && WW > 0)
            okToWrite.signal();

        System.out.println("READER: One of the threads read the table and leaving the method. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
        lock.unlock();

        return retVal;
    }

    /**
     * Writer threads wait active writers and active readers
     * @param row row index
     * @param column column index
     * @param o element to write in the table
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    @Override
    public void setElementAt(int row, int column, Object o) throws InterruptedException {
        System.out.println("WRITER: One of the threads enters the setElementAt method. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
        //Thread.sleep(3000);
        lock.lock();
        System.out.println("WRITER: One of the threads takes the lock and it will check conditions. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);

        while ((AW + AR) > 0){
            ++WW;
             System.out.println("WRITER: One of the threads is waiting to meet the conditions. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
            okToWrite.await();
            --WW;
        }

        ++AW;
        lock.unlock();

        System.out.println("WRITER: One of the threads met the conditions and sets the element. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
        dataBaseTable.setElementAt(row, column, o);

        lock.lock();
        --AW;

        if(WW > 0)
            okToWrite.signal();
        else if(WR > 0)
            okToRead.signalAll();

        System.out.println("WRITER: One of the threads wrote to the table and leaving the method. AR=" + AR + " WR=" + WR + " AW=" + AW + " WW=" + WW);
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

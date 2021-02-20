package part4;

public interface ITable{
    /**
     * gets the element that in specified row and column
     * @param row row index
     * @param column column index
     * @return element that in specified row and column
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    Object getElementAt(int row, int column) throws InterruptedException;

    /**
     * sets he element that in specified row and column
     * @param row row index
     * @param column column index
     * @param o element to write in the table
     * @throws InterruptedException throws InterruptedException exception if an error occur
     */
    void setElementAt(int row, int column, Object o) throws InterruptedException;

    /**
     * gets the number of rows
     * @return Returns the number of rows
     */
    int getNumberOfRows();

    /**
     * gets the number of columns
     * @return Returns the number of columns
     */
    int getNumberOfColumns();
}

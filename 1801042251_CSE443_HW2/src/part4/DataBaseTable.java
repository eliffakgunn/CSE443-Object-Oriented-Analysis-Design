package part4;

public class DataBaseTable implements ITable {
    /**
     * gets the element that in specified row and column
     * @param row row index
     * @param column column index
     * @return element that in specified row and column
     */
    @Override
    public Object getElementAt(int row, int column) {
        return null;
    }

    /**
     * sets he element that in specified row and column
     * @param row row index
     * @param column column index
     * @param o element to write in the table
     */
    @Override
    public void setElementAt(int row, int column, Object o) {

    }

    /**
     * gets the number of rows
     * @return Returns the number of rows
     */
    @Override
    public int getNumberOfRows() {
        return 0;
    }

    /**
     * gets the number of columns
     * @return Returns the number of columns
     */
    @Override
    public int getNumberOfColumns() {
        return 0;
    }
}

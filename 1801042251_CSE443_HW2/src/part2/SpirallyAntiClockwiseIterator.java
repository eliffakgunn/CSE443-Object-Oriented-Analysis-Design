package part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Iterator to print a 2D array spirally anti-clockwise
 */
public class SpirallyAntiClockwiseIterator implements Iterator {
    private final ListIterator<Integer> iterator;

    /**
     * Constructor to collect datas in a arraylist
     * @param data 2D array
     */
    public SpirallyAntiClockwiseIterator(int[][] data){
        int row, column, len, rowLen;
        ArrayList<Integer> arr = new ArrayList<>();

        len = data.length;
        rowLen = data[0].length;
        row = column = 0;

        while (len > 0 && rowLen > 0){
            if(len == 1){
                for (int i = 0; i < rowLen; i++)
                    arr.add(data[row++][column]);
            }
            else if(rowLen == 1){
                for (int i = 0; i < len; i++)
                    arr.add(data[row][column++]);
            }
            else {
                for (int i = 0; i < len - 1; i++)
                    arr.add(data[row++][column]);
                for (int i = 0; i < rowLen - 1; i++)
                    arr.add(data[row][column++]);
                for (int i = 0; i < len - 1; i++)
                    arr.add(data[row--][column]);
                for (int i = 0; i < rowLen - 1; i++)
                    arr.add(data[row][column--]);
            }
            len -= 2;
            rowLen -= 2;
            ++row;
            ++column;
        }
        iterator = arr.listIterator();
    }

    /**
     * if there are more element returns true
     * @return if there are more element returns true
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * returns the next element
     * @return returns the next element
     */
    @Override
    public Object next() {
        return iterator.next();
    }
}

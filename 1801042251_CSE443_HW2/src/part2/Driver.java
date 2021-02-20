package part2;

/**
 * Driver class fot part2
 */
public class Driver {
    public static void main(String[] args) {
        int row, column;
        row = column = 5;

        int[][] arr = {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}};

        /*int[][] arr = {{1, 2, 3, 4},
                        {6, 7, 8, 9},
                        {11, 12, 13, 14},
                        {16, 17, 18, 19},};*/

        System.out.println("2D Array: ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }

        System.out.println("\nSpirally clockwise:");
        SpirallyClockwiseIterator spirallyClockwiseIterator = new SpirallyClockwiseIterator(arr);
        while (spirallyClockwiseIterator.hasNext()){
            System.out.print(spirallyClockwiseIterator.next() + " ");
        }

        System.out.println("\n\nSpirally anti-clockwise:");
        SpirallyAntiClockwiseIterator spirallyAntiClockwiseIterator = new SpirallyAntiClockwiseIterator(arr);
        while (spirallyAntiClockwiseIterator.hasNext()){
            System.out.print(spirallyAntiClockwiseIterator.next() + " ");
        }
    }
}

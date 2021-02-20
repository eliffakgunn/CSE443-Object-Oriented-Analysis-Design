package Part1;

/**
 * this class solves equations with matrix inversion method
 */
public class MatrixInversion implements SolvingMethod{
    private final double[][] coeffs; //matrix of coefficients
    private final double[] solution; //matrix of RHS of equations

    /**
     * initialize matrices
     * @param coeffs is matrix of coefficients
     * @param solution is matrix of RHS of equations
     */
    public MatrixInversion(double[][] coeffs, double[] solution){
        this.coeffs = coeffs;
        this.solution = solution;
    }

    /**
     * Solves equations with matrix inversion method
     * @return solution matix
     * @throws ArithmeticException exception
     */
    @Override
    public double[] solve() throws ArithmeticException {

        //check equations
        checkSolution();

        //AX=B => X=(A^(-1))*B
        double deter=determinant(coeffs, coeffs.length);
        double[][] inverse = inverse(coeffs, deter);

        return multiply(inverse, solution);
    }

    /**
     * helper function
     * calculates determinant of coefficient matrix
     * @param coeffs is matrix of coefficients
     * @param size is size of coefficients matrix
     * @return determinant of matrix
     */
    private double determinant(double[][] coeffs,int size){
        double[][] temp = new double[size][size];
        double det=0;

        if (size == 1)
            return coeffs[0][0];
        else if(size== 2)
            return (coeffs[0][0]*coeffs[1][1]-coeffs[0][1]*coeffs[1][0]);
        else {
            for (int i = 0; i < size; ++i) {
                calculateMinors(temp, coeffs, i); //calculate minors to calculate determinant
                det = det + coeffs[0][i] * Math.pow(-1, i) * determinant(temp, (size - 1));
            }
        }
        return det;
    }

    /**
     * heloer function
     * calculate inverse of coefficients matrix
     * @param coeffs is matrix of coefficients
     * @param det determinant of matrix
     * @return inverse of coefficients matrix
     */
    private double [][] inverse(double[][] coeffs, double det){
        double[][] temp = new double[coeffs.length][coeffs.length];
        //helper matrices
        double[][] matrix1 = new double[coeffs.length][coeffs.length];
        double[][] matrix2 = new double[coeffs.length][coeffs.length];

        //when det=0, 1/0 occurs and it is infinite
        if(det == 0)
            throw new ArithmeticException();
        else if(coeffs.length == 1)
            temp[0][0] = 1;
        else {
            int m,n;
            for (int i=0; i<coeffs.length; ++i)
                for (int j=0;j<coeffs.length; ++j){
                    m = n = 0;
                    for (int k=0; k<coeffs.length; ++k) {
                        for (int l = 0; l < coeffs.length; ++l) {
                            if (k != i && l != j) {
                                matrix1[m][n] = coeffs[k][l];
                                if (n < (coeffs.length - 2))
                                    ++n;
                                else {
                                    n = 0;
                                    ++m;
                                }
                            }
                        }
                    }
                    matrix2[i][j] = determinant(matrix1,(coeffs.length-1))*Math.pow(-1,(i+j));
                }
        }
        return transpose(matrix2,temp,det);
    }

    /**
     * heloer function
     * calculates transpose of matrix
     * @param m1 helper matrix 1
     * @param m2 helper matrix 2
     * @param det determinant of coefficient matrix
     * @return inverse of coefficient matrix
     */
    private  double[][] transpose(double[][] m1,double[][] m2,double det){
        double[][] temp = new double[m1.length][m1.length];
        for (int i=0; i<m1.length; ++i) {
            for (int j = 0; j < m1.length; ++j)
                temp[i][j] = m1[j][i];
        }
        for (int i=0; i<m1.length; ++i) {
            for (int j = 0; j < m1.length; ++j)
                m2[i][j] = temp[i][j] / det;
        }

        return m2;
    }

    /**
     * helper funtion
     * determines minors of coefficient matrix to calculate inverse
     * @param temp helper matrix
     * @param coeffs coefficient matrix
     * @param ind is necessary for minor calculation
     */
    private void calculateMinors(double[][] temp,double[][] coeffs,int ind){
        int m=0, n=0;
        for(int i=1; i<coeffs.length; ++i) {
            for (int j = 0; j<coeffs.length; ++j) {
                if(j != ind) {
                    temp[m][n] = coeffs[i][j];
                    ++n;
                    if (n == (coeffs.length - 1)) {
                        ++m;
                        n = 0;
                    }
                }
            }
        }
    }

    /**
     * helper function
     * multiplies two matrices
     * @param matrix1 one of matrices
     * @param matrix2 another matrix
     * @return multiplication of matrices
     */
    private double[] multiply(double[][] matrix1, double[] matrix2){
        double[] res = new double[matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            res[i] = 0;
            for (int j = 0; j < matrix1.length; j++) {
                res[i] += matrix1[i][j]* matrix2[j];
            }
        }

        return res;
    }

    /**
     * helper function
     * checks if the solution is exist
     */
    private void checkSolution(){
        double temp, EPSILON = 1e-10;
        double[][] coeffsCopy = coeffs;
        double[] arr, solutionCopy = solution;

        for (int i = 0; i < coeffsCopy.length; i++) {
            int pivot = i; //pivot for swaps
            for (int j = i + 1; j < coeffsCopy.length; j++) {
                if (Math.abs(coeffsCopy[j][i]) > Math.abs(coeffsCopy[pivot][i]))
                    pivot = j;
            }

            arr = coeffsCopy[i];
            coeffsCopy[i] = coeffsCopy[pivot];
            coeffsCopy[pivot] = arr;

            temp = solutionCopy[i];
            solutionCopy[i] = solutionCopy[pivot];
            solutionCopy[pivot] = temp;

            //check whether the equations can be solved or not
            if (Math.abs(coeffsCopy[i][i]) <= EPSILON)
                throw new ArithmeticException();

            //Multiplying by the required coefficients
            for (int j = i + 1; j < coeffsCopy.length; j++) {
                temp = coeffsCopy[j][i] / coeffsCopy[i][i];
                solutionCopy[j] -= solutionCopy[i] * temp;

                for (int k = i; k < coeffsCopy.length; k++)
                    coeffsCopy[j][k] -= coeffsCopy[i][k] * temp;
            }
        }
    }
}

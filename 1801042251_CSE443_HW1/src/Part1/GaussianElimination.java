package Part1;

/**
 * this class solves equations with gaussian elimination method
 */
public class GaussianElimination implements SolvingMethod{
    private final double[][] coeffs; //matrix of coefficients
    private final double[] solution; //matrix of RHS of equations

    /**
     * initialize matrices
     * @param coeffs is matrix of coefficients
     * @param solution is matrix of RHS of equations
     */
    public GaussianElimination(double[][] coeffs, double[] solution){
        this.coeffs = coeffs;
        this.solution = solution;
    }

    /**
     * Solves equations with gaussian elimination method
     * @return solution matix
     * @throws ArithmeticException exp
     */
    @Override
    public double[] solve() throws ArithmeticException{
        elimination();
        return backSubs();
    }

    /**
     * helper function
     * transfers the matrix like this format for back substitution:
     * |N N N|
     * |0 N N|
     * |0 0 N|
     */
    private void elimination(){
        double temp, EPSILON = 1e-10; //epsilon for error checking

        for (int i = 0; i < coeffs.length; i++) {
            int pivot = i; //pivot for row swaps
            for (int j = i + 1; j < coeffs.length; j++) {
                if (Math.abs(coeffs[j][i]) > Math.abs(coeffs[pivot][i]))
                    pivot = j;
            }

            swap_coeffs(i, pivot);
            swap_solution(i, pivot);

            //check whether the equations can be solved or not
            if (Math.abs(coeffs[i][i]) <= EPSILON) 
                throw new ArithmeticException();

            //Multiplying by the required coefficients makes elimination
            for (int j = i + 1; j < coeffs.length; j++) {
                temp = coeffs[j][i] / coeffs[i][i];
                solution[j] -= solution[i] * temp;

                for (int k = i; k < coeffs.length; k++)
                    coeffs[j][k] -= coeffs[i][k] * temp;
            }
        }
    }

    /**
     * helper function
     * makes back substitution and find answer
     * @return solution matrix
     */
    private double[] backSubs(){
        double[] answer = new double[coeffs.length];
        for (int i = coeffs.length - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < coeffs.length; j++) {
                sum += coeffs[i][j] * answer[j];
            }
            answer[i] = (solution[i] - sum) / coeffs[i][i];
        }
        return answer;
    }

    /**
     * helper function
     * swaps rows of coeffs for elimination
     * @param i indis i
     * @param pivot indis pivot
     */
    private void swap_coeffs(int i, int pivot){
        double[] arr = coeffs[i];
        coeffs[i] = coeffs[pivot];
        coeffs[pivot] = arr;
    }

    /**
     * helper function
     * swaps element of solution matrix for elimination
     * @param i indis i
     * @param pivot indis pivot
     */private void swap_solution(int i, int pivot){
        double temp = solution[i];
        solution[i] = solution[pivot];
        solution[pivot] = temp;
    }
}

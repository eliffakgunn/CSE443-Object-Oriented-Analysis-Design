package Part1;

/**
 * helps to change between solving methods dynamically
 */
public class LinearSolver {
    SolvingMethod solvingMethod;

    /**
     * initialize solvingMethod
     * @param solveMethod solution method
     */
    public LinearSolver(SolvingMethod solveMethod) {
        this.solvingMethod = solveMethod;
    }

    /**
     * solves equations according to chosen method
     * @return solution matrix
     */
    public double[] solve(){
        return solvingMethod.solve();
    }
}

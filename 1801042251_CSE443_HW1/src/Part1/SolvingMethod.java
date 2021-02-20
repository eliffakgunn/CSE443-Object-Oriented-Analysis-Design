package Part1;

/**
 * interface for methods
 */
public interface SolvingMethod {
    /**
     * Solves equations acording to choosen method
     * @return solution matix
     * @throws ArithmeticException exp
     */
    double[] solve() throws ArithmeticException;
}

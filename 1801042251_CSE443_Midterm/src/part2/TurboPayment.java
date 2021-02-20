package part2;

/**
 * Interface for old binary library for payment
 */
public interface TurboPayment {
    /**
     * This method pays with old payment method
     * @param turboCardNo card no
     * @param turboAmount  amount of money
     * @param destinationTurboOfCourse destination account
     * @param installmentsButInTurbo installments
     * @return Returns 0 if payment is successful
     */
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}

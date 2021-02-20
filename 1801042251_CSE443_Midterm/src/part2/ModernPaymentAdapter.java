package part2;

/**
 * Adapter class for ModernPayment
 */
public class ModernPaymentAdapter implements TurboPayment {
    /**
     * To delegate payment to ModernPayment class
     */
    ModernPayment modernPayment;

    /**
     * Initializes the modernPayment object
     * @param modernPayment ModernPayment class object
     */
    ModernPaymentAdapter(ModernPayment modernPayment){
        this.modernPayment = modernPayment;
    }

    /**
     * This method delegates the payment to the ModernPayment
     * @param turboCardNo card no
     * @param turboAmount  amount of money
     * @param destinationTurboOfCourse destination account
     * @param installmentsButInTurbo installments
     * @return Returns 0 if payment is successful
     */
    public int payInTurbo(String turboCardNo, float turboAmount,
                          String destinationTurboOfCourse, String installmentsButInTurbo){
        modernPayment.pay(turboCardNo, turboAmount, destinationTurboOfCourse, installmentsButInTurbo);
        return 0;
    }
}

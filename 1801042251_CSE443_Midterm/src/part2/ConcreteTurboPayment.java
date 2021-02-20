package part2;

/**
 * Concrete class for TurboPayment
 */
public class ConcreteTurboPayment implements TurboPayment {
    /**
     * This method pays with old payment method
     * @param turboCardNo card no
     * @param turboAmount  amount of money
     * @param destinationTurboOfCourse destination account
     * @param installmentsButInTurbo installments
     * @return Returns 0 if payment is successful
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount,
                          String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("You Are in ConcreteTurboPayment Class");
        System.out.println("Card No: " + turboCardNo);
        System.out.println("Amount: " + turboAmount);
        System.out.println("Destination: " + destinationTurboOfCourse);
        System.out.println("Installments: " + installmentsButInTurbo);

        return 0;
    }
}

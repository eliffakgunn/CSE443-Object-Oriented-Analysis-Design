package part2;

/**
 * Concrete class for ModernPayment
 */
public class ConcreteModernPayment implements ModernPayment {
    /**
     * This method pays with modern payment method
     * @param cardNo card no
     * @param amount amount of money
     * @param destination destination account
     * @param installments installments
     * @return Returns 0 if payment is successful
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("You Are in ConcreteModernPayment Class");
        System.out.println("Card No: " + cardNo);
        System.out.println("Amount: " + amount);
        System.out.println("Destination: " + destination);
        System.out.println("Installments: " + installments);

        return 0;
    }
}
